package com.gess.appkotlin.example.tab

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.graphics.ImageFormat
import android.util.AttributeSet
import androidx.core.graphics.BitmapCompat
import androidx.core.view.setPadding
import com.google.android.material.tabs.TabLayout

class TabUtilityLayout(context: Context) : TabLayout(context) {
    constructor(context: Context,attr: AttributeSet) : this(context)
    constructor(context: Context,attr: AttributeSet,defStyleAttr:Int) : this(context)

    fun getGradient(){
//        tabSelectedIndicator

    }
}