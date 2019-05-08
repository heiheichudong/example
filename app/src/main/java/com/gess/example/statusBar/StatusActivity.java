package com.gess.example.statusBar;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gess.example.R;

public class StatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
    }

    public void button(View v) {
        switch (v.getId()) {
            case R.id.btn_sb_color:
                startActivity(new Intent(this, ColorActivity.class));
                break;
            case R.id.btn_sb_list:
                startActivity(new Intent(this, MatchActionBarActivity.class));
                break;
            case R.id.btn_sb_match:
                startActivity(new Intent(this, SamplesListActivity.class));
                break;

        }
    }
}
