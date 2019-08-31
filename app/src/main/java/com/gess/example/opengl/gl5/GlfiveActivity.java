package com.gess.example.opengl.gl5;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GlfiveActivity extends AppCompatActivity {


    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
//        glSurfaceView.setRenderer(new GlfiveRenderer(this));
//        glSurfaceView.setRenderer(new GlfiveRenderer(resource));
        setContentView(glSurfaceView);
//        setContentView(R.layout.activity_glfive);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (glSurfaceView != null){
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (glSurfaceView != null){
            glSurfaceView.onPause();
        }
    }
}
