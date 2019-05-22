package com.gess.example.video;

import android.os.Bundle;

import com.gess.example.R;

import androidx.appcompat.app.AppCompatActivity;

public class DiyTextureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy_texture);
        ((DiyTextureView) findViewById(R.id.diy_tv_a)).setPath("http://mvideo.mimi.com/m3u8/2019/2/3/2D70FDBBC033B3229D3E07D4AC4CB18F0B630B1E82DE532532D05D49E1340A43/360/out.m3u8");
    }
}
