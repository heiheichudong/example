package com.gess.appkotlin.example.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gess.appkotlin.R
import com.gess.appkotlin.widget.calendar.SignDataBean
import com.gess.appkotlin.widget.calendar.SignFragment
import com.gess.appkotlin.widget.calendar.SignView

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        val signView = findViewById<SignView>(R.id.sv)
        signView.setListener(object : SignFragment.ClickDayListener {
            override fun clickDay(dataBean: SignDataBean) {
//                Log.d("SignActivity", "${dataBean.year}年${dataBean.month}月${dataBean.day}号")
                Log.d("SignActivity", "${SignFragment.getToday().year}年${SignFragment.getToday().month}月${SignFragment.getToday().day}号")
                Toast.makeText(this@SignActivity,
                        "${dataBean.year}年${dataBean.month}月${dataBean.day}号",
                        Toast.LENGTH_SHORT).show()

            }
        })
    }
}