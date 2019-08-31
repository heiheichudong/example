package com.gess.example.opengl.utils;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.opengl.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class BufferUtil {


    public static FloatBuffer getBuffer(float[] a) {
        FloatBuffer floatBuffer;
        //先初始化buffer,数组的长度*4,因为一个float占4个字节
        ByteBuffer mbb = ByteBuffer.allocateDirect(a.length * 4);
        //数组排列用nativeOrder
        mbb.order(ByteOrder.nativeOrder());
        floatBuffer = mbb.asFloatBuffer();
        floatBuffer.put(a);
        floatBuffer.position(0);
        return floatBuffer;
    }

    public static IntBuffer getBuffer(int[] arr) {
        IntBuffer mBuffer;
        //先初始化buffer,数组的长度*4,因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        //数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());

        mBuffer = qbb.asIntBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }

    public static ByteBuffer getBuffer(byte[] arr) {
        //先初始化buffer,数组的长度*4,因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        //数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());

        qbb.put(arr);
        qbb.position(0);
        return qbb;
    }

    private float[] vertices = new float[]{
            0.f, -0.525731f, 0.850651f,
            0.850651f, 0.f, 0.525731f,
            0.850651f, 0.f, -0.525731f,
            -0.850651f, 0.f, -0.525731f,
            -0.850651f, 0.f, 0.525731f,
            -0.525731f, 0.850651f, 0.f,
            0.525731f, 0.850651f, 0.f,
            0.525731f, -0.850651f, 0.f,
            -0.525731f, -0.850651f, 0.f,
            0.f, -0.525731f, -0.850651f,
            0.f, 0.525731f, -0.850651f,
            0.f, 0.525731f, 0.850651f
    };

    public static float[] getVertices(int w, int h) {
        LogUtils.d(Data.TAG,"w = " + w + "h = " + h);
        float wf = 1f, hf = 1f;
        if (w > h) {
            wf = (float) h / (float) w;
        } else if (h > w) {
            hf = (float) w / (float) h;
        }
        LogUtils.d(Data.TAG,"wf = " + wf + "hf = " + hf);
        float[] vs = new float[]{
                0, -hf,
                wf, -hf,
                0, 0,
                wf, 0
        };
        return vs;
    }
}
