package com.gess.example.opengl.gl2;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.gess.example.opengl.utils.BufferUtil;

import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GltwoRenderer implements GLSurfaceView.Renderer {

    float one = 1;

    //用于控制三角形，正方形旋转的角度
    float rtri, rQuad;


    private float[] triangleFloat = new float[]{
            0, one, 0,
            -one, -one, 0,
            one, -one, 0
    };

    FloatBuffer triangleBuffer = BufferUtil.getBuffer(triangleFloat);


    private float[] squareFloat = new float[]{
            one, one, 0,
            -one, one, 0,
            one, -one, 0,
            -one, -one, 0
    };

    FloatBuffer squareBuffer = BufferUtil.getBuffer(squareFloat);

    private float[] colorFloat = new float[]{
            one, 0, 0, 1,
            0, one, 0, 1,
            0, 0, one, 1
    };

    FloatBuffer colorBuffer = BufferUtil.getBuffer(colorFloat);

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        // 角度校正提示
        gl10.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        //清理屏幕颜色
        gl10.glClearColor(0, 0, 0, 1);
        //启用深度缓存
        gl10.glEnable(GL10.GL_DEPTH_TEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int i, int i1) {
        float r = (float) i / i1;
        //设置窗口（opengl 场景大小）
        gl10.glViewport(0, 0, i, i1);
        //设置投影矩阵为透视矩阵
        gl10.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵（置为单位矩阵）
        gl10.glLoadIdentity();
        //创建一个透视投影矩阵（设置视觉大小）
        gl10.glFrustumf(-r, r, -1, 1, 1, 10);
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
        GLU.gluLookAt(gl10, 0, 0, 3, 0, 0, 0, 0, 1, 0);


        //设置模型位置 （平移）
        gl10.glTranslatef(-3, 0, -4);
        //设置旋转(y轴)
        gl10.glRotatef(rtri,0,1,0);
        //允许设置顶点
        // （状态开关） 这里指开启
        // GL10.GL_VERTEX_ARRAY ->顶点
        gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //允许设置颜色数组
        gl10.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //设置颜色数组
        gl10.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
        //设置顶点数据 参数一（定义几维）参数二：数据类型这里是float
        gl10.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleBuffer);
        //放大三角形
        gl10.glScalef(2,2,2);
        //绘制三角形 GL10.GL_TRIANGLES（不重复取值取三值）GL_TRIANGLE_FAN（都与第一值组三角）
        //参数二 从第几个取值
        gl10.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
        //关闭颜色数组设置
        gl10.glDisableClientState(GL10.GL_COLOR_ARRAY);


        //设置正方形颜色
        gl10.glColor4f(0.5f, 0.5f, 1.0f, 1.0f);
        //重置当前的模型观察矩阵
        gl10.glLoadIdentity();
        //设置模型位置
        gl10.glTranslatef(1, 0, -4);
        //设置旋转（x轴）
        gl10.glRotatef(rQuad,1,0,0);
        //设置正方形顶点
        gl10.glVertexPointer(3, GL10.GL_FLOAT, 0, squareBuffer);
        //绘制正方形 GL10.GL_TRIANGLE_STRIP(重复两值取三值)
        gl10.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        //绘制出来则是线框
        //GL10.GL_LINES 绘制线
//        gl10.glDrawArrays(GL10.GL_LINES,0,4);
        //取消顶点设置 （状态开关） 这里指指关闭
        gl10.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        rtri += 0.5f;
        rQuad -= 0.5f;
    }
}
