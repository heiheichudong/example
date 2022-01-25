package com.gess.example.rxjava.schedule;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Schedulers {

    private static Scheduler MAIN_THREAD = null;
    private static Scheduler NEW_THREAD = null;

    static {
        MAIN_THREAD = new HandleScheduler(new Handler(Looper.getMainLooper()));
        NEW_THREAD = new ThreadScheduler(Executors.newScheduledThreadPool(4));
    }

    public static Scheduler mainThread(){
        return MAIN_THREAD;
    }
    public static Scheduler newThread(){
        return NEW_THREAD;
    }
}
