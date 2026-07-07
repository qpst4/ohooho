package com.slideindex.app.otp

import android.accessibilityservice.AccessibilityService
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo
import com.slideindex.app.settings.AppSettings
import java.util.concurrent.atomic.AtomicBoolean

object OtpAutoFillController {
    private const val TAG = "OtpAutoFill"
    private const val CODE_TTL_MS = 5 * 60 * 1000L
    private const val FILL_DEDUPE_MS = 2_000L

    @Volatile
    private var pendingCode: String? = null

    @Volatile
    private var pendingPostedAtMs: Long = 0L

    private val mainHandler = Handler(Looper.getMainLooper())
    private val fillInProgress = AtomicBoolean(false)
    private var pendingFillRunnable: Runnable? = null
    private var fillSessionId = 0

    @Volatile
    private var lastFilledCode: String? = null

    @Volatile
    private var lastFilledTargetKey: String? = null

    @Volatile
    private var lastFilledAtMs: Long = 0L

    fun isFillingActive(): Boolean = fillInProgress.get()

    fun queueCode(code: String) {
        pendingCode = code
        pendingPostedAtMs = System.currentTimeMillis()
        Log.i(TAG, "Queued OTP for auto-fill (${code.length} chars)")
    }

    fun clearPending() {
        pendingCode = null
        pendingPostedAtMs = 0L
    }

    fun hasPendingCode(): Boolean = peekPendingCode() != null

    private fun peekPendingCode(): String? {
        val code = pendingCode ?: return null
        if (System.currentTimeMillis() - pendingPostedAtMs > CODE_TTL_MS) {
            clearPending()
            return null
        }
        return code
    }

    fun scheduleAutoFill(
        service: AccessibilityService,
        settings: AppSettings,
    ) {
        if (!settings.otpAutoInputEnabled) return
        if (peekPendingCode() == null) return
        if (fillInProgress.get()) return

        pendingFillRunnable?.let { mainHandler.removeCallbacks(it) }
        val delayMs = settings.otpAutoInputDelayMs.coerceAtLeast(0).toLong()
        val runnable = Runnable {
            pendingFillRunnable = null
            if (fillInProgress.get()) return@Runnable
            val latestCode = peekPendingCode() ?: return@Runnable
            performAutoFill(service, settings, latestCode)
        }
        pendingFillRunnable = runnable
        mainHandler.postDelayed(runnable, delayMs)
    }

    private fun performAutoFill(
        service: AccessibilityService,
        settings: AppSettings,
        code: String,
    ) {
        if (!fillInProgress.compareAndSet(false, true)) return
        cancelActiveTyping()
        val root = service.rootInActiveWindow
        if (root == null) {
            finishFill()
            return
        }
        if (root.packageName?.toString() == service.packageName) {
            releaseNode(root)
            finishFill()
            return
        }
        try {
            val targets = findOtpTargets(root, settings.otpAccessibilityAssistEnabled)
            if (targets.isEmpty()) {
                Log.d(TAG, "No OTP input target found")
                finishFill()
                return
            }
            if (shouldSkipDuplicateFill(code, targets)) {
                Log.d(TAG, "Skipping duplicate fill for same target")
                targets.forEach { releaseNode(it) }
                finishFill()
                return
            }
            val intervalMs = settings.otpAutoInputIntervalMs.coerceAtLeast(0)
            val session = fillSessionId
            val onComplete: (Boolean) -> Unit = { filled ->
                targets.forEach { releaseNode(it) }
                if (filled) {
                    markFilled(code, targets)
                    pendingCode = null
                    if (settings.otpAutoConfirmEnabled) {
                        mainHandler.postDelayed({
                            performAutoConfirm(service, targets.lastOrNull())
                        }, intervalMs.coerceAtLeast(50).toLong())
                    }
                }
                finishFill()
            }
            if (targets.size > 1 && targets.all { isSingleCharField(it) }) {
                fillSplitFieldsAsync(targets, code, intervalMs, session, onComplete)
            } else {
                fillSingleFieldAsync(targets.first(), code, intervalMs, session, onComplete)
            }
        } finally {
            releaseNode(root)
        }
    }

    private fun finishFill() {
        fillInProgress.set(false)
    }

    private fun cancelActiveTyping() {
        fillSessionId++
    }

