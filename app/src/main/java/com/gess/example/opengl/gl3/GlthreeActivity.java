package com.gess.example.opengl.gl3;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import com.gess.note.BaseActivity;

public class GlthreeActivity extends BaseActivity {

    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setRenderer(new GlthreeRenderer());
        setContentView(glSurfaceView);
//        setContentView(R.layout.activity_glthree);
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
