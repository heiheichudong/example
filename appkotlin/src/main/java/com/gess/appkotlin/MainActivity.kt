package com.gess.appkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import com.gess.appkotlin.ui.WebActivity
import com.gess.appkotlin.ui.home.HomeAdapter
import com.gess.appkotlin.widget.CustomTextureView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main.text = "MainActivity"
        tv_main.setOnClickListener {
            val intent = Intent(this,WebActivity::class.java)
            startActivity(intent)
        }
        rv_main.postDelayed(Runnable {
            rv_main.layoutManager = LinearLayoutManager(this)
            rv_main.adapter = HomeAdapter(this)
            /*rv_main.addOnScrollListener(object : OnScrollListener() {

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (recyclerView.scrollState == SCROLL_STATE_IDLE) {
                        var index = (rv_main.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                        if (index < 0) return
                        var view = rv_main.get(index).findViewById<CustomTextureView>(R.id.ctv_item)
                        Log.d(com.gess.appkotlin.widget.TAG, "$index = $view")
                        Log.d(com.gess.appkotlin.widget.TAG, "${recyclerView.scrollState}")
//                        if (view.mSurface != null) {
//                            view.customPlay()
//                        }
                    }
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                }
            })*/
        }, 1000)

        /*rv_main.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                Log.d(com.gess.appkotlin.widget.TAG, "onTouchEvent")

            }

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
//                Log.d(com.gess.appkotlin.widget.TAG,"y = ${e.y}" )
//                var view = rv.findChildViewUnder(e.x,e.y)
//                if (view is ScrollView) view.scrollY = e.y.toInt()
//                return true
//                return if(view is ScrollView){
//                    scroll2Top(view) || scroll2Bottom(view)
//                }else false
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                Log.d(com.gess.appkotlin.widget.TAG, "onRequestDisallowInterceptTouchEvent")
            }

        })*/

    }

}

fun scroll2Top(scrollView: ScrollView): Boolean =
        if (scrollView != null) { scrollView.scrollY == 0 }else false


fun scroll2Bottom(scrollView: ScrollView): Boolean =
        if (scrollView != null) {
            scrollView.getChildAt(0).getMeasuredHeight() <= scrollView.getScrollY() + scrollView.getHeight()
        }else false
