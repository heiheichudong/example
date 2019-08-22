package com.gess.example.opengl.gl1;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GlOneRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        // 角度校正提示
        gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
        //清理屏幕颜色
        gl10.glClearColor(0,0,0,1);
        //启用深度缓存
        gl10.glEnable(GL10.GL_DEPTH_TEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        float r = (float) i / i1;
        //设置窗口（opengl 场景大小）
        gl10.glViewport(0,0,i,i1);
        //设置投影矩阵为透视矩阵
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵（置为单位矩阵）
        gl10.glLoadIdentity();
        //创建一个透视投影矩阵（设置视觉大小）
        gl10.glFrustumf(-r,r,-1,1,1,10);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        // 清理屏幕
        gl10.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        //设置视图模型矩阵
        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        //重置矩阵
        gl10.glLoadIdentity();
        //视点变化
        GLU.gluLookAt(gl10,0,0,3,0,0,0,0,1,0);

    }
}
