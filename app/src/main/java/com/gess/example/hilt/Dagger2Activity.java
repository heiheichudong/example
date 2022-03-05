package com.gess.example.hilt;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.MainApp;

import javax.inject.Inject;

public class Dagger2Activity extends AppCompatActivity {

    @Inject
    SubBean subBean;
    @Inject
    ApiService service2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApp.getInstance().getDagger().subFactory().create().inject(this);
        LogUtils.d("sub--- "+subBean.toString());
        LogUtils.d("sub--- " + service2.toString());
    }
}
