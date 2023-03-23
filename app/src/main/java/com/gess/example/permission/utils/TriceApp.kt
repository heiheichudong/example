package com.gess.example.permission.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.Gravity
import com.blankj.utilcode.util.ToastUtils


const val PACKAGE_NAME_BAIDU = "com.baidu.BaiduMap";
const val PACKAGE_NAME_GAODE = "com.autonavi.minimap";
const val PACKAGE_NAME_TENGXUN = "com.tencent.map";

/**调起第三方地图APP导航*/
fun openMapToDaoHan(packageName: String, context: Context,a:String,b:String){
    var showToastTxt: String = ""
    try {
        when (packageName) {
            PACKAGE_NAME_BAIDU -> {
                showToastTxt = "手机未安装百度地图APP"
                val intent = Intent()
                intent.data =
                    Uri.parse("baidumap://map/direction?region=$a&destination=$b&coord_type=bd09ll&mode=driving&src=andr.baidu.openAPIdemo")
                context.startActivity(intent)
            }
            PACKAGE_NAME_GAODE -> {
                showToastTxt = "手机未安装高德地图APP"
                val intent = Intent()
                intent.data =
                    Uri.parse("amapuri://route/plan/?sid=&sname=$a&dname=$b&dev=0&t=0")
                intent.action = Intent.ACTION_VIEW
                intent.setPackage("com.autonavi.minimap")
                intent.addCategory(Intent.CATEGORY_DEFAULT)
                context.startActivity(intent)
            }
            PACKAGE_NAME_TENGXUN -> {
                showToastTxt = "手机未安装腾讯地图APP"
                val intent = Intent()
                intent.data = Uri.parse("qqmap://map/routeplan?type=drive&from=$a&to=$b&referer=OB4BZ-D4W3U-B7VVO-4PJWW-6TKDJ-WPB77")
                context?.startActivity(intent)
            }
        }
    }catch(ex: ActivityNotFoundException){
        ToastUtils.setGravity(Gravity.TOP,0,0)
        ToastUtils.showLong(showToastTxt)
    }
}


