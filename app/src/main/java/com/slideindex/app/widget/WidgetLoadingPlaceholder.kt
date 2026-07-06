package com.slideindex.app.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.RectF
import android.view.Gravity
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.TextView
import kotlin.math.roundToInt

/**
 * Placeholder card shown while an [android.appwidget.AppWidgetHostView] is loading.
 */
class WidgetLoadingPlaceholder(context: Context) : FrameLayout(context) {

  private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    color = Color.parseColor("#B0B0B0")
    style = Paint.Style.STROKE
    strokeWidth = 1.2f * context.resources.displayMetrics.density
    pathEffect = DashPathEffect(floatArrayOf(8f, 8f), 0f)
  }
  private val shimmerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
    color = Color.parseColor("#E8E8E8")
    style = Paint.Style.FILL
  }
  private var shimmerPhase = 0f
  private var shimmerAnimator: ValueAnimator? = null

  init {
    setWillNotDraw(false)
    setBackgroundColor(Color.parseColor("#F5F5F5"))
    val label = TextView(context).apply {
      text = context.getString(com.slideindex.app.R.string.widget_loading)
      setTextColor(Color.parseColor("#9E9E9E"))
      textSize = 13f
    }
    addView(
      label,
      LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER),
    )
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    shimmerAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
      duration = 1200L
      repeatCount = ValueAnimator.INFINITE
      repeatMode = ValueAnimator.REVERSE
      interpolator = LinearInterpolator()
      addUpdateListener {
        shimmerPhase = it.animatedValue as Float
        invalidate()
      }
      start()
    }
  }

  override fun onDetachedFromWindow() {
    shimmerAnimator?.cancel()
    shimmerAnimator = null
    super.onDetachedFromWindow()
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val density = resources.displayMetrics.density
    val step = (24 * density).roundToInt().coerceAtLeast(8)
    val inset = (8 * density).roundToInt()
    var y = inset
    while (y < height - inset) {
      var x = inset
      while (x < width - inset) {
        canvas.drawCircle(x.toFloat(), y.toFloat(), 1.5f * density, gridPaint)
        x += step
      }
      y += step
    }
    val barHeight = (12 * density).roundToInt()
    val barWidth = (width * 0.55f).roundToInt()
    val left = ((width - barWidth) * shimmerPhase).roundToInt().coerceIn(0, width - barWidth)
    val top = (height / 2f + 28 * density).roundToInt()
    val rect = RectF(left.toFloat(), top.toFloat(), (left + barWidth).toFloat(), (top + barHeight).toFloat())
    canvas.drawRoundRect(rect, barHeight / 2f, barHeight / 2f, shimmerPaint)
  }
}
