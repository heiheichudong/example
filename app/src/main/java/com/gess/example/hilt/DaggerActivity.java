package com.gess.example.hilt;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.MainApp;
import com.gess.example.R;

import javax.inject.Inject;

import retrofit2.Retrofit;


public class DaggerActivity extends AppCompatActivity {

    @Inject
    DaggerTestBean bean;
    @Inject
    Retrofit retrofit;
    @Inject
    ApiService service1;
    @Inject
    ApiService service2;
    @Inject
    SubBean sub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
//        DaggerApplicationComponent.create().inject(this);
//        MainApp.getInstance().getDagger().inject(this);
        MainApp.getInstance().getDagger().subFactory().create().inject(this);
        LogUtils.d(bean.toString());
        LogUtils.d(retrofit.toString());
        LogUtils.d(service1.toString());
        LogUtils.d(service2.toString());
        LogUtils.d("sub--- " + service2.toString());
        LogUtils.d("sub--- "+sub.toString());
        startActivity(new Intent(this,Dagger2Activity.class));
    }
}
