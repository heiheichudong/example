package com.gess.example.jetpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gess.example.R;
import com.gess.example.jetpack.lifecycle.LifeCycleActivity;

public class JetpackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack);
    }


    public void jetpack(View view) {
        switch (view.getId()){
            case R.id.tv_jetpack_lifecycle:
                startActivity(new Intent(this, LifeCycleActivity.class));
                break;
        }
    }
}