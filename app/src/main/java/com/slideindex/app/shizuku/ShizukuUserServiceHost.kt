package com.slideindex.app.shizuku

import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.content.pm.PackageManager
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import rikka.shizuku.Shizuku
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Owns Shizuku UserService bind / unbind / restart lifecycle.
 *
 * Do not pin [TaskManagerUserService] to a fixed android:process in the manifest —
 * Shizuku uses [Shizuku.UserServiceArgs.processNameSuffix] to pick the remote process.
 */
object ShizukuUserServiceHost {

    private const val TAG = "ShizukuUserServiceHost"
    private const val BIND_TIMEOUT_MS = 12_000L
    private const val RESTART_ATTEMPTS = 4
    private const val RESTART_DELAY_MS = 600L

    /** Bump when the remote service ABI changes; drives processNameSuffix. */
    const val SERVICE_BUILD = 30

    private val mainHandler = Handler(Looper.getMainLooper())
    private val bindLock = Any()

    @Volatile
    private var service: ITaskManagerService? = null

    @Volatile
    private var cachedArgs: Shizuku.UserServiceArgs? = null

    @Volatile
    private var pendingBindLatch: CountDownLatch? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            service = if (binder != null && binder.pingBinder()) {
                ITaskManagerService.Stub.asInterface(binder)
            } else {
                Log.e(TAG, "connected with dead binder")
                null
            }
            if (service != null) {
                val api = readApi(service)
                Log.i(TAG, "connected api=$api build=$SERVICE_BUILD")
            }
            finishBindAttempt()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.w(TAG, "disconnected")
            service = null
            finishBindAttempt()
        }
    }

    fun peek(): ITaskManagerService? =
        service?.takeIf { it.asBinder().pingBinder() }

    fun readApi(taskService: ITaskManagerService?): Int =
        taskService?.let { runCatching { it.apiVersion }.getOrDefault(0) } ?: 0

    fun hasShizukuPermission(context: Context): Boolean =
        runCatching { Shizuku.pingBinder() }.getOrDefault(false) &&
            Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED

    /**
     * Returns a live UserService whose [ITaskManagerService.getApiVersion] is at least [minApi],
     * or null when Shizuku is unavailable / the remote process cannot be started.
     */
    fun ensure(context: Context, minApi: Int = 0): ITaskManagerService? {
        if (!hasShizukuPermission(context)) return null

        synchronized(bindLock) {
            val live = peek()
            if (live != null) {
                val api = readApi(live)
                if (api >= minApi) return live
                Log.w(TAG, "stale api=$api need=$minApi, dropping")
                dropLocked(context)
            }
        }

        repeat(RESTART_ATTEMPTS) { attempt ->
            val bound = bindBlocking(context) ?: run {
                Log.w(TAG, "bind attempt #$attempt returned null")
                Thread.sleep(RESTART_DELAY_MS)
                return@repeat
            }
            val api = readApi(bound)
            if (api >= minApi) return bound

            Log.w(TAG, "bound api=$api still below $minApi on attempt #$attempt, dropping")
            synchronized(bindLock) { dropLocked(context) }
            Thread.sleep(RESTART_DELAY_MS)
        }
        return null
    }

    /** Force-kill remote process and bind a fresh one. Returns connected api, or -1. */
    fun restart(context: Context): Int {
        synchronized(bindLock) { dropLocked(context) }
        val bound = ensure(context, minApi = 0)
        return readApi(bound).takeIf { it > 0 } ?: -1
    }

    fun drop(context: Context) {
        synchronized(bindLock) { dropLocked(context) }
    }

    private fun dropLocked(context: Context) {
        runCatching { service?.destroy() }
        unbindAllKnownBuilds(context)
        service = null
        cachedArgs = null
        finishBindAttempt()
    }

    private fun unbindAllKnownBuilds(context: Context) {
        runCatching {
            cachedArgs?.let { Shizuku.unbindUserService(it, connection, true) }
        }
        // Legacy manifest pinned :task_manager_v10 — always try to tear it down.
        val legacySuffixes = buildList {
            add("task_manager_v10")
            for (build in SERVICE_BUILD downTo (SERVICE_BUILD - 8).coerceAtLeast(1)) {
                add("task_manager_v$build")
            }
            add("task_manager")
        }.distinct()
        for (suffix in legacySuffixes) {
            runCatching {
                Shizuku.unbindUserService(buildArgs(context, suffix), connection, true)
            }
        }
    }

    private fun bindBlocking(context: Context): ITaskManagerService? {
        peek()?.let { return it }

        var latch: CountDownLatch
        var shouldBind = false

        synchronized(bindLock) {
            peek()?.let { return it }
            val inFlight = pendingBindLatch
            if (inFlight != null) {
                latch = inFlight
            } else {
                latch = CountDownLatch(1)
                pendingBindLatch = latch
                shouldBind = true
            }
        }

        if (shouldBind) {
            val bindAction = Runnable {
                runCatching {
                    Shizuku.bindUserService(currentArgs(context), connection)
                }.onFailure { error ->
                    Log.e(TAG, "bindUserService failed", error)
                    finishBindAttempt()
                }
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                bindAction.run()
            } else {
                mainHandler.post(bindAction)
            }
        }

        return try {
            if (!latch.await(BIND_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                Log.w(TAG, "bind timed out after ${BIND_TIMEOUT_MS}ms")
                finishBindAttempt()
            }
            peek()
        } catch (error: InterruptedException) {
            Log.e(TAG, "bind interrupted", error)
            finishBindAttempt()
            null
        }
    }

    private fun currentArgs(context: Context): Shizuku.UserServiceArgs {
        cachedArgs?.let { return it }
        return buildArgs(context, "task_manager_v$SERVICE_BUILD")
            .also { cachedArgs = it }
    }

    private fun buildArgs(context: Context, suffix: String): Shizuku.UserServiceArgs =
        Shizuku.UserServiceArgs(
            ComponentName(context.packageName, TaskManagerUserService::class.java.name),
        )
            .daemon(true)
            .processNameSuffix(suffix)
            .tag("TaskManagerUserService_$suffix")
            .version(SERVICE_BUILD)

    private fun finishBindAttempt() {
        synchronized(bindLock) {
            pendingBindLatch?.countDown()
            pendingBindLatch = null
        }
    }
}
