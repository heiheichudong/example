package com.gess.note.utils;

import android.content.Context;
import android.content.pm.PackageManager;

public class PlatformUtil {

    public static final String[] PLATFORM_NAME = {
            "INSTAGRAM",
            "FACE_BOOK",
            "MESSENGER",
            "WHATS_APP",
            "GMAIL",
            "GOOGLE_MAP",
            "ALLO",
            "MEITUAN_WAIMAI",
            "E_LE_ME",
            "MO_BAI",
            "OFO",
            "JIN_RI_TOU_TIAO",
            "SINA_WEI_BO",
            "WANG_YI_XIN_WEN",
            "KUAI_SHOU",
            "ZHI_HU",
            "HU_YA_ZHI_BO",
            "YING_KE_ZHI_BO",
            "MIAO_PAI",
            "MEI_TU_XIU_XIU",
            "MEI_YAN_XIANG_JI",
            "XIE_CHENG",
            "MO_MO",
            "YOU_KU",
            "AI_QI_YI",
            "DI_DI",
            "ZHI_FU_BAO",
            "TAO_BAO",
            "JING_DONG",
            "DA_ZONG_DIAN_PING",
            "JIAN_SHU",
            "BAI_DU_DI_TU",
            "GAO_DE_DI_TU",
            "WEI_XIN",
            "QQ",
    };

    public static final String[] PLATFORMS = {
            "com.instagram.android",
            "com.facebook.katana",
            "com.facebook.orca",
            "com.whatsapp",
            "com.google.android.gm",
            "com.google.android.apps.maps",
            "com.google.android.apps.fireball",
            "com.sankuai.meituan.takeoutnew",
            "me.ele",
            "com.mobike.mobikeapp",
            "so.ofo.labofo",
            "com.ss.android.article.news",
            "com.sina.weibo",
            "com.netease.newsreader.activity",
            "com.smile.gifmaker",
            "com.zhihu.android",
            "com.duowan.kiwi",
            "com.meelive.ingkee",
            "com.yixia.videoeditor",
            "com.mt.mtxx.mtxx",
            "com.meitu.meiyancamera",
            "ctrip.android.view",
            "com.immomo.momo",
            "com.youku.phone",
            "com.qiyi.video",
            "com.sdu.didi.psnger",
            "com.eg.android.AlipayGphone",
            "com.taobao.taobao",
            "com.jingdong.app.mall",
            "com.dianping.v1",
            "com.jianshu.haruki",
            "com.baidu.BaiduMap",
            "com.autonavi.minimap",
            "com.tencent.mm",
            "com.tencent.mobileqq",
    };

    public static boolean isAppInstalled(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }
}
