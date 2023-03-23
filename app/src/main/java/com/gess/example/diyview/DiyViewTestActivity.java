package com.gess.example.diyview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.example.Sign;
import com.gess.example.statusBar.StatusActivity;
import com.gess.note.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class DiyViewTestActivity extends BaseActivity implements View.OnClickListener, RecordVideoView.changeRecordlistent {

    private VideoRecordView recordView;
    private RecordVideoView videoView;
    private DiyViewTest test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_view_test_activitty);
        test = findViewById(R.id.dvt);
        test.setOnClickListener(this);
        recordView = findViewById(R.id.vrv_diy);
        videoView = findViewById(R.id.rvv);
        videoView.setOnClickListener(this);
        videoView.setRecordlistent(this);


        findViewById(R.id.btn_sva).setOnClickListener(this);
        findViewById(R.id.btn_ssva).setOnClickListener(this);
        findViewById(R.id.btn_music_crop).setOnClickListener(this);
        findViewById(R.id.cv_crv).setOnClickListener(this);
        findViewById(R.id.vrv_diy).setOnClickListener(this);
        findViewById(R.id.riv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dvt:
                startActivity(new Intent(this, StatusActivity.class));
                break;
            case R.id.rvv:
//                if (videoView.getRecordVideoStatus() == RecordVideoView.status.INTNIAL_END) {
//                    videoView.setRecordVideoStatus(RecordVideoView.status.ACTION_BEFORE);
//                }
//                if (videoView.getRecordVideoStatus() == RecordVideoView.status.ACTION_AFTER) {
//                    videoView.setRecordVideoStatus(RecordVideoView.status.SCALE_BEFORE);
//                }
                break;
            case R.id.btn_sva:
                startActivity(new Intent(this, ScaleViewActivity.class));
                break;
            case R.id.btn_ssva:
                startActivity(new Intent(this, SimpleScaleViewActivity.class));
                break;
            case R.id.btn_music_crop:
                startActivity(new Intent(this, ScaleViewTestActivity.class));
                break;
            case R.id.vrv_diy:
//                startActivity(new Intent(this, CorpMusicActivity.class));
                startActivity(new Intent(this, ScaleViewTestActivity.class));
                break;
            case R.id.cv_crv:
                startActivity(new Intent(this, CircleRotateActivity.class));
                break;
            case R.id.riv:
                /*LogUtils.d("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssss = 111111111111" );
                Long time = System.currentTimeMillis() / 1000;
//                int time = 1647499053;
                TreeMap p = new TreeMap<String,String>();
                try {
                    p.put("timestamp",URLEncoder.encode("" + time,"UTF-8"));
                    p.put("sign_ver",URLEncoder.encode("1.0","UTF-8"));
                    p.put("app_secret",URLEncoder.encode("ZjA3MjU0Nzk2MjE0YzIyOTYzMGUwN2MxNzcyM2JlYzU0ZGFkMTJjZjEyMDVlNjQ3Y2ZhMGUwOWRiY2YwOWE1Mw==","UTF-8"));
                    p.put("app_id",URLEncoder.encode("be11563dd9","UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
//                String par = "timestamp="+time+"&sign_ver=1.0&app_secret=ZjA3MjU0Nzk2MjE0YzIyOTYzMGUwN2MxNzcyM2JlYzU0ZGFkMTJjZjEyMDVlNjQ3Y2ZhMGUwOWRiY2YwOWE1Mw==&app_id=be11563dd9";
//                String par = "timestamp=1647499053&sign_ver=1.0&app_secret=ZjA3MjU0Nzk2MjE0YzIyOTYzMGUwN2MxNzcyM2JlYzU0ZGFkMTJjZjEyMDVlNjQ3Y2ZhMGUwOWRiY2YwOWE1Mw%3D%3D&app_id=be11563dd9";
//                String par = "timestamp=1647499053&sign_ver=1.0&app_secret=ZjA3MjU0Nzk2MjE0YzIyOTYzMGUwN2MxNzcyM2JlYzU0ZGFkMTJjZjEyMDVlNjQ3Y2ZhMGUwOWRiY2YwOWE1Mw==&app_id=be11563dd9";
                String s = Sign.INSTANCE.sign(p.descendingMap());
                try {
                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            //其他配置
                            .build();
                    OkHttpUtils.initClient(okHttpClient);
                    OkHttpUtils.post().url("https://api.haolemall.com/api/v1/getAccessToken")
                            .addParams("app_id","be11563dd9")
                            .addParams("timestamp",time + "")
                            .addParams("signature",s).build().execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            e.printStackTrace();
                            LogUtils.d("sssssssssssssssssssss=========== " + e.getMessage());
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            LogUtils.d("sssssssssssssssssssss=========== " + response);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                startActivity(new Intent(this, RecyclerViewProgressBarActivity.class));
                break;
        }
    }

    @Override
    public void recording() {
        Log.d(RecordVideoView.TAG, "录制中 ... ");
    }

    @Override
    public void stopRecord() {
        Log.d(RecordVideoView.TAG, "已停止录制 ... ");
    }

    @Override
    public void takePhoto() {

    }
}
