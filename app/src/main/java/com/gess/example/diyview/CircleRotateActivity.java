package com.gess.example.diyview;

import android.os.Bundle;
import android.view.View;

import com.gess.example.R;
import com.gess.note.BaseActivity;

public class CircleRotateActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_rotate);

        findViewById(R.id.btu_crv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btu_crv:
                //TODO implement
                break;
        }
    }
}
