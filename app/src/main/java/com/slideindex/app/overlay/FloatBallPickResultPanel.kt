package com.slideindex.app.overlay

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import android.widget.Toast
import com.slideindex.app.R
import com.slideindex.app.di.OverlayDependencyAccess
import com.slideindex.app.ui.theme.SlideIndexTheme
import kotlin.math.roundToInt

private const val PANEL_MARGIN_DP = 12f
private const val PANEL_MAX_WIDTH_DP = 300f

/**
 * FV-style floating action panel after float-ball text pick / regional screenshot.
 */
object FloatBallPickResultPanel {
    private const val TAG = "FloatBallPickPanel"

    private val mainHandler = Handler(Looper.getMainLooper())

    private var windowManager: WindowManager? = null
    private var composeView: ComposeView? = null
    private var owner: OverlayComposeOwner? = null
    private var screenOffReceiver: BroadcastReceiver? = null
    private var appContext: Context? = null
    private var layoutParams: WindowManager.LayoutParams? = null

    private var loadingState: MutableState<Boolean>? = null
    private var textState: MutableState<String?>? = null
    private var screenshotState: MutableState<Bitmap?>? = null
    private var anchorState: MutableState<androidx.compose.ui.geometry.Offset>? = null

    val isShowing: Boolean get() = composeView != null

    fun showLoading(context: Context, anchorX: Float, anchorY: Float) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { showLoading(context, anchorX, anchorY) }
            return
        }
        val hostContext = OverlayDependencyAccess.overlayHostContext() ?: context.applicationContext
        ensureWindow(hostContext, anchorX, anchorY)
        loadingState?.value = true
        textState?.value = null
        screenshotState?.value?.recycle()
        screenshotState?.value = null
    }

    fun showResult(context: Context, anchorX: Float, anchorY: Float, result: FloatBallPickResult) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { showResult(context, anchorX, anchorY, result) }
            return
        }
        val hostContext = OverlayDependencyAccess.overlayHostContext() ?: context.applicationContext
        ensureWindow(hostContext, anchorX, anchorY)
        loadingState?.value = false
        textState?.value = result.text
        screenshotState?.value?.recycle()
        screenshotState?.value = result.screenshot
        if (result.text.isNullOrBlank() && result.screenshot == null) {
            Toast.makeText(hostContext, R.string.float_ball_text_not_found, Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    fun dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { dismiss() }
            return
        }
        screenshotState?.value?.recycle()
        screenshotState?.value = null
        val wm = windowManager
        composeView?.let { view -> wm?.let { runCatching { it.removeView(view) } } }
        screenOffReceiver?.let { receiver ->
            appContext?.let { ctx -> runCatching { ctx.unregisterReceiver(receiver) } }
        }
        OverlayCompose.disposeComposeView(composeView)
        owner?.destroy()
        owner = null
        composeView = null
        layoutParams = null
        windowManager = null
        loadingState = null
        textState = null
        screenshotState = null
        anchorState = null
        screenOffReceiver = null
        appContext = null
    }

    private fun ensureWindow(context: Context, anchorX: Float, anchorY: Float) {
        if (composeView != null) {
            repositionPanel(context, anchorX, anchorY)
            return
        }

        val loadingHolder = mutableStateOf(true)
        val textHolder = mutableStateOf<String?>(null)
        val screenshotHolder = mutableStateOf<Bitmap?>(null)
        val anchorHolder = mutableStateOf(androidx.compose.ui.geometry.Offset(anchorX, anchorY))
        loadingState = loadingHolder
        textState = textHolder
        screenshotState = screenshotHolder
        anchorState = anchorHolder

        val dialogOwner = OverlayComposeOwner()
        val overlayContext = OverlayCompose.themedContext(context)
        val compose = OverlayCompose.createComposeView(overlayContext, dialogOwner).apply {
            setContent {
                val loading by loadingHolder
                val text by textHolder
                val screenshot by screenshotHolder
                val anchor by anchorHolder
                FloatBallPickResultContent(
                    anchor = anchor,
                    loading = loading,
                    text = text,
                    screenshot = screenshot,
                    onDismiss = { dismiss() },
                    onCopy = {
                        val value = textHolder.value ?: return@FloatBallPickResultContent
                        FloatBallTextPick.copyText(context, value)
                        Toast.makeText(context, R.string.float_ball_text_copied, Toast.LENGTH_SHORT).show()
                    },
                    onSearch = {
                        val value = textHolder.value ?: return@FloatBallPickResultContent
                        FloatBallTextPick.searchText(context, value)
                    },
                    onShareText = {
                        val value = textHolder.value ?: return@FloatBallPickResultContent
                        FloatBallTextPick.shareText(context, value)
                    },
                    onSaveScreenshot = {
                        val bitmap = screenshotHolder.value ?: return@FloatBallPickResultContent
                        val saved = FloatBallTextPick.saveScreenshot(context, bitmap)
                        Toast.makeText(
                            context,
                            if (saved) R.string.float_ball_screenshot_saved else R.string.float_ball_action_failed,
                            Toast.LENGTH_SHORT,
                        ).show()
                    },
                    onShareScreenshot = {
                        val bitmap = screenshotHolder.value ?: return@FloatBallPickResultContent
                        FloatBallTextPick.shareScreenshot(context, bitmap)
                    },
                )
            }
        }

        val wm = context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
            ?: run {
                dialogOwner.destroy()
                return
            }
        val params = buildLayoutParams(context)
        val added = runCatching { wm.addView(compose, params) }.isSuccess
        if (!added) {
            dialogOwner.destroy()
            Log.e(TAG, "failed to add pick result panel")
            return
        }

        windowManager = wm
        composeView = compose
        owner = dialogOwner
        layoutParams = params
        appContext = context
        registerScreenOffReceiver(context)
    }

    private fun repositionPanel(context: Context, anchorX: Float, anchorY: Float) {
        anchorState?.value = androidx.compose.ui.geometry.Offset(anchorX, anchorY)
    }

    private fun buildLayoutParams(context: Context): WindowManager.LayoutParams {
        return WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            OverlayWindowTypes.overlayWindowType(context),
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            PixelFormat.TRANSLUCENT,
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
    }

    private fun registerScreenOffReceiver(context: Context) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(receiverContext: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_SCREEN_OFF) dismiss()
            }
        }
        screenOffReceiver = receiver
        runCatching { context.registerReceiver(receiver, IntentFilter(Intent.ACTION_SCREEN_OFF)) }
    }
}

