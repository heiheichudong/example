package com.gess.appkotlin.example.http

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gess.appkotlin.R

class HttpActivity : AppCompatActivity() {

    val vm :HttpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http)

    }

}