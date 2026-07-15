package com.slideindex.app.overlay

import com.slideindex.app.settings.AppSettings
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FloatBallPickAnchorTest {
  private val screenHeight = 2400f
  private val ballSizePx = 144f
  private val density = 3f

  @Test
  fun pick_is_above_ball_when_far_from_bottom() {
    val pick = FloatBallPickAnchor.pickPointForBallCenter(
      settings = AppSettings(),
      ballCenterX = 1000f,
      ballCenterY = 600f,
      ballSizePx = ballSizePx,
      screenWidth = 1080f,
      screenHeight = screenHeight,
      density = density,
    )
    assertTrue(pick.y < 600f)
  }

  @Test
  fun pick_stays_above_ball_at_mid_screen_even_with_wide_transition_band() {
    val centerY = screenHeight * 0.55f
    val pick = FloatBallPickAnchor.pickPointForBallCenter(
      settings = AppSettings(floatBallPickBottomTransitionFraction = 0.22f),
      ballCenterX = 1000f,
      ballCenterY = centerY,
      ballSizePx = ballSizePx,
      screenWidth = 1080f,
      screenHeight = screenHeight,
      density = density,
    )
    assertTrue(pick.y < centerY)
  }

  @Test
  fun pick_is_below_ball_when_ball_bottom_hits_screen_edge() {
    val centerY = screenHeight - ballSizePx / 2f - 8f * density
    val pick = FloatBallPickAnchor.pickPointForBallCenter(
      settings = AppSettings(),
      ballCenterX = 1000f,
      ballCenterY = centerY,
      ballSizePx = ballSizePx,
      screenWidth = 1080f,
      screenHeight = screenHeight,
      density = density,
    )
    assertTrue(pick.y > centerY)
  }

  @Test
  fun bottom_flip_blend_is_zero_outside_bottom_band() {
    val bandPx = screenHeight * 0.18f
    val blend = FloatBallPickAnchor.bottomFlipBlend(
      ballBottomY = screenHeight * 0.6f,
      screenHeight = screenHeight,
      transitionBandPx = bandPx,
      edgeInsetPx = 24f,
    )
    assertEquals(0f, blend, 0.001f)
  }

  @Test
  fun pick_transitions_continuously_within_bottom_band() {
    val settings = AppSettings()
    val bandPx = FloatBallPickAnchor.bottomTransitionBandPx(settings, screenHeight)
    val bandBottom = screenHeight - 8f * density
    val bandTop = bandBottom - bandPx
    var previousY = Float.NEGATIVE_INFINITY
    for (ballBottom in listOf(bandTop - 50f, bandTop, (bandTop + bandBottom) / 2f, bandBottom)) {
      val centerY = ballBottom - ballSizePx / 2f
      val pick = FloatBallPickAnchor.pickPointForBallCenter(
        settings = settings,
        ballCenterX = 1000f,
        ballCenterY = centerY,
        ballSizePx = ballSizePx,
        screenWidth = 1080f,
        screenHeight = screenHeight,
        density = density,
      )
      assertTrue(pick.y >= previousY)
      previousY = pick.y
    }
  }
}
