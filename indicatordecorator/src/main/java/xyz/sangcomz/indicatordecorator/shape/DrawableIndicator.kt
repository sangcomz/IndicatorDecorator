package xyz.sangcomz.indicatordecorator.shape

import android.graphics.Canvas
import android.graphics.drawable.Drawable


class DrawableIndicator(
    drawableActive: Drawable,
    drawableInActive: Drawable
) : IndicatorShape {
    override var scaleFactor: Float = 1f
    var width: Float = drawableActive.intrinsicWidth.toFloat()
    var drawableActive = drawableActive
    var drawableInActive = drawableInActive

    override fun inactiveIndicatorDraw(c: Canvas, x: Float, y: Float) {
        drawableInActive.setBounds(
            x.toInt(),
            (y - width / 2).toInt(),
            (x + width).toInt(),
            (y + width / 2).toInt()
        )
        drawableInActive.draw(c)
    }

    override fun activeIndicatorDraw(c: Canvas, x: Float, y: Float) {
        val scale = ((width * scaleFactor) - width) / 2
        drawableActive.setBounds(
            (x - scale).toInt(),
            (y - width / 2).toInt(),
            (x + width + scale).toInt(),
            (y + width / 2).toInt()
        )
        drawableActive.draw(c)
    }

    override fun getIndicatorWidth() = width
}