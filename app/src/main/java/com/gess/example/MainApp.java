package com.gess.example;

import android.app.Application;
import android.util.DisplayMetrics;

import com.blankj.utilcode.util.Utils;
import com.gess.example.hilt.ApplicationComponent;
import com.gess.example.hilt.DaggerApplicationComponent;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;


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

    private static MainApp instance;

    public static MainApp getInstance() {
        return instance;
    }

    private ApplicationComponent dagger = DaggerApplicationComponent.create();

    public ApplicationComponent getDagger() {
        return dagger;
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

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

        setJpush();
    }

    private void setJpush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
