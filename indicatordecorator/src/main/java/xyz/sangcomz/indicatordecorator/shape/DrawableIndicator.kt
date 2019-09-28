package xyz.sangcomz.indicatordecorator.shape

import android.graphics.Canvas
import android.graphics.drawable.Drawable


class DrawableIndicator(
    drawableActive: Drawable,
    drawableInActive: Drawable
) : IndicatorShape {

    override var scaleFactor: Float = 1.2f
    var width: Float = drawableActive.intrinsicWidth.toFloat()
    var height: Float = drawableActive.intrinsicHeight.toFloat()
    var drawableActive = drawableActive
    var drawableInActive = drawableInActive

    override fun inactiveIndicatorDraw(c: Canvas, x: Float, y: Float) {
        drawableInActive.setBounds(
            x.toInt(),
            (y - height / 2).toInt(),
            (x + width).toInt(),
            (y + height / 2).toInt()
        )
        drawableInActive.draw(c)
    }

    override fun activeIndicatorDraw(c: Canvas, x: Float, y: Float) {
        val widthScale = ((width * scaleFactor) - width) / 2
        val heightScale = ((height * scaleFactor) - height) / 2
        drawableActive.setBounds(
            (x - widthScale).toInt(),
            (y - height / 2 - heightScale).toInt(),
            (x + width + widthScale).toInt(),
            (y + height / 2 + heightScale).toInt()
        )
        drawableActive.draw(c)
    }

    override fun getIndicatorWidth() = width

    override fun getIndicatorHeight() = height
}