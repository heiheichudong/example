package com.gess.example.opengl.gl4;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.gess.note.BaseActivity;

public class GlfourActivity extends BaseActivity {

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new GlfourRenderer());
        setContentView(glSurfaceView);
//        setContentView(R.layout.activity_glfour);
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
