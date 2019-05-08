package com.gess.example.video;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gess.example.MainApp;
import com.gess.example.R;
import com.gess.example.widget.TextureVideoView;
import com.tencent.ijk.media.player.IMediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class MainVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_video);
        final TextureVideoView videoView = findViewById(R.id.main_video);
        videoView.setLoop(true);
        videoView.setVideoPath("http://mvideo.mimi.com/m3u8/2019/2/3/2D70FDBBC033B3229D3E07D4AC4CB18F0B630B1E82DE532532D05D49E1340A43/360/out.m3u8");
        videoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
//                TextureUtil.setTextureViewSize(videoView,iMediaPlayer);
                Log.d("MainVideoActivity","view 宽 = " + videoView.getWidth());
                Log.d("MainVideoActivity","view 高 = " + videoView.getHeight());
                Log.d("MainVideoActivity","屏幕 宽 = " + MainApp.screenWidth);
                Log.d("MainVideoActivity","屏幕 高 = " + MainApp.screenHeight);
                Log.d("MainVideoActivity","视频 宽 = " + iMediaPlayer.getVideoWidth());
                Log.d("MainVideoActivity","视频 高 = " + iMediaPlayer.getVideoHeight());
            }
        });
    }

    public void video(View view) {
        switch (view.getId()) {
            case R.id.main_video_btn1:
                ((TextureVideoView) findViewById(R.id.main_video)).start();
                break;
            case R.id.main_video_btn2:
                ((TextureVideoView) findViewById(R.id.main_video)).pause();
                break;
        }
    }
}
