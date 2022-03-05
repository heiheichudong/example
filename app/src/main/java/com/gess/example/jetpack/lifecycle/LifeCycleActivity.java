package com.gess.example.jetpack.lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gess.example.R;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;

public class LifeCycleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        TestLifeCycle testLifeCycle = new TestLifeCycle(findViewById(R.id.chronometer));
        getLifecycle().addObserver(testLifeCycle);
    }
}
