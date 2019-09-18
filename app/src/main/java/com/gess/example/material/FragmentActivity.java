package com.gess.example.material;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gess.example.R;


public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ActivityFragment.newInstance())
                    .commitNow();
        }
    }
}
