package com.gess.appkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import com.gess.appkotlin.ui.home.HomeAdapter
import com.gess.appkotlin.widget.CustomTextureView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.text = "MainActivity"
        rv_main.postDelayed(Runnable {
            rv_main.layoutManager = LinearLayoutManager(this)
            rv_main.adapter = HomeAdapter(this)
            rv_main.addOnScrollListener(object : OnScrollListener() {

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (recyclerView.scrollState == SCROLL_STATE_IDLE) {
                        var index = (rv_main.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                        var view = rv_main.get(index).findViewById<CustomTextureView>(R.id.ctv_item)
                        Log.d(com.gess.appkotlin.widget.TAG, "$index = $view")
                        Log.d(com.gess.appkotlin.widget.TAG, "${recyclerView.scrollState}")
                        if (view.mSurface != null) {
                            view.customPlay()
                        }
                    }
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                }
            })
        }, 1000)
    }
}
