package com.gess.appkotlin.widget

import android.content.Context
import android.graphics.SurfaceTexture
import android.util.AttributeSet
import android.util.Log
import android.view.Surface
import android.view.TextureView
import com.gess.appkotlin.MEDIA_STATE_IDLE
import com.gess.appkotlin.mediaPlayer

val TAG = "CustomTextureView"

class CustomTextureView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : TextureView(context, attrs, defStyleAttr) {

    init {
        init()
    }

    private var media_state = MEDIA_STATE_IDLE
    var mSurface: Surface? = null
    var path = ""


    private fun init() {
        surfaceTextureListener = object : SurfaceTextureListener {
            override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
//                Log.d(TAG, "onSurfaceTextureSizeChanged")
            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
//                Log.d(TAG, "onSurfaceTextureUpdated")
            }

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
                Log.d(TAG, "onSurfaceTextureDestroyed")
                mediaPlayer.reset()
                return true
            }

            override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
                Log.d(TAG, "onSurfaceTextureAvailable = ${this@CustomTextureView}")
                mediaPlayer.apply {
                    mSurface = Surface(surface)
//                    setSurface(mSurface)
//                    customPlay()
                }
            }
        }
    }


    fun customPlay() {
        if (path.isNullOrEmpty()) return
        Log.d(TAG, "customPlay = ${this@CustomTextureView}")
        mediaPlayer.apply {
            reset()
            media_state = MEDIA_STATE_IDLE
            setSurface(mSurface)

            setOnCompletionListener {

            }
            setOnPreparedListener {
                Log.d(TAG, "start = ${this@CustomTextureView}")
                start()
            }
            setOnErrorListener { mp, what, extra ->
                mp.reset()
                true
            }
            setDataSource(path)
            prepareAsync()

        }
    }


}


