package com.gess.appkotlin.widget

import android.content.Context
import android.graphics.SurfaceTexture
import android.util.AttributeSet
import android.view.Surface
import android.view.TextureView
import com.gess.appkotlin.mediaPlayer


class CustomTextureView(context: Context?) : TextureView(context) {

    constructor(context: Context?, attrs: AttributeSet) : this(context)
    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs) {
        init()
    }

    private fun init() {
        surfaceTextureListener = object : SurfaceTextureListener{
            override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {

            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {

            }

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
                return true
            }

            override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
                mediaPlayer.apply {
                    var surface = Surface(surface)
                    setSurface(surface)
                }
            }
        }
    }

    fun customPlay(){
        mediaPlayer.reset()

    }
}


