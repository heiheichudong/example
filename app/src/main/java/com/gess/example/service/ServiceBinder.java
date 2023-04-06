package com.gess.example.service;

import android.os.Binder;

import com.blankj.utilcode.util.LogUtils;

public class ServiceBinder extends Binder {

    void callStart() {
        LogUtils.d("ServiceBinder", "BindService callStart---------");
//        start();
    }

    void callStop() {
        LogUtils.d("ServiceBinder", "BindService callStop---------");
//        stop();
    }
}
