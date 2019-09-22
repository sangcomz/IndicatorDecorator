package xyz.sangcomz.indicatordecoratorsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_main.*
import xyz.sangcomz.indicatordecorator.IndicatorItemDecoration
import xyz.sangcomz.indicatordecorator.LinePagerIndicatorDecoration

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter(
        listOf(
            R.color.page1 to "page 1",
            R.color.page2 to "page 2",
            R.color.page3 to "page 3",
            R.color.page4 to "page 4",
            R.color.page5 to "page 5",
            R.color.page6 to "page 6",
            R.color.page7 to "page 7",
            R.color.page8 to "page 8"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = adapter
        viewPager.addItemDecoration(IndicatorItemDecoration())
//        viewPager.addItemDecoration(LinePagerIndicatorDecoration())

        recyclerView.adapter = adapter
        PagerSnapHelper().attachToRecyclerView(recyclerView)
//        recyclerView.addItemDecoration(IndicatorItemDecoration())
        recyclerView.addItemDecoration(LinePagerIndicatorDecoration())
    }
}
