package com.slideindex.app.overlay

import androidx.compose.ui.geometry.Offset
import com.slideindex.app.settings.AppSettings

/**
 * Continuous pick-point offset relative to the float-ball center (FV-style).
 * Default above the ball; smoothly transitions below only inside a band at the screen bottom edge.
 */
internal object FloatBallPickAnchor {
  private const val MIN_SCREEN_MARGIN_DP = 4f
  private const val BOTTOM_EDGE_INSET_DP = 8f

  fun pickPointForBallCenter(
    settings: AppSettings,
    ballCenterX: Float,
    ballCenterY: Float,
    ballSizePx: Float,
    screenWidth: Float,
    screenHeight: Float,
    density: Float,
  ): Offset {
    val gapPx = settings.floatBallPickOffsetDp.coerceIn(4f, 48f) * density
    val aboveOffsetY = -(ballSizePx / 2f + gapPx)
    val belowOffsetY = ballSizePx / 2f + gapPx

    val ballBottom = ballCenterY + ballSizePx / 2f
    val blend = bottomFlipBlend(
      ballBottomY = ballBottom,
      screenHeight = screenHeight,
      transitionBandPx = bottomTransitionBandPx(settings, screenHeight),
      edgeInsetPx = BOTTOM_EDGE_INSET_DP * density,
    )
    val offsetY = aboveOffsetY + (belowOffsetY - aboveOffsetY) * blend
    val offsetX = gapPx * 0.35f

    return clampToScreen(
      x = ballCenterX + offsetX,
      y = ballCenterY + offsetY,
      screenWidth = screenWidth,
      screenHeight = screenHeight,
      density = density,
    )
  }

  /**
   * 0 = pick above ball, 1 = pick below ball.
   * Transition only occurs while [ballBottomY] moves through the bottom edge band.
   */
  internal fun bottomFlipBlend(
    ballBottomY: Float,
    screenHeight: Float,
    transitionBandPx: Float,
    edgeInsetPx: Float,
  ): Float {
    val bandBottomY = screenHeight - edgeInsetPx
    val bandTopY = (bandBottomY - transitionBandPx).coerceAtLeast(0f)
    val linearT = when {
      ballBottomY <= bandTopY -> 0f
      ballBottomY >= bandBottomY -> 1f
      else -> (ballBottomY - bandTopY) / (bandBottomY - bandTopY)
    }
    return smoothstep(linearT)
  }

  internal fun bottomTransitionBandPx(settings: AppSettings, screenHeight: Float): Float =
    screenHeight * settings.floatBallPickBottomTransitionFraction.coerceIn(0.05f, 0.22f)

  fun clampToScreen(
    x: Float,
    y: Float,
    screenWidth: Float,
    screenHeight: Float,
    density: Float,
  ): Offset {
    val margin = MIN_SCREEN_MARGIN_DP * density
    return Offset(
      x = x.coerceIn(margin, screenWidth - margin),
      y = y.coerceIn(margin, screenHeight - margin),
    )
  }

  private fun smoothstep(value: Float): Float {
    val t = value.coerceIn(0f, 1f)
    return t * t * (3f - 2f * t)
  }
}
