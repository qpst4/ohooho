package com.slideindex.app.overlay

import android.util.DisplayMetrics
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FloatBallPositionMode
import com.slideindex.app.settings.FloatBallSide
import org.junit.Assert.assertEquals
import org.junit.Test

class FloatBallLayoutTest {
  private val metrics = DisplayMetrics().apply {
    density = 3f
    widthPixels = 1080
    heightPixels = 2400
  }

  @Test
  fun strip_window_origin_left_places_ball_center_at_target() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.LEFT,
      floatBallSizeDp = 48f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val strip = FloatBallLayout.edgeStripBounds(settings, metrics, FloatBallSide.LEFT)
    val centerX = ballSizePx / 2f
    val centerY = 1200f

    val (windowX, windowY) = FloatBallLayout.stripWindowOriginForBallCenter(
      settings = settings,
      metrics = metrics,
      activeSide = FloatBallSide.LEFT,
      ballCenterX = centerX,
      ballCenterY = centerY,
    )

    assertEquals(centerX, windowX + ballSizePx / 2f, 0.5f)
    assertEquals(centerY, windowY + strip.height() / 2f, 0.5f)
  }

  @Test
  fun strip_window_origin_right_places_ball_center_at_target() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.RIGHT,
      floatBallSizeDp = 48f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val strip = FloatBallLayout.edgeStripBounds(settings, metrics, FloatBallSide.RIGHT)
    val centerX = metrics.widthPixels - ballSizePx / 2f
    val centerY = 900f

    val (windowX, windowY) = FloatBallLayout.stripWindowOriginForBallCenter(
      settings = settings,
      metrics = metrics,
      activeSide = FloatBallSide.RIGHT,
      ballCenterX = centerX,
      ballCenterY = centerY,
    )

    assertEquals(centerX, windowX + strip.width() - ballSizePx / 2f, 0.5f)
    assertEquals(centerY, windowY + strip.height() / 2f, 0.5f)
  }
}
