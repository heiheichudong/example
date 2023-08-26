package com.gess.appkotlin.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gess.appkotlin.R
import com.gess.appkotlin.example.calendar.SignActivity
import com.gess.appkotlin.example.tab.TabLayoutActivity
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        btn_tabLayout.setOnClickListener {
            startActivity(Intent(this, TabLayoutActivity::class.java))
        }
        btn_sign.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))
        }
    }
}
