package com.gess.example.opengl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gess.example.R;
import com.gess.example.opengl.gl1.GlOneActivity;
import com.gess.example.opengl.gl2.GltwoActivity;
import com.gess.example.statusBar.StatusActivity;

public class GlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl);
    }

    public void opengl(View view) {
        switch (view.getId()) {
            case R.id.gl1:
                startActivity(new Intent(this, GlOneActivity.class));
                break;
            case R.id.gl2:
                startActivity(new Intent(this, GltwoActivity.class));
                break;
        }
    }
}
