package com.gess.example.video;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.gess.example.R;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private String path = "/storage/emulated/0/picwall/tmp/555.mp4";
    private String path1 = "/storage/emulated/0/picwall/tmp/333.mp4";
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        videoView = findViewById(R.id.vv_f_sw);
        findViewById(R.id.btn_vv_start).setOnClickListener(this);
        findViewById(R.id.btn_f_sw).setOnClickListener(this);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 征对于Android 8.0
            AudioFocusRequest audioFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                    .setOnAudioFocusChangeListener(focusChangeListener).build();
            audioFocusRequest.acceptsDelayedFocusGain();
            audioManager.requestAudioFocus(audioFocusRequest);
        } else {
            // 小于Android 8.0
            int result = audioManager.requestAudioFocus(focusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
            if (result != AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                // could not get audio focus.
            }
        }

    }

    AudioManager.OnAudioFocusChangeListener focusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    // 获取audio focus
                    if (mediaPlayer == null)
                        mediaPlayer = new MediaPlayer();
                    else if (!mediaPlayer.isPlaying())
                        mediaPlayer.start();
                    mediaPlayer.setVolume(1.0f, 1.0f);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    // 失去audio focus很长一段时间，必须停止所有的audio播放，清理资源
                    if (mediaPlayer.isPlaying())
                        mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    // 暂时失去audio focus，但是很快就会重新获得，在此状态应该暂停所有音频播放，但是不能清除资源
                    if (mediaPlayer.isPlaying())
                        mediaPlayer.pause();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    // 暂时失去 audio focus，但是允许持续播放音频(以很小的声音)，不需要完全停止播放。
                    if (mediaPlayer.isPlaying())
                        mediaPlayer.setVolume(0.1f, 0.1f);
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        try{

            switch (v.getId()){
                case R.id.btn_vv_start:
//                videoView.setVideoPath(path1);
//                videoView.start();

                    mediaPlayer.setDataSource(path1);
                    mediaPlayer.start();
                    break;
                case R.id.btn_f_sw:
//                videoView.setVideoPath(path);
//                videoView.start();

                    mediaPlayer.setDataSource(path);
                    mediaPlayer.start();

                    isExist();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void isExist() {
        //通过Environment.getExternalStorageDirectory().getPath()获取我也没搞清楚是SD卡还是内部存储  我是华为V8 没有外置SD卡
        String filePath = Environment.getExternalStorageDirectory().getPath() + "/picwall/tmp/333.mp4";
        File file = new File(filePath);
        if(file.exists()) {
            Toast.makeText(this, "存在 -",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "不存在 -",Toast.LENGTH_SHORT).show();
        }
    }
}
