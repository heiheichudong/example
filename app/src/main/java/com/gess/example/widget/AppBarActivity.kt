package com.gess.example.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gess.example.R
import com.gess.example.list.ListAdapter
import com.gess.example.list.TestBean
import java.util.ArrayList

class AppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar)

        val rv = findViewById<RecyclerView>(R.id.rv_bar)
        val adapter = ListAdapter(rv)
        rv.adapter = adapter
        val list: ArrayList<TestBean?> = ArrayList<TestBean?>()
        for (i in 0..24) {
            val tb = TestBean(i.toString() + "", "第" + i + "项", "第" + i + "项 内容")
            list.add(tb)
        }
        adapter.addMoreData(list)
    }
}