package xyz.sangcomz.indicatordecorator.shape

import android.graphics.Canvas

interface IndicatorShape {
    /**
     * Factor associated with the selected indicator scale value
     */
    var scaleFactor: Float

    /**
     * To draw inactive indicator
     */
    fun inactiveIndicatorDraw(c: Canvas, x: Float, y: Float)

    /**
     * To draw active indicator
     */
    fun activeIndicatorDraw(c: Canvas, x: Float, y: Float)

    /**
     * get indicator width
     */
    fun getIndicatorWidth(): Float

    /**
     * get indicator height
     */
    fun getIndicatorHeight(): Float
}