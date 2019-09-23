package xyz.sangcomz.indicatordecorator.shape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class SquareIndicator : IndicatorShape {
    private val paint = Paint().apply { isAntiAlias = true }
    var colorActive: Int = Color.RED
    var colorInactive: Int = Color.GRAY
    var width = 20f
    override var scaleFactor = 1.5f
    override fun inactiveIndicatorDraw(c: Canvas, x: Float, y: Float) {
        paint.color = colorInactive
        c.drawRect(x, y - width / 2, x + width, y + width / 2, paint)
    }

    override fun activeIndicatorDraw(c: Canvas, x: Float, y: Float) {
        paint.color = colorActive
        val scale = ((width * scaleFactor) - width) / 2
        c.drawRect(
            x - scale,
            y - (width * scaleFactor) / 2,
            x + width + scale,
            y + (width * scaleFactor) / 2,
            paint
        )
    }

    override fun getIndicatorWidth() = width
}