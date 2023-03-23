package com.gess.example.diyview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ScreenUtils
import com.blankj.utilcode.util.ScreenUtils.getScreenDensity
import com.gess.example.R

class RecyclerViewProgressBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_progress_bar)
        var endX = arrayOf(0)

        val list = ArrayList<String>()
        for (i in 0..10){
            list.add("帝$i")
        }
        val la = ListAdapter(findViewById<RecyclerView>(R.id.rvpb))
        findViewById<RecyclerView>(R.id.rvpb).adapter = la
        la.addMoreData(list)

        findViewById<RecyclerView>(R.id.rvpb).addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // 整体的总宽度，注意是整体，包括在显示区域之外的。
                val range = findViewById<RecyclerView>(R.id.rvpb).computeHorizontalScrollRange()
                val density = getScreenDensity()
                // 计算出溢出部分的宽度，即屏幕外剩下的宽度
                val maxEndX = range - ScreenUtils.getScreenWidth() + (25 * density) + 5
                // 滑动的距离
                endX[0] = endX[0] + dx
                // 计算比例
                val proportion = endX[0] / maxEndX

                // 计算滚动条宽度
                val transMaxRange = ( findViewById<View>(R.id.view_slip_front).parent as ViewGroup).width - findViewById<View>(R.id.view_slip_front).width
                // 设置滚动条移动
                findViewById<View>(R.id.view_slip_front).translationX = transMaxRange * proportion
            }
        });
    }
}