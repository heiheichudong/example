package com.gess.example.opengl.gl1;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.gess.note.BaseActivity;

public class GlOneActivity extends BaseActivity {


    private GLSurfaceView glSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gl_one);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new GlOneRenderer());
        setContentView(glSurfaceView);
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
