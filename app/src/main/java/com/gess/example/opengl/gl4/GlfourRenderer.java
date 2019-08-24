package com.gess.example.opengl.gl4;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.gess.example.opengl.Data;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GlfourRenderer implements GLSurfaceView.Renderer {
    private Data data;
    float rot = 1.0f;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        data = new Data();
        // 角度校正提示
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        //清理屏幕颜色
        gl.glClearColor(0, 0, 0, 1);
        //启用深度缓存
        gl.glEnable(GL10.GL_DEPTH_TEST);

        setupLight(gl);

        setupMaterial(gl);
    }

    private void setupMaterial(GL10 gl) {
        //开启颜色材质
        gl.glEnable(GL10.GL_COLOR_MATERIAL);
    }


    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        float r = (float) width / height;
        //设置窗口（opengl 场景大小）
        gl.glViewport(0, 0, width, height);
        //设置投影矩阵为透视矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵（置为单位矩阵）
        gl.glLoadIdentity();
        //创建一个透视投影矩阵（设置视觉大小）
        gl.glFrustumf(-r, r, -1, 1, 1.0f, 1000f);
        //视觉效果 上边是透视效果下边是平视效果
//        gl.glOrthof(-r, r, -1, 1, 1, 1000);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // 清理屏幕
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        //设置视图模型矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        //重置矩阵
        gl.glLoadIdentity();
        //视点变化
        GLU.gluLookAt(gl, 0, 0, 3, 0, 0, 0, 0, 1, 0);

        //设置模型位置 （平移）
//        gl.glTranslatef(0, 0, 0);
        //设置旋转(y轴)
        gl.glRotatef(rot, 1, 1, 0);
        //允许设置顶点数组
        // （状态开关） 这里指开启
        // GL10.GL_VERTEX_ARRAY ->顶点
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //允许设置颜色数组
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //允许设置法线数组
        gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
        //设置顶点数据 参数一（定义几维）参数二：数据类型这里是float
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, data.vertices);
        //设置颜色数组
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, data.colors);
        //设置法线数组
        gl.glNormalPointer(GL10.GL_FLOAT, 0, data.colors);
        //放大
//        gl.glScalef(2, 2, 2);
        //绘制三角形 20个 60个顶点
        gl.glDrawElements(GL10.GL_TRIANGLES, 60, GL10.GL_UNSIGNED_BYTE, data.indexes);
        //阴影模式 GL10.GL_FLAT 不平滑 GL10.GL_SMOOTH 平滑过渡
//        gl.glShadeModel(GL10.GL_FLAT);

        //关闭颜色数组设置
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        //取消顶点设置 （状态开关） 这里指指关闭
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        //取消法线数组顶点
        gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);

        rot += 0.5f;
    }

    private void setupLight(GL10 gl) {
        //打开光源
        gl.glEnable(GL10.GL_LIGHTING);
        //开启光源
        gl.glEnable(GL10.GL_LIGHT0);
        //设置环境光 参数一：几号光源  参数二：GL10.GL_AMBIENT 环境光 参数三：光颜色
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, data.ambientBuffer);
        //设置散射光 参数二：GL10.GL_DIFFUSE
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, data.diffuseBuffer);
        //设置高光 参数二：GL10.GL_SPECULAR
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, data.specularBuffer);
        //光源位置
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, data.positionBuffer);
        //设置光照方向
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPOT_DIRECTION, data.directionBuffer);
        //设置光照角度
        gl.glLightf(GL10.GL_LIGHT0, GL10.GL_SPOT_CUTOFF, 45.0f);

    }
}