@Composable
private fun FloatBallPickResultContent(
    anchor: androidx.compose.ui.geometry.Offset,
    loading: Boolean,
    text: String?,
    screenshot: Bitmap?,
    onDismiss: () -> Unit,
    onCopy: () -> Unit,
    onSearch: () -> Unit,
    onShareText: () -> Unit,
    onSaveScreenshot: () -> Unit,
    onShareScreenshot: () -> Unit,
) {
    val density = LocalDensity.current
    val marginPx = with(density) { PANEL_MARGIN_DP.dp.roundToPx() }
    val panelOffset = IntOffset(
        (anchor.x - with(density) { (PANEL_MAX_WIDTH_DP.dp / 2).roundToPx() }).roundToInt()
            .coerceAtLeast(marginPx),
        (anchor.y + marginPx).roundToInt(),
    )

    SlideIndexTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.12f))
                .clickable(onClick = onDismiss),
        ) {
            Column(
                modifier = Modifier
                    .offset { panelOffset }
                    .widthIn(max = PANEL_MAX_WIDTH_DP.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.96f))
                    .clickable(enabled = false) {}
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                if (loading) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                        Text(
                            text = stringResource(R.string.float_ball_recognizing),
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                } else {
                    if (!text.isNullOrBlank()) {
                        Text(
                            text = text,
                            modifier = Modifier.heightIn(max = 72.dp),
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            ActionChip(label = stringResource(R.string.float_ball_action_copy), onClick = onCopy)
                            ActionChip(label = stringResource(R.string.float_ball_action_search), onClick = onSearch)
                            ActionChip(label = stringResource(R.string.float_ball_action_share), onClick = onShareText)
                        }
                    }
                    if (screenshot != null) {
                        Image(
                            bitmap = screenshot.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .heightIn(max = 96.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop,
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            ActionChip(
                                label = stringResource(R.string.float_ball_action_save_screenshot),
                                onClick = onSaveScreenshot,
                            )
                            ActionChip(
                                label = stringResource(R.string.float_ball_action_share_screenshot),
                                onClick = onShareScreenshot,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ActionChip(label: String, onClick: () -> Unit) {
    Text(
        text = label,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 6.dp),
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        fontSize = 13.sp,
    )
}
