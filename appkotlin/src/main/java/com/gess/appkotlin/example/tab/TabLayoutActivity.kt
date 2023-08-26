package com.gess.appkotlin.example.tab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.gess.appkotlin.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_layout.*
import java.lang.Exception

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        findViewById<Button>(R.id.btn_tab).setOnClickListener {
            throw Exception()
        }
        initTabLayout0()
    }

    private fun initTabLayout0() {
        for (s in resources.getStringArray(R.array.subjects)) {
            Log.d("ttttttttttttt",s)
            tl_example_0.addTab(tl_example_0.newTab().setText(s))
//            val tl = findViewById<TabLayout>(R.id.tl_example_0)
//            val tab = TabLayout.Tab()
//            tab.text = s
//            tl.addTab(tab)
        }
    }
}