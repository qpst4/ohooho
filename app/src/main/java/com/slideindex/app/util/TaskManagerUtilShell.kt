package com.slideindex.app.util

import android.util.Log
import com.slideindex.app.shizuku.ITaskManagerService
import com.slideindex.app.shizuku.ShizukuUserServiceHost
import com.slideindex.app.shizuku.TaskManagerUserService
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

internal object TaskManagerUtilShell {
    private const val TAG = "TaskManagerUtil"
    private const val SHELL_BINDER_TIMEOUT_MS = 35_000L
    private const val MIN_SHELL_OUTPUT_API = 15
    private const val MIN_PROBE_ROOT_API = 17
    private const val MIN_SHELL_FORCE_ADB_API = 28
    private const val MIN_SHELL_LINE_V1_API = 16

    fun runShellCommandOutput(
        hasPermission: Boolean,
        bindFreshService: (Int) -> ITaskManagerService?,
        vararg cmd: String,
    ): TaskManagerUtil.ShellCommandResult {
        if (!hasPermission) {
            return TaskManagerUtil.ShellCommandResult(exitCode = -1, output = "无 Shizuku 权限")
        }
        val service = bindFreshService(MIN_SHELL_OUTPUT_API) ?: bindFreshService(0)
            ?: return TaskManagerUtil.ShellCommandResult(
                exitCode = -1,
                output = "Shizuku UserService 连接失败，请重启 Shizuku 后重试",
            )
        val raw = invokeBinderWithTimeout<String?>(SHELL_BINDER_TIMEOUT_MS) {
            service.runShellCommandOutput(cmd)
        } ?: return TaskManagerUtil.ShellCommandResult(
            exitCode = -1,
            output = "Shell 命令超时（${SHELL_BINDER_TIMEOUT_MS / 1000}s），请重试",
        )
        return parseShellResultRaw(raw)
    }

    fun probeRootAvailable(
        hasPermission: Boolean,
        bindFreshService: (Int) -> ITaskManagerService?,
        readServiceApi: (ITaskManagerService) -> Int,
    ): Boolean {
        if (!hasPermission) return false
        val service = bindFreshService(MIN_PROBE_ROOT_API)
            ?: bindFreshService(MIN_SHELL_OUTPUT_API)
            ?: return false
        val api = readServiceApi(service)
        if (api >= MIN_PROBE_ROOT_API) {
            return invokeBinderWithTimeout<Boolean>(TaskManagerUtil.ROOT_PROBE_BINDER_TIMEOUT_MS) {
                service.probeRootAvailable()
            } ?: false
        }
        val rootResult = runShellCommandLineDirect(
            service = service,
            command = "id -u",
            useRoot = true,
            timeoutMs = TaskManagerUtil.ROOT_PROBE_BINDER_TIMEOUT_MS,
            readServiceApi = readServiceApi,
        )
        val rootUid = parseNumericUid(rootResult.output)
        if (rootResult.exitCode != 0 || rootUid != 0) return false
        val adbResult = runShellCommandLineDirect(
            service = service,
            command = "id -u",
            useRoot = false,
            timeoutMs = 8_000L,
            readServiceApi = readServiceApi,
        )
        if (adbResult.exitCode != 0) return true
        val adbUid = parseNumericUid(adbResult.output) ?: return false
        return adbUid != 0
    }

    fun runShellCommandLine(
        hasPermission: Boolean,
        bindFreshService: (Int) -> ITaskManagerService?,
        readServiceApi: (ITaskManagerService) -> Int,
        command: String,
        useRoot: Boolean,
        timeoutMs: Long = SHELL_BINDER_TIMEOUT_MS,
    ): TaskManagerUtil.ShellCommandResult {
        if (!hasPermission) {
            return TaskManagerUtil.ShellCommandResult(exitCode = -1, output = "无 Shizuku 权限")
        }
        val trimmed = command.trim()
        if (trimmed.isEmpty()) {
            return TaskManagerUtil.ShellCommandResult(exitCode = -1, output = "命令为空")
        }
        val minApi = if (useRoot) MIN_SHELL_OUTPUT_API else MIN_SHELL_FORCE_ADB_API
        val service = bindFreshService(minApi)
        if (service == null) {
            val clientBuild = TaskManagerUserService.API_VERSION
            return TaskManagerUtil.ShellCommandResult(
                exitCode = -1,
                output = "无法连接 Shell 服务（期望 build=$clientBuild）。\n" +
                    "请点击「重启 Shell 服务」；若仍失败，请完全关闭 Shizuku 与本应用后重试。",
            )
        }
        return runShellCommandLineDirect(
            service = service,
            command = trimmed,
            useRoot = useRoot,
            timeoutMs = timeoutMs,
            requireAdbIdentity = !useRoot,
            readServiceApi = readServiceApi,
        )
    }

