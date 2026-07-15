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
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slideindex.app.R
import com.slideindex.app.di.OverlayDependencyAccess
import com.slideindex.app.ui.theme.SlideIndexTheme

private val PANEL_HORIZONTAL_PADDING = 12.dp
private val PANEL_MAX_WIDTH = 340.dp
private val PANEL_MAX_TEXT_HEIGHT = 180.dp
private val PANEL_MAX_IMAGE_HEIGHT = 140.dp

/**
 * FV-style centered pick-result window after float-ball text pick / regional screenshot.
 */
object FloatBallPickResultPanel {
    private const val TAG = "FloatBallPickPanel"

    private val mainHandler = Handler(Looper.getMainLooper())

    private var windowManager: WindowManager? = null
    private var composeView: ComposeView? = null
    private var owner: OverlayComposeOwner? = null
    private var screenOffReceiver: BroadcastReceiver? = null
    private var appContext: Context? = null

    private var loadingState: MutableState<Boolean>? = null
    private var textState: MutableState<String?>? = null
    private var screenshotState: MutableState<Bitmap?>? = null
    private var textExpandedState: MutableState<Boolean>? = null
    private var imageExpandedState: MutableState<Boolean>? = null

    val isShowing: Boolean get() = composeView != null

    fun showLoading(context: Context, anchorX: Float = 0f, anchorY: Float = 0f) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { showLoading(context, anchorX, anchorY) }
            return
        }
        val hostContext = OverlayDependencyAccess.overlayHostContext() ?: context.applicationContext
        ensureWindow(hostContext)
        loadingState?.value = true
        textState?.value = null
        screenshotState?.value?.recycle()
        screenshotState?.value = null
        textExpandedState?.value = true
        imageExpandedState?.value = true
    }

    fun showResult(
        context: Context,
        anchorX: Float = 0f,
        anchorY: Float = 0f,
        result: FloatBallPickResult,
    ) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { showResult(context, anchorX, anchorY, result) }
            return
        }
        val hostContext = OverlayDependencyAccess.overlayHostContext() ?: context.applicationContext
        ensureWindow(hostContext)
        loadingState?.value = false
        textState?.value = result.text
        screenshotState?.value?.recycle()
        screenshotState?.value = result.screenshot
        textExpandedState?.value = !result.text.isNullOrBlank() || result.screenshot == null
        imageExpandedState?.value = result.screenshot != null
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
        windowManager = null
        loadingState = null
        textState = null
        screenshotState = null
        textExpandedState = null
        imageExpandedState = null
        screenOffReceiver = null
        appContext = null
    }

    private fun ensureWindow(context: Context) {
        if (composeView != null) return

        val loadingHolder = mutableStateOf(true)
        val textHolder = mutableStateOf<String?>(null)
        val screenshotHolder = mutableStateOf<Bitmap?>(null)
        val textExpandedHolder = mutableStateOf(true)
        val imageExpandedHolder = mutableStateOf(true)
        loadingState = loadingHolder
        textState = textHolder
        screenshotState = screenshotHolder
        textExpandedState = textExpandedHolder
        imageExpandedState = imageExpandedHolder

        val dialogOwner = OverlayComposeOwner()
        val overlayContext = OverlayCompose.themedContext(context)
        val compose = OverlayCompose.createComposeView(overlayContext, dialogOwner).apply {
            setContent {
                val loading by loadingHolder
                val text by textHolder
                val screenshot by screenshotHolder
                val textExpanded by textExpandedHolder
                val imageExpanded by imageExpandedHolder
                FloatBallPickResultContent(
                    loading = loading,
                    text = text,
                    screenshot = screenshot,
                    textExpanded = textExpanded,
                    imageExpanded = imageExpanded,
                    onTextExpandedChange = { textExpandedHolder.value = it },
                    onImageExpandedChange = { imageExpandedHolder.value = it },
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
                    onPaste = {
                        val pasted = FloatBallTextPick.readClipboardText(context)
                        if (pasted == null) {
                            Toast.makeText(context, R.string.float_ball_paste_empty, Toast.LENGTH_SHORT).show()
                        } else {
                            textHolder.value = pasted
                        }
                    },
                    onTranslate = {
                        val value = textHolder.value ?: return@FloatBallPickResultContent
                        FloatBallTextPick.translateText(context, value)
                    },
                    onRemoveSpaces = {
                        val value = textHolder.value ?: return@FloatBallPickResultContent
                        textHolder.value = value.replace(Regex("\\s+"), "")
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
        appContext = context
        registerScreenOffReceiver(context)
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
    loading: Boolean,
    text: String?,
    screenshot: Bitmap?,
    textExpanded: Boolean,
    imageExpanded: Boolean,
    onTextExpandedChange: (Boolean) -> Unit,
    onImageExpandedChange: (Boolean) -> Unit,
    onDismiss: () -> Unit,
    onCopy: () -> Unit,
    onSearch: () -> Unit,
    onShareText: () -> Unit,
    onPaste: () -> Unit,
    onTranslate: () -> Unit,
    onRemoveSpaces: () -> Unit,
    onSaveScreenshot: () -> Unit,
    onShareScreenshot: () -> Unit,
) {
    val hasTextSection = loading || !text.isNullOrBlank()
    val hasImageSection = screenshot != null

    SlideIndexTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.28f))
                .clickable(onClick = onDismiss),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .padding(PANEL_HORIZONTAL_PADDING)
                    .widthIn(max = PANEL_MAX_WIDTH)
                    .clip(RoundedCornerShape(14.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.98f))
                    .clickable(enabled = false) {}
                    .padding(vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp),
            ) {
                if (hasTextSection) {
                    PickResultSectionHeader(
                        title = stringResource(R.string.float_ball_pick_result_text_section),
                        expanded = textExpanded,
                        onToggle = { onTextExpandedChange(!textExpanded) },
                    )
                    if (textExpanded) {
                        Column(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            if (loading) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(20.dp),
                                        strokeWidth = 2.dp,
                                    )
                                    Text(
                                        text = stringResource(R.string.float_ball_recognizing),
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                            } else if (!text.isNullOrBlank()) {
                                Text(
                                    text = text,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .heightIn(max = PANEL_MAX_TEXT_HEIGHT)
                                        .verticalScroll(rememberScrollState()),
                                    fontSize = 15.sp,
                                    lineHeight = 22.sp,
                                    color = MaterialTheme.colorScheme.onSurface,
                                )
                                PickResultTextActionBar(
                                    enabled = true,
                                    onSearch = onSearch,
                                    onShare = onShareText,
                                    onCopy = onCopy,
                                    onPaste = onPaste,
                                    onTranslate = onTranslate,
                                    onRemoveSpaces = onRemoveSpaces,
                                )
                            }
                        }
                    }
                }

                if (hasTextSection && hasImageSection) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    )
                }

                if (hasImageSection) {
                    PickResultSectionHeader(
                        title = stringResource(R.string.float_ball_pick_result_image_section),
                        expanded = imageExpanded,
                        onToggle = { onImageExpandedChange(!imageExpanded) },
                    )
                    if (imageExpanded) {
                        Column(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            val image = screenshot
                            if (image != null) {
                                Image(
                                    bitmap = image.asImageBitmap(),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .heightIn(max = PANEL_MAX_IMAGE_HEIGHT)
                                        .clip(RoundedCornerShape(8.dp)),
                                    contentScale = ContentScale.Fit,
                                )
                                PickResultImageActionBar(
                                    onSave = onSaveScreenshot,
                                    onShare = onShareScreenshot,
                                )
                            }
                        }
                    }
                }

                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(stringResource(R.string.float_ball_action_collapse))
                    }
                    TextButton(onClick = onDismiss) {
                        Text(
                            text = stringResource(R.string.float_ball_action_close),
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PickResultSectionHeader(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onToggle)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Icon(
            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(22.dp),
        )
    }
}

