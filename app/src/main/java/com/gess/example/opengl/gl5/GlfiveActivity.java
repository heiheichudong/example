package com.gess.example.opengl.gl5;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.gess.example.R;
import com.gess.example.opengl.gl3.GlthreeRenderer;

public class GlfiveActivity extends AppCompatActivity {


    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new GlfiveRenderer(this));
        setContentView(glSurfaceView);
//        setContentView(R.layout.activity_glfive);
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }
}