    private fun shouldSkipDuplicateFill(
        code: String,
        targets: List<AccessibilityNodeInfo>,
    ): Boolean {
        val key = targetKey(targets)
        val now = System.currentTimeMillis()
        return code == lastFilledCode &&
            key == lastFilledTargetKey &&
            now - lastFilledAtMs < FILL_DEDUPE_MS
    }

    private fun markFilled(code: String, targets: List<AccessibilityNodeInfo>) {
        lastFilledCode = code
        lastFilledTargetKey = targetKey(targets)
        lastFilledAtMs = System.currentTimeMillis()
    }

    private fun targetKey(targets: List<AccessibilityNodeInfo>): String =
        targets.joinToString("|") { nodeTargetKey(it) }

    private fun nodeTargetKey(node: AccessibilityNodeInfo): String {
        val bounds = Rect()
        node.getBoundsInScreen(bounds)
        return buildString {
            append(node.viewIdResourceName ?: "")
            append(':')
            append(bounds.left)
            append(',')
            append(bounds.top)
            append(',')
            append(bounds.right)
            append(',')
            append(bounds.bottom)
        }
    }

    private fun fillSingleFieldAsync(
        node: AccessibilityNodeInfo,
        code: String,
        intervalMs: Int,
        session: Int,
        onComplete: (Boolean) -> Unit,
    ) {
        if (intervalMs <= 0) {
            onComplete(setNodeText(node, code))
            return
        }
        val builder = StringBuilder()
        fun typeChar(index: Int) {
            if (session != fillSessionId) return
            if (index >= code.length) {
                onComplete(true)
                return
            }
            builder.append(code[index])
            if (!setNodeText(node, builder.toString())) {
                onComplete(false)
                return
            }
            if (index < code.lastIndex) {
                mainHandler.postDelayed(
                    { typeChar(index + 1) },
                    intervalMs.coerceAtLeast(20).toLong(),
                )
            } else {
                onComplete(true)
            }
        }
        typeChar(0)
    }

    private fun fillSplitFieldsAsync(
        nodes: List<AccessibilityNodeInfo>,
        code: String,
        intervalMs: Int,
        session: Int,
        onComplete: (Boolean) -> Unit,
    ) {
        val chars = code.take(nodes.size)
        if (intervalMs <= 0) {
            var ok = true
            for (index in chars.indices) {
                if (!setNodeText(nodes[index], chars[index].toString())) {
                    ok = false
                    break
                }
            }
            onComplete(ok)
            return
        }
        fun typeChar(index: Int) {
            if (session != fillSessionId) return
            if (index >= chars.length) {
                onComplete(true)
                return
            }
            if (!setNodeText(nodes[index], chars[index].toString())) {
                onComplete(false)
                return
            }
            if (index < chars.lastIndex) {
                mainHandler.postDelayed(
                    { typeChar(index + 1) },
                    intervalMs.coerceAtLeast(20).toLong(),
                )
            } else {
                onComplete(true)
            }
        }
        typeChar(0)
    }

