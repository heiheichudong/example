package com.gess.example.opengl.gl5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.GLUtils;

import com.gess.example.R;
import com.gess.example.opengl.Data;
import com.gess.example.opengl.utils.BufferUtil;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GlfiveRenderer implements GLSurfaceView.Renderer {

    Data data;

    float rot = 1.0f;

    private Bitmap mBitmapTexture;
    int[] mTexture;

    public GlfiveRenderer(Context context) {
        this.mBitmapTexture = BitmapFactory.decodeResource(context.getResources(), R.drawable.graph);
        this.mTexture = new int[1];
    }

    public GlfiveRenderer(Bitmap bitmap) {
        this.mBitmapTexture = bitmap;
        this.mTexture = new int[1];
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        data = new Data();
        // 角度校正提示
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        //清理屏幕颜色
        gl.glClearColor(0, 0, 0, 1);
        //启用深度缓存
        gl.glEnable(GL10.GL_DEPTH_TEST);

        setupTextrue(gl);
    }

    private void setupTextrue(GL10 gl) {
        //打开2D贴图
        gl.glEnable(GL10.GL_TEXTURE_2D);
        //打开混色功能
        gl.glEnable(GL10.GL_BLEND);
        //指定混色方法
        gl.glBlendFunc(GL10.GL_ONE, GL10.GL_SRC_COLOR);
        //创建纹理
        gl.glGenTextures(1, data.textrueBuffer);
        mTexture[0] = data.textrueBuffer.get();
        //绑定纹理
        gl.glBindTexture(GL10.GL_TEXTURE_2D, mTexture[0]);
        //
        gl.glTexParameterx(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
        gl.glTexParameterx(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
        //平铺
//        gl.glTexParameterx(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
//        gl.glTexParameterx(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);
        //限制拉伸
//        gl.glTexParameterx(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,GL10.GL_CLAMP_TO_EDGE);
//        gl.glTexParameterx(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,GL10.GL_CLAMP_TO_EDGE);
        //生成纹理
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, mBitmapTexture, 0);
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
        //绘制三角形
//        drawTriangle(gl);
        drawSquare(gl);
    }

    private void drawSquare(GL10 gl) {
        //设置模型位置 （平移）
//        gl.glTranslatef(0, 0, 0);
        //设置旋转(y轴)
        gl.glRotatef(rot, 1, 1, 1);
        //放大
//        gl.glScalef(2, 2, 2);
        //允许设置顶点
        // （状态开关） 这里指开启
        // GL10.GL_VERTEX_ARRAY ->顶点
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //允许设置法线数组
        gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
        //允许设置纹理坐标数组
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        //绑定纹理
        gl.glBindTexture(GL10.GL_TEXTURE_2D, mTexture[0]);
        //设置顶点数组
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, data.texCoordsSquareVerticesBuffer);
        //设置法线数组
        gl.glNormalPointer(GL10.GL_FLOAT, 0, data.texCoordsSquareNormalsBuffer);
        //绘制正方形
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);
        //设置纹理坐标数组
//        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, data.texCoordsBuffer);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, BufferUtil.getBuffer(BufferUtil.getVertices(mBitmapTexture.getWidth(), mBitmapTexture.getHeight())));
        //关闭纹理坐标数组
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        //关闭法线数组设置
        gl.glDisableClientState(GL10.GL_NORMAL_ARRAY);
        //取消顶点设置 （状态开关） 这里指指关闭
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

//        rot += 0.5f;
    }

    private void drawTriangle(GL10 gl) {
        //设置模型位置 （平移）
//        gl.glTranslatef(0, 0, 0);
        //设置旋转(y轴)
//        gl.glRotatef(rot, 1, 1, 0);
        //允许设置顶点
        // （状态开关） 这里指开启
        // GL10.GL_VERTEX_ARRAY ->顶点
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //允许设置颜色数组
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //设置颜色数组
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, data.colors);
        //设置顶点数据 参数一（定义几维）参数二：数据类型这里是float
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, data.vertices);
        //放大
//        gl.glScalef(2, 2, 2);
        //绘制三角形 20个 60个顶点
        gl.glDrawElements(GL10.GL_TRIANGLES, 60, GL10.GL_UNSIGNED_BYTE, data.indexes);

//        for (int i = 0; i < 10; i++) {
//            gl.glLoadIdentity();
//            gl.glTranslatef(0f, -2.0f, -5f * (float) i);
//            gl.glRotatef(rot, 1, 1, 0);
//            gl.glDrawElements(GL10.GL_TRIANGLES, 60, GL10.GL_UNSIGNED_BYTE, data.indexes);
//        }

        //关闭颜色数组设置
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        //取消顶点设置 （状态开关） 这里指指关闭
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

        rot += 0.5f;
    }
}
