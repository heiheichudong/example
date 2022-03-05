package com.gess.example.jetpack.lifecycle;

import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.blankj.utilcode.util.LogUtils;

public class TestLifeCycle implements LifecycleObserver {

    public final static String TAG = TestLifeCycle.class.getSimpleName();

    private Chronometer chronometer;
    private Long elapsedTime = 0L;

    public TestLifeCycle(Chronometer chronometer) {
        this.chronometer = chronometer;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        LogUtils.d(TAG,"onCreate ---- ");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        LogUtils.d(TAG,"onResume ---- ");
        chronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        chronometer.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause(){
        LogUtils.d(TAG,"onPause ---- ");
        elapsedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
        chronometer.stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        LogUtils.d(TAG,"onDestroy ---- ");
        chronometer.destroyDrawingCache();
    }
}