    private fun setNodeText(node: AccessibilityNodeInfo, text: String): Boolean {
        val args = Bundle().apply {
            putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text)
        }
        if (node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, args)) {
            return true
        }
        if (node.performAction(AccessibilityNodeInfo.ACTION_FOCUS)) {
            return node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, args)
        }
        return false
    }

    private fun performAutoConfirm(
        service: AccessibilityService,
        node: AccessibilityNodeInfo?,
    ) {
        if (node != null) {
            val imeEnterAction = 0x01000008
            if (node.performAction(imeEnterAction)) {
                releaseNode(node)
                return
            }
        }
        releaseNode(node)
        val root = service.rootInActiveWindow ?: return
        try {
            findConfirmButton(root)?.let { button ->
                button.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                releaseNode(button)
            }
        } finally {
            releaseNode(root)
        }
    }

    private fun findConfirmButton(root: AccessibilityNodeInfo): AccessibilityNodeInfo? {
        val keywords = listOf("确认", "确定", "提交", "验证", "submit", "verify", "confirm", "done", "next")
        val stack = ArrayDeque<AccessibilityNodeInfo>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            val owned = node !== root
            try {
                val label = buildString {
                    node.text?.let { append(it) }
                    node.contentDescription?.let { append(it) }
                }.lowercase()
                if (node.isClickable && keywords.any { label.contains(it) }) {
                    return copyNode(node)
                }
                for (i in 0 until node.childCount) {
                    node.getChild(i)?.let { stack.add(it) }
                }
            } finally {
                if (owned) releaseNode(node)
            }
        }
        return null
    }

    private fun findOtpTargets(
        root: AccessibilityNodeInfo,
        assistEnabled: Boolean,
    ): List<AccessibilityNodeInfo> {
        val focused = findFocusedEditable(root)
        if (focused != null) {
            val split = findSplitOtpFields(root)
            if (split.size > 1) return split
            return listOf(focused)
        }
        if (!assistEnabled) return emptyList()
        val hinted = findNodesByOtpHints(root)
        if (hinted.isNotEmpty()) return hinted
        return findLikelyOtpField(root)?.let { listOf(it) } ?: emptyList()
    }

    private fun findFocusedEditable(root: AccessibilityNodeInfo): AccessibilityNodeInfo? {
        val stack = ArrayDeque<AccessibilityNodeInfo>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            val owned = node !== root
            try {
                if (node.isFocused && node.isEditable) {
                    return copyNode(node)
                }
                for (i in 0 until node.childCount) {
                    node.getChild(i)?.let { stack.add(it) }
                }
            } finally {
                if (owned) releaseNode(node)
            }
        }
        return null
    }

    private fun findSplitOtpFields(root: AccessibilityNodeInfo): List<AccessibilityNodeInfo> {
        val fields = mutableListOf<AccessibilityNodeInfo>()
        collectEditableNodes(root, root, fields)
        val singleCharFields = fields.filter { isSingleCharField(it) }
        if (singleCharFields.size >= 4) {
            fields.forEach { releaseNode(it) }
            return singleCharFields.take(8)
        }
        fields.forEach { releaseNode(it) }
        return emptyList()
    }

    private fun isSingleCharField(node: AccessibilityNodeInfo): Boolean {
        val maxLength = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            node.maxTextLength
        } else {
            -1
        }
        return maxLength == 1
    }

    private fun findNodesByOtpHints(root: AccessibilityNodeInfo): List<AccessibilityNodeInfo> {
        val result = mutableListOf<AccessibilityNodeInfo>()
        val stack = ArrayDeque<AccessibilityNodeInfo>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            val owned = node !== root
            try {
                if (node.isEditable && matchesOtpHints(node)) {
                    result.add(copyNode(node))
                }
                for (i in 0 until node.childCount) {
                    node.getChild(i)?.let { stack.add(it) }
                }
            } finally {
                if (owned) releaseNode(node)
            }
        }
        return result
    }

    private fun matchesOtpHints(node: AccessibilityNodeInfo): Boolean {
        val hints = buildList {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                node.hintText?.toString()?.let { add(it) }
            }
            node.contentDescription?.toString()?.let { add(it) }
            node.viewIdResourceName?.let { add(it) }
            node.className?.toString()?.let { add(it) }
        }.joinToString(" ").lowercase()
        return hints.contains("otp") ||
            hints.contains("sms") ||
            hints.contains("one_time") ||
            hints.contains("verification") ||
            hints.contains("verify") ||
            hints.contains("验证码")
    }

    private fun findLikelyOtpField(root: AccessibilityNodeInfo): AccessibilityNodeInfo? {
        val fields = mutableListOf<AccessibilityNodeInfo>()
        collectEditableNodes(root, root, fields)
        val best = fields.firstOrNull { matchesOtpHints(it) }
            ?: fields.firstOrNull()
        fields.forEach { if (it !== best) releaseNode(it) }
        return best?.let { copyNode(it) }
    }

    private fun collectEditableNodes(
        node: AccessibilityNodeInfo,
        root: AccessibilityNodeInfo,
        out: MutableList<AccessibilityNodeInfo>,
    ) {
        val owned = node !== root
        try {
            if (node.isEditable && node.isEnabled && node.isVisibleToUser) {
                out.add(copyNode(node))
            }
            for (i in 0 until node.childCount) {
                node.getChild(i)?.let { collectEditableNodes(it, root, out) }
            }
        } finally {
            if (owned) releaseNode(node)
        }
    }

    private fun copyNode(source: AccessibilityNodeInfo): AccessibilityNodeInfo =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            AccessibilityNodeInfo(source)
        } else {
            @Suppress("DEPRECATION")
            AccessibilityNodeInfo.obtain(source)
        }

    private fun releaseNode(node: AccessibilityNodeInfo?) {
        if (node == null) return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) return
        @Suppress("DEPRECATION")
        node.recycle()
    }
}
