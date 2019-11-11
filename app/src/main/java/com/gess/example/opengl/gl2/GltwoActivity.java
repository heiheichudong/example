package com.gess.example.opengl.gl2;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.gess.note.BaseActivity;

public class GltwoActivity extends BaseActivity {

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new GltwoRenderer());
        setContentView(glSurfaceView);
//        setContentView(R.layout.activity_gltwo);
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
