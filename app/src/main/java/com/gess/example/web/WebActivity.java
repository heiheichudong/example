package com.gess.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gess.example.R;

public class WebActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv = ((WebView) findViewById(R.id.wv));



//        wv.setWebViewClient(new WebViewClient());
//        wv.setWebChromeClient(new WebChromeClient());
//        wv.getSettings().setJavaScriptEnabled(true);
//        wv.loadUrl("http://reg.lyb.tv/#/?puid=43330");

        WebSettings setting = wv.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setAllowContentAccess(true);
        setting.setAppCacheEnabled(true);
        setting.setBuiltInZoomControls(false);
        setting.setUseWideViewPort(true);
        setting.setLoadWithOverviewMode(true);
        setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv.loadUrl("http://reg.lyb.tv/#/?puid=43330");
        wv.setWebChromeClient(new WebChromeClient());


        wv.loadUrl("http://reg.lyb.tv/#/?puid=43330");
        initWebView(wv);
        initSetting(wv);
    }

    private static final String CODING = "UTF-8"; // 编码格式

    public static void initSetting(WebView webView) {

        //如果访问的页面中有Javascript，则webview必须设置支持Javascript
        WebSettings settings = webView.getSettings();

        //设置运行加载js
        settings.setJavaScriptEnabled(true);
        // 允许js弹出窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //设置编码
        settings.setDefaultTextEncodingName(CODING);
        //设置支持DomStorage
        settings.setDomStorageEnabled(true);
        // 实现8倍缓存
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setAllowFileAccess(true);
        // 开启Application Cache功能
        settings.setAppCacheEnabled(true);
        //取得缓存路径
        String appCachePath = webView.getContext().getApplicationContext().getCacheDir().getAbsolutePath();
        //        String chejusPath = getFilesDir().getAbsolutePath()+ APP_CACHE_DIRNAME;
        //设置路径
        //API 19 deprecated
        settings.setDatabasePath(appCachePath);
        // 设置Application caches缓存目录
        settings.setAppCachePath(appCachePath);
        //是否启用数据库
        settings.setDatabaseEnabled(true);
        //设置存储模式 建议缓存策略为，判断是否有网络，有的话，使用LOAD_DEFAULT,无网络时，使用LOAD_CACHE_ELSE_NETWORK
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //设置不支持字体缩放
        settings.setSupportZoom(true);
        //设置对应的cookie具体设置有子类重写该方法来实现
        //还有一种是加载https的URL时在5.0以上加载不了，5.0以下可以加载，这种情况可能是网页中存在非https得资源，在5.0以上是默认关闭，需要设置，
        //		loadWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setAllowUniversalAccessFromFileURLs(true);


        //扩大比例的缩放
        settings.setUseWideViewPort(true);
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        //////////////////////////////////////////////
        WebView.setWebContentsDebuggingEnabled(true);
    }


    public static void initWebView(WebView webView) {
        // 设置具体WebViewClient
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
        });
        webView.setBackgroundColor(0);
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);//https://blog.csdn.net/u013372185/article/details/77292364
        //js调用Android方法  如果页面上面有多个的话，可以注册多个方法
        //submitFromWeb 要和js那边定义的一样就可以了

    }
}