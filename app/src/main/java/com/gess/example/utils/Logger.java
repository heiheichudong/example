package com.gess.example.utils;

import android.util.Log;

import com.gess.example.BuildConfig;

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
