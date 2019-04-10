package com.gess.example;

import android.app.Application;

import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;


public class MainApp extends Application {
    String ugcLicenceUrl = "http://license.vod2.myqcloud.com/license/v1/01abedac1b73522a375df36b081a5682/TXUgcSDK.licence"; //您从控制台申请的licence url
    String ugcKey = "2296f2e3ffd7746180c08c8cc97c4e83";//您从控制台申请的licence key

    private MainApp instance;

    public MainApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
//        TXLiveBase.getInstance().setLicence(instance, ugcLicenceUrl, ugcKey);
//        TXLiveBase.setConsoleEnabled(true);
//        TXLiveBase.setLogLevel(TXLiveConstants.LOG_LEVEL_DEBUG);
    }
}
