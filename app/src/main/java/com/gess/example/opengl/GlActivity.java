package com.gess.example.opengl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.gess.example.R;
import com.gess.example.opengl.gl1.GlOneActivity;
import com.gess.example.opengl.gl2.GltwoActivity;
import com.gess.example.opengl.gl3.GlthreeActivity;
import com.gess.example.opengl.gl4.GlfourActivity;
import com.gess.example.opengl.gl5.GlfiveActivity;

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
            case R.id.gl3:
                startActivity(new Intent(this, GlthreeActivity.class));
                break;
            case R.id.gl4:
                startActivity(new Intent(this, GlfourActivity.class));
                break;
            case R.id.gl5:
                startActivity(new Intent(this, GlfiveActivity.class));
                break;
            default:
                break;
        }
    }
}
