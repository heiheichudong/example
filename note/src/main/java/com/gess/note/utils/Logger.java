package com.gess.note.utils;

import android.util.Log;

import com.gess.note.BuildConfig;


public class Logger {

    public static void debug(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d("Logger", msg);
        }
    }

    public static void debug(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }
}
