package com.slideindex.app.overlay

import android.util.DisplayMetrics
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FloatBallPositionMode
import com.slideindex.app.settings.FloatBallSide
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import kotlin.math.roundToInt
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
    assertEquals(centerY, windowY + ballSizePx / 2f, 0.5f)
  }

  @Test
  fun strip_window_origin_right_places_ball_center_at_target() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.RIGHT,
      floatBallSizeDp = 48f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val centerX = metrics.widthPixels - ballSizePx / 2f
    val centerY = 900f

    val (windowX, windowY) = FloatBallLayout.stripWindowOriginForBallCenter(
      settings = settings,
      metrics = metrics,
      activeSide = FloatBallSide.RIGHT,
      ballCenterX = centerX,
      ballCenterY = centerY,
    )

    assertEquals(centerX, windowX + ballSizePx / 2f, 0.5f)
    assertEquals(centerY, windowY + ballSizePx / 2f, 0.5f)
  }

  @Test
  fun line_strip_width_ignores_ball_size() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.RIGHT,
      floatBallSizeDp = 64f,
      floatBallLineWidthFraction = 0.04f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val lineStrip = FloatBallLayout.lineStripBounds(settings, metrics, FloatBallSide.RIGHT)
    val ballWindow = FloatBallLayout.ballWindowBounds(settings, metrics, FloatBallSide.RIGHT)

    assertTrue(lineStrip.width() < ballSizePx)
    assertEquals(ballSizePx, ballWindow.width())
    assertEquals(ballSizePx, ballWindow.height())
  }

  @Test
  fun fully_visible_right_ball_is_flush_with_screen_edge() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.RIGHT,
      floatBallSizeDp = 48f,
      floatBallVisibleFraction = 1f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val (left, _) = FloatBallLayout.ballTopLeft(settings, metrics, FloatBallSide.RIGHT)

    assertEquals(metrics.widthPixels - ballSizePx, left)
  }

  @Test
  fun half_visible_right_ball_extends_past_right_edge() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.RIGHT,
      floatBallSizeDp = 64f,
      floatBallVisibleFraction = 0.5f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val (left, _) = FloatBallLayout.ballTopLeft(settings, metrics, FloatBallSide.RIGHT)
    val expectedLeft = (metrics.widthPixels - ballSizePx * 0.5f).roundToInt()

    assertEquals(expectedLeft, left)
    assertTrue(left + ballSizePx > metrics.widthPixels)
  }

  @Test
  fun half_visible_left_ball_extends_past_left_edge() {
    val settings = AppSettings(
      floatBallPositionMode = FloatBallPositionMode.LEFT,
      floatBallSizeDp = 64f,
      floatBallVisibleFraction = 0.5f,
    )
    val ballSizePx = FloatBallLayout.ballSizePx(settings, metrics.density)
    val (left, _) = FloatBallLayout.ballTopLeft(settings, metrics, FloatBallSide.LEFT)
    val expectedLeft = (-ballSizePx * 0.5f).roundToInt()

    assertEquals(expectedLeft, left)
    assertTrue(left < 0)
  }
}
