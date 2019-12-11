package com.gess.appkotlin

import android.media.MediaPlayer

const val MEDIA_STATE_IDLE = 0
const val MEDIA_STATE_END = 1
const val MEDIA_STATE_INITIALIZIZED = 2
const val MEDIA_STATE_PREPARED = 3
const val MEDIA_STATE_PREPARING = 4
const val MEDIA_STATE_STARTED = 5
const val MEDIA_STATE_STOPED = 6
const val MEDIA_STATE_PAUSED = 7
const val MEDIA_STATE_COMPLETED = 8
const val MEDIA_STATE_ERROR = 9
//const val MEDIA_STATE_SURFACE = 10

val mediaPlayer by lazy {
    MediaPlayer()
}

fun release() {
    mediaPlayer.apply {
        reset()
        release()
    }
}
