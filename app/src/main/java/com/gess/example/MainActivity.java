package com.gess.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gess.example.statusBar.ColorActivity;
import com.gess.example.statusBar.MatchActionBarActivity;
import com.gess.example.statusBar.SamplesListActivity;
import com.gess.example.statusBar.StatusBarUtil;
import com.tencent.rtmp.TXLiveBase;

public class MainActivity extends AppCompatActivity {

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
                startActivity(new Intent(this, ColorActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(this, MatchActionBarActivity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(this, SamplesListActivity.class));
                break;
            case R.id.btn_4:
                StatusBarUtil.setTranslucentStatus(this);
                break;
        }
    }
}
