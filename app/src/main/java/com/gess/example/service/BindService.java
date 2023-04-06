package com.gess.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.ServiceAidlInterface;

public class BindService extends Service {
    private static String TAG = "BindService";

    public BindService() {
        LogUtils.d(TAG, "BindService 构造函数---------");
    }

    @Override
    public IBinder onBind(Intent intent) {
//        return new ServiceBinder();
        return new ServiceAidlInterface.Stub() {
            @Override
            public void callStart() throws RemoteException {

            }

            @Override
            public void callStop() throws RemoteException {

            }
        };
    }

    /*class ServiceBinder extends Binder {
        void callStart() {
            LogUtils.d(TAG, "BindService callStart---------");
            start();
        }

        void callStop() {
            LogUtils.d(TAG, "BindService callStop---------");
            stop();
        }
    }

    void start() {
        LogUtils.d(TAG, "BindService start---------");
    }

    void stop() {
        LogUtils.d(TAG, "BindService stop---------");
    }*/

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.d(TAG, "BindService onUnbind---------");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        LogUtils.d(TAG, "BindService onCreate---------");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        LogUtils.d(TAG, "BindService onDestroy---------");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d(TAG, "BindService onStartCommand---------");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        LogUtils.d(TAG, "BindService onStart---------");
        super.onStart(intent, startId);
    }
}