@Composable
private fun PickResultTextActionBar(
    enabled: Boolean,
    onSearch: () -> Unit,
    onShare: () -> Unit,
    onCopy: () -> Unit,
    onPaste: () -> Unit,
    onTranslate: () -> Unit,
    onRemoveSpaces: () -> Unit,
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PickResultToolbarIcon(Icons.Default.Search, enabled, onSearch)
        PickResultToolbarIcon(Icons.Default.Share, enabled, onShare)
        PickResultToolbarIcon(Icons.Default.ContentCopy, enabled, onCopy)
        PickResultToolbarIcon(Icons.Default.ContentPaste, enabled, onPaste)
        PickResultToolbarIcon(Icons.Default.Language, enabled, onTranslate)
        Box {
            PickResultToolbarIcon(Icons.Default.MoreVert, enabled) { menuExpanded = true }
            DropdownMenu(
                expanded = menuExpanded,
                onDismissRequest = { menuExpanded = false },
            ) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.float_ball_menu_remove_spaces)) },
                    onClick = {
                        menuExpanded = false
                        onRemoveSpaces()
                    },
                )
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(R.string.float_ball_menu_segment_soon),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    onClick = { menuExpanded = false },
                    enabled = false,
                )
            }
        }
    }
}

@Composable
private fun PickResultImageActionBar(
    onSave: () -> Unit,
    onShare: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        PickResultToolbarIcon(Icons.Default.Save, enabled = true, onClick = onSave)
        Spacer(modifier = Modifier.size(32.dp))
        PickResultToolbarIcon(Icons.Default.Share, enabled = true, onClick = onShare)
    }
}

@Composable
private fun PickResultToolbarIcon(
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.size(40.dp),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(22.dp),
            tint = if (enabled) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            },
        )
    }
}
