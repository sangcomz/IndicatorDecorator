package xyz.sangcomz.indicatordecoratorsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import xyz.sangcomz.indicatordecorator.IndicatorItemDecoration
import xyz.sangcomz.indicatordecorator.shape.CircleIndicator
import xyz.sangcomz.indicatordecorator.shape.DrawableIndicator
import xyz.sangcomz.indicatordecorator.shape.SquareIndicator

class MainActivity : AppCompatActivity() {

    private val adapter1: ListAdapter = ListAdapter(
        listOf(
            R.color.page1 to "DrawableIndicator\npage 1",
            R.color.page2 to "DrawableIndicator\npage 2",
            R.color.page3 to "DrawableIndicator\npage 3",
            R.color.page4 to "DrawableIndicator\npage 4",
            R.color.page5 to "DrawableIndicator\npage 5",
            R.color.page6 to "DrawableIndicator\npage 6",
            R.color.page7 to "DrawableIndicator\npage 7",
            R.color.page8 to "DrawableIndicator\npage 8"
        )
    )

    private val adapter2: ListAdapter = ListAdapter(
        listOf(
            R.color.page8 to "SquareIndicator\npage 1",
            R.color.page7 to "SquareIndicator\npage 2",
            R.color.page6 to "SquareIndicator\npage 3",
            R.color.page5 to "SquareIndicator\npage 4",
            R.color.page4 to "SquareIndicator\npage 5",
            R.color.page3 to "SquareIndicator\npage 6",
            R.color.page2 to "SquareIndicator\npage 7",
            R.color.page1 to "SquareIndicator\npage 8"
        )
    )

    private val adapter3: ListAdapter = ListAdapter(
        listOf(
            R.color.page4 to "CircleIndicator\npage 1",
            R.color.page5 to "CircleIndicator\npage 2",
            R.color.page6 to "CircleIndicator\npage 3",
            R.color.page7 to "CircleIndicator\npage 4",
            R.color.page8 to "CircleIndicator\npage 5",
            R.color.page1 to "CircleIndicator\npage 6",
            R.color.page2 to "CircleIndicator\npage 7",
            R.color.page3 to "CircleIndicator\npage 8"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager1.adapter = adapter1
        viewPager1.addItemDecoration(IndicatorItemDecoration().apply {
            indicatorShape = CircleIndicator().apply {
                isOverlap = true
                colorActive = ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryDark)
                isShowBackground = true
            }
        })

        viewPager2.adapter = adapter2
        viewPager2.addItemDecoration(IndicatorItemDecoration().apply {
            indicatorShape = SquareIndicator().apply {
                colorActive = ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryDark)
            }
        })

        recyclerView.adapter = adapter3
        PagerSnapHelper().attachToRecyclerView(recyclerView)
        recyclerView.addItemDecoration(IndicatorItemDecoration().apply {
            indicatorShape = DrawableIndicator(
                ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.ic_grade_red_24dp
                )!!,
                ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_grade_gray_24dp)!!
            ).apply {
                width = 64f
            }
        })


    }
}
