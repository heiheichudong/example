package com.gess.example;

import android.app.Application;
import android.util.DisplayMetrics;

import com.gess.note.utils.Utils;


public class MainApp extends Application {

    /**
     * 屏幕宽度
     */
    public static int screenWidth;
    /**
     * 屏幕高度
     */
    public static int screenHeight;
    /**
     * 屏幕密度
     */
    public static float screenDensity;

    String ugcLicenceUrl = "http://license.vod2.myqcloud.com/license/v1/01abedac1b73522a375df36b081a5682/TXUgcSDK.licence"; //您从控制台申请的licence url
    String ugcKey = "2296f2e3ffd7746180c08c8cc97c4e83";//您从控制台申请的licence key

    private MainApp instance;

    public MainApp getInstance() {
        return instance;
    }

    private void initScreenSize() {
        DisplayMetrics curMetrics = getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = curMetrics.widthPixels;
        screenHeight = curMetrics.heightPixels;
        screenDensity = curMetrics.density;
//        if (screenHeight == 2070){
//            screenHeight = 2160;
//        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        Utils.init(getApplicationContext());
        initScreenSize();
//        TXLiveBase.getInstance().setLicence(instance, ugcLicenceUrl, ugcKey);
//        TXLiveBase.setConsoleEnabled(true);
//        TXLiveBase.setLogLevel(TXLiveConstants.LOG_LEVEL_DEBUG);
    }
}
