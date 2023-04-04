package com.gess.example;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.animator.AnimatorActivity;
import com.gess.example.diyview.DiyViewTestActivity;
import com.gess.example.douyin.DouyinActivity;
import com.gess.example.file.FileActivity;
import com.gess.example.fragment.FragmentContainerActivity;
import com.gess.example.gesture.GestureActivity;
import com.gess.example.hilt.DaggerActivity;
import com.gess.example.jetpack.JetpackActivity;
import com.gess.example.list.ListActivity;
import com.gess.example.material.MaterialDesignActivity;
import com.gess.example.material.TabTestActivity;
import com.gess.example.net.NetActivity;
import com.gess.example.opengl.GlActivity;
import com.gess.example.permission.MainPermissionActivity;
import com.gess.example.property.PropertyActivity;
import com.gess.example.regular.RegularActivity;
import com.gess.example.rxjava.RxActivity;
import com.gess.example.service.ServiceActivity;
import com.gess.example.statusBar.StatusActivity;
import com.gess.example.tint.TintActivity;
import com.gess.example.video.FrameActivity;
import com.gess.example.video.MainVideoActivity;
import com.gess.example.web.WebActivity;
import com.gess.example.widget.AppBarActivity;
import com.gess.note.BaseActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends BaseActivity {

//    String data = " @昵称&用户名";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtils.d("lifecycle = onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String sdkver = TXLiveBase.getSDKVersionStr();
//        Log.d("liteavsdk", "liteav sdk version is : " + sdkver);
//        setWindow();
//        getMemory();
    }

    private void setWindow() {
        Button floatingButton = new Button(this);
        floatingButton.setText("系统window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0, 0,
                PixelFormat.TRANSPARENT
        );
        // flag 设置 Window 属性
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        // type 设置 Window 类别（层级）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
//        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//        layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
//        layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
//        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        layoutParams.gravity = Gravity.CENTER;
        WindowManager windowManager = getWindowManager();
        windowManager.addView(floatingButton, layoutParams);
    }

    private void getMemory(){
        ActivityManager systemService = (ActivityManager) getBaseContext().getSystemService(Context.ACTIVITY_SERVICE);
        LogUtils.d("mmmmmmmmmmmmmmmmmmmm = "+systemService.getMemoryClass());
        LogUtils.d("mmmmmmmmmmmmmmmmmmmm = "+systemService.getLargeMemoryClass());
        LogUtils.d("mmmmmmmmmmmmmmmmmmmm = "+Runtime.getRuntime().maxMemory() / (1024 * 1024));
    }

    public void btn(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(this, StatusActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(this, MainVideoActivity.class));
                break;
            case R.id.btn_3:
//                int i = 1;
//                ((Button) findViewById(R.id.btn_3)).setText(formatValue(i));
//                pauseMusic();
                startActivity(new Intent(this, TabTestActivity.class));
                break;
            case R.id.btn_4:
                startActivity(new Intent(this, RegularActivity.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(this, DiyViewTestActivity.class));
                break;
            case R.id.btn_6:
                startActivity(new Intent(this, DouyinActivity.class));
                break;
            case R.id.btn_7:
                startActivity(new Intent(this, FragmentContainerActivity.class));
                break;
            case R.id.btn_8:
                startActivity(new Intent(this, AnimatorActivity.class));
                break;
            case R.id.btn_9:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.btn_10:
                startActivity(new Intent(this, NetActivity.class));
                break;
            case R.id.btn_11:
                startActivity(new Intent(this, FileActivity.class));
                break;
            case R.id.btn_12:
                startActivity(new Intent(this, GestureActivity.class));
                break;
            case R.id.btn_13:
                startActivity(new Intent(this, GlActivity.class));
                break;
            case R.id.btn_14:
                startActivity(new Intent(this, MaterialDesignActivity.class));
                break;
            case R.id.btn_15:
                startActivity(new Intent(this, PropertyActivity.class));
                break;
            case R.id.btn_16:
                startActivity(new Intent(this, MainPermissionActivity.class));
                break;
            case R.id.btn_17:
                startActivity(new Intent(this, TintActivity.class));
                break;
            case R.id.btn_18:
//                startActivity(new Intent(this, RxjavaActivity.class));
                startActivity(new Intent(this, RxActivity.class));
                break;
            case R.id.btn_19:
                startActivity(new Intent(this, DaggerActivity.class));
                break;
            case R.id.btn_20:
                startActivity(new Intent(this, JetpackActivity.class));
                break;
            case R.id.btn_21:
                startActivity(new Intent(this, ListActivity.class));
                break;
            case R.id.btn_22:
                startActivity(new Intent(this, WebActivity.class));
                break;
            case R.id.btn_23:
                startActivity(new Intent(this, AppBarActivity.class));
                break;
            case R.id.btn_24:
                startActivity(new Intent(this, ServiceActivity.class));
                break;
        }
    }

    private void pauseMusic() {
        //控制的地方
        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        //如果是播放状态，抢焦点，音乐播放就会暂停
        if (audioManager.isMusicActive()) {
            audioManager.requestAudioFocus(null
                    , AudioManager.STREAM_MUSIC
                    , AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        } else {
            audioManager.abandonAudioFocus(null);
        }
    }

    private static String[] suffix = new String[]{"", "k", "m", "b", "t"};
    private static int MAX_LENGTH = 4;

    private static String format(double number) {
        String r = new DecimalFormat("##0E0").format(number);
        r = r.replaceAll("E[0-9]", suffix[Character.getNumericValue(r.charAt(r.length() - 1)) / 3]);
        while (r.length() > MAX_LENGTH || r.matches("[0-9]+\\.[a-z]")) {
            r = r.substring(0, r.length() - 2) + r.substring(r.length() - 1);
        }
        return r;
    }


    public static String formatValue(double value) {
        if (value == 0) {
            return "0";
        }
        int power;
        String suffix = " kmbt";
        String formattedNumber = "";

        NumberFormat formatter = new DecimalFormat("#,###.#");
        power = (int) StrictMath.log10(value);
        value = value / (Math.pow(10, (power / 3) * 3));
        formattedNumber = formatter.format(value);
        formattedNumber = formattedNumber + suffix.charAt(power / 3);
        return formattedNumber.length() > 4 ? formattedNumber.replaceAll("\\.[0-9]+", "") : formattedNumber;
    }


    @Override
    protected void onStart() {
        LogUtils.d("lifecycle = onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LogUtils.d("lifecycle = onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtils.d("lifecycle = onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtils.d("lifecycle = onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        LogUtils.d("lifecycle = onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        LogUtils.d("lifecycle = onRestart");
        super.onRestart();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        LogUtils.d("lifecycle = onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        LogUtils.d("lifecycle = onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        LogUtils.d("lifecycle = onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

}
