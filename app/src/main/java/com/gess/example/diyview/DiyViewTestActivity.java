package com.gess.example.diyview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gess.example.R;
import com.gess.example.statusBar.StatusActivity;
import com.gess.note.BaseActivity;

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
