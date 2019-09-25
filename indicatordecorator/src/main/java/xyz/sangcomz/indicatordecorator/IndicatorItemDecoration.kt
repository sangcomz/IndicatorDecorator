package xyz.sangcomz.indicatordecorator

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xyz.sangcomz.indicatordecorator.ext.toDP
import xyz.sangcomz.indicatordecorator.shape.CircleIndicator
import xyz.sangcomz.indicatordecorator.shape.IndicatorShape
import kotlin.math.max

/**
 * inspired by https://github.com/bleeding182/recyclerviewItemDecorations
 */
class IndicatorItemDecoration : RecyclerView.ItemDecoration() {
    /**
     * Top Offset with Page Item
     */
    var topOffset = 4.toDP().toInt()
    /**
     * Bottom Offset in View
     */
    var bottomOffset = 4.toDP().toInt()
    /**
     * Padding between indicators.
     */
    var indicatorItemPadding = 8.toDP()

    /**
     * Indicator shape
     * By default it has a circle of radius 4.
     */
    var indicatorShape: IndicatorShape = CircleIndicator().apply { radius = 4.toDP() }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val adapter = parent.adapter ?: return
        val layoutManager: LinearLayoutManager =
            parent.layoutManager as? LinearLayoutManager ?: return

        val itemCount = adapter.itemCount

        val totalLength = indicatorShape.getIndicatorWidth() * itemCount

        val paddingBetweenItems = max(0, itemCount - 1) * indicatorItemPadding
        val indicatorTotalWidth = totalLength + paddingBetweenItems
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f

        val indicatorPosY = parent.height - (indicatorShape.getIndicatorWidth() / 2) - bottomOffset

        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, itemCount)

        val activePosition = layoutManager.findFirstVisibleItemPosition()
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        val view = layoutManager.findViewByPosition(activePosition)!!

        drawSelectedIndicators(
            c,
            activePosition + if (view.width / 2f > view.width + view.left) 1 else 0,
            indicatorStartX,
            indicatorPosY
        )
    }

    private fun drawInactiveIndicators(
        c: Canvas,
        indicatorStartX: Float,
        indicatorPosY: Float,
        itemCount: Int
    ) {
        val itemWidth = indicatorShape.getIndicatorWidth() + indicatorItemPadding

        var start = indicatorStartX
        for (i in 0 until itemCount) {
            indicatorShape.inactiveIndicatorDraw(
                c, start + indicatorShape.getIndicatorWidth() / 2,
                indicatorPosY
            )
            start += itemWidth
        }
    }

    private fun drawSelectedIndicators(
        c: Canvas,
        selectedPosition: Int,
        indicatorStartX: Float,
        indicatorPosY: Float
    ) {
        val itemWidth = indicatorShape.getIndicatorWidth() + indicatorItemPadding
        val start = indicatorStartX + itemWidth * selectedPosition

        indicatorShape.activeIndicatorDraw(
            c,
            start + indicatorShape.getIndicatorWidth() / 2,
            indicatorPosY
        )
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = (topOffset + bottomOffset + indicatorShape.getIndicatorWidth()).toInt()
    }
}