package com.gess.example.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;

import com.blankj.utilcode.util.LogUtils;

public class StartService extends Service {
    private static String TAG = "StartService";
    public StartService() {
        LogUtils.d(TAG,"StartService 构造函数---------");
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d(TAG,"StartService onBind---------");
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d(TAG,"StartService onCreate---------");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        LogUtils.d(TAG,"StartService onStart---------");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d(TAG,"StartService onStartCommand---------");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtils.d(TAG,"StartService onDestroy---------");
        super.onDestroy();
    }
}