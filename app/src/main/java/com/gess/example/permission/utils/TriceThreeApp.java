package com.gess.example.permission.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class TriceThreeApp {
    /**
     * 百度: http://lbsyun.baidu.com/index.php?title=uri/api/android
     * 高德: https://lbs.amap.com/api/amap-mobile/guide/android/route
     * 腾讯: https://lbs.qq.com/uri_v1/guide-mobile-navAndRoute.html
     * @param mContext
     */
    public static void triceGD(Context mContext,String sname,String dname){
        Intent intent = new Intent();
        intent.setData(Uri.parse("amapuri://route/plan/?sid=&sname="+sname+"&dname="+dname+"&dev=0&t=0"));
        intent.setAction(Intent.ACTION_VIEW);
        intent.setPackage("com.autonavi.minimap");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        mContext.startActivity(intent);
    }

    public static void triceBD(Context mContext,String sname,String dname){
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("baidumap://map/direction?region="+sname+"&destination="+dname+"&coord_type=bd09ll&mode=driving&src=andr.baidu.openAPIdemo"));
            mContext.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
