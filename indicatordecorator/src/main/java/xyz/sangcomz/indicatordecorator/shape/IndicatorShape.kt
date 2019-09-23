package xyz.sangcomz.indicatordecorator.shape

import android.graphics.Canvas

interface IndicatorShape {
    var scaleFactor: Float
    fun inactiveIndicatorDraw(c: Canvas, x: Float, y: Float)
    fun activeIndicatorDraw(c: Canvas, x: Float, y: Float)
    fun getIndicatorWidth(): Float
}