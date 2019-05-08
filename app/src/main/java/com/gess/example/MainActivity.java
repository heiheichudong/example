package com.gess.example;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gess.example.regular.RegularActivity;
import com.gess.example.statusBar.StatusActivity;
import com.gess.example.video.MainVideoActivity;
import com.tencent.rtmp.TXLiveBase;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String data = " @昵称&用户名";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String sdkver = TXLiveBase.getSDKVersionStr();
        Log.d("liteavsdk", "liteav sdk version is : " + sdkver);
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
                pauseMusic();
                break;
            case R.id.btn_4:
                startActivity(new Intent(this, RegularActivity.class));
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
        }else {
            audioManager.abandonAudioFocus(null);
        }
    }

}