    fun <T> invokeBinderWithTimeout(timeoutMs: Long, block: () -> T): T? {
        val executor = Executors.newSingleThreadExecutor()
        return try {
            executor.submit(Callable { block() }).get(timeoutMs, TimeUnit.MILLISECONDS)
        } catch (error: TimeoutException) {
            Log.e(TAG, "Binder call timed out after ${timeoutMs}ms", error)
            null
        } catch (error: Exception) {
            Log.e(TAG, "Binder call failed", error)
            null
        } finally {
            executor.shutdownNow()
        }
    }

    private fun runShellCommandLineDirect(
        service: ITaskManagerService,
        command: String,
        useRoot: Boolean,
        timeoutMs: Long,
        readServiceApi: (ITaskManagerService) -> Int,
        requireAdbIdentity: Boolean = !useRoot,
    ): TaskManagerUtil.ShellCommandResult {
        val api = readServiceApi(service)
        val raw = invokeBinderWithTimeout<String?>(timeoutMs) {
            when {
                api >= MIN_SHELL_FORCE_ADB_API ->
                    service.runShellCommandLine(command, useRoot, false)
                useRoot && api >= MIN_SHELL_OUTPUT_API -> {
                    val args = com.slideindex.app.shell.ShellCommandCodec.buildExecArgs(
                        command,
                        useRoot = true,
                    )
                    service.runShellCommandOutput(args)
                }
                api >= MIN_SHELL_LINE_V1_API ->
                    service.runShellCommandLine(command, useRoot, false)
                else -> null
            }
        }
        if (raw == null) {
            return TaskManagerUtil.ShellCommandResult(
                exitCode = -1,
                output = if (api < MIN_SHELL_OUTPUT_API) {
                    "Shizuku 服务版本过旧 (api=$api)，请重启 Shizuku 后重试"
                } else {
                    "Shell 命令超时（${timeoutMs / 1000}s），请重试"
                },
            )
        }
        return sanitizeAdbShellResult(parseShellResultRaw(raw), requireAdbIdentity)
    }

    private fun sanitizeAdbShellResult(
        result: TaskManagerUtil.ShellCommandResult,
        requireAdbIdentity: Boolean,
    ): TaskManagerUtil.ShellCommandResult {
        if (!requireAdbIdentity || result.exitCode != 0) return result
        if (result.output.startsWith(TaskManagerUserService.SHELL_DOWNGRADE_HINT)) return result
        val uid = parseNumericUid(result.output)
        if (uid == 0) {
            return TaskManagerUtil.ShellCommandResult(
                exitCode = -1,
                output = "命令仍在 root 身份下执行（uid=0）。\n" +
                    "adb 模式应返回 uid=2000。\n" +
                    "若 Shizuku 以 Root 启动，请改用无线调试/adb 方式启动 Shizuku，" +
                    "或在 APatch 中取消 Shell 的永久 Root 授权。",
            )
        }
        return result
    }

    private fun parseShellResultRaw(raw: String?): TaskManagerUtil.ShellCommandResult {
        if (raw.isNullOrBlank()) {
            return TaskManagerUtil.ShellCommandResult(
                exitCode = -1,
                output = "Shell 服务无响应。请完全关闭并重启 Shizuku，然后重新打开本应用",
            )
        }
        return parseShellCommandOutput(raw)
    }

    private fun parseShellCommandOutput(raw: String): TaskManagerUtil.ShellCommandResult {
        val marker = "\n---\n"
        val index = raw.indexOf(marker)
        if (index < 0) {
            return TaskManagerUtil.ShellCommandResult(exitCode = -1, output = raw)
        }
        val exitCode = raw.substring(0, index).toIntOrNull() ?: -1
        val output = raw.substring(index + marker.length)
        return TaskManagerUtil.ShellCommandResult(exitCode, output)
    }

    private fun parseNumericUid(output: String): Int? {
        val trimmed = output.trim()
        trimmed.toIntOrNull()?.let { return it }
        return Regex("""uid=(\d+)""").find(trimmed)?.groupValues?.get(1)?.toIntOrNull()
    }
}
