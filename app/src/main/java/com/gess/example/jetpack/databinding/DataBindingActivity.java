package com.gess.example.jetpack.databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gess.example.R;
import com.gess.example.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);
        ActivityDataBindingBinding binding = ActivityDataBindingBinding.inflate(getLayoutInflater());

    }
}