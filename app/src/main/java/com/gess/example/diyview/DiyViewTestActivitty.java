package com.gess.example.diyview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gess.example.R;
import com.gess.example.statusBar.StatusActivity;

import androidx.appcompat.app.AppCompatActivity;

public class DiyViewTestActivitty extends AppCompatActivity implements View.OnClickListener, RecordVideoView.changeRecordlistent {

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
        }
    }

    @Override
    public void recording() {
        Log.d(RecordVideoView.TAG,"录制中 ... ");
    }

    @Override
    public void stopRecord() {
        Log.d(RecordVideoView.TAG,"已停止录制 ... ");
    }

    @Override
    public void takePhoto() {

    }
}
