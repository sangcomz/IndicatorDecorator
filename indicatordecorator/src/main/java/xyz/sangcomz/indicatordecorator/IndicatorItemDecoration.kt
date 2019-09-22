package xyz.sangcomz.indicatordecorator

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class IndicatorItemDecoration : RecyclerView.ItemDecoration() {

    private val colorActive = Color.BLACK
    private val colorInactive = Color.GRAY
    private val radius = (DP * 3.5).toFloat()
    private val offset = (DP * 8).toInt()

    private var selectedPage = 0

    /**
     * Indicator width.
     */
    private val mIndicatorItemLength = radius * 2
    /**
     * Padding between indicators.
     */
    private val mIndicatorItemPadding = DP * 4

    private val mPaint = Paint()

    init {
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.isAntiAlias = true
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val adapter = parent.adapter ?: return

        val itemCount = adapter.itemCount

        val totalLength = mIndicatorItemLength * itemCount
        val paddingBetweenItems = Math.max(0, itemCount - 1) * mIndicatorItemPadding
        val indicatorTotalWidth = totalLength + paddingBetweenItems
        val indicatorStartX = (parent.width - indicatorTotalWidth) / 2f

        val indicatorPosY = parent.height - radius

        drawInactiveIndicators(c, indicatorStartX, indicatorPosY, itemCount)

        val layoutManager = parent.layoutManager as? LinearLayoutManager
        val activePosition = layoutManager?.findFirstVisibleItemPosition()
        if (activePosition == RecyclerView.NO_POSITION) {
            return
        }

        val view = layoutManager?.findViewByPosition(activePosition!!)!!
        println("activeView width, left:::: ${view.width}, ${view.left}")
        println("activeView width + left:::: ${view.width + view.left}")

        selectedPage = activePosition ?: 0 + if (view.width / 2 > view.width + view.left) 1 else 0

        println("selectedPage :::: $selectedPage")

//        if (layoutManager?.findLastVisibleItemPosition() != RecyclerView.NO_POSITION) {
//            selectedPage = layoutManager?.findLastVisibleItemPosition() ?: 0
//        }

        drawSelectedIndicators(c, indicatorStartX, indicatorPosY)
    }

    private fun drawInactiveIndicators(
        c: Canvas,
        indicatorStartX: Float,
        indicatorPosY: Float,
        itemCount: Int
    ) {
        mPaint.color = colorInactive

        val itemWidth = mIndicatorItemLength + mIndicatorItemPadding

        var start = indicatorStartX
        for (i in 0 until itemCount) {
            c.drawCircle(start + radius, indicatorPosY, radius, mPaint)
            start += itemWidth
        }
    }

    private fun drawSelectedIndicators(c: Canvas, indicatorStartX: Float, indicatorPosY: Float) {
        mPaint.color = colorActive
        val itemWidth = mIndicatorItemLength + mIndicatorItemPadding
        val start = indicatorStartX + itemWidth * selectedPage
        c.drawCircle(start + radius, indicatorPosY, radius, mPaint)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = (offset + radius).toInt()
    }

    companion object {

        private val DP = Resources.getSystem().displayMetrics.density
    }
}