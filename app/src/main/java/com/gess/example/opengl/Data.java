package com.gess.example.opengl;

import com.gess.example.opengl.utils.BufferUtil;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Data {
    private float[] verticesf = new float[]{
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

    public FloatBuffer vertices = BufferUtil.getBuffer(verticesf);

    private float[] colorsf = new float[]{
            1.0f, 0.0f, 0.0f, 1.0f,
            1.0f, 0.5f, 0.0f, 1.0f,
            1.0f, 1.0f, 0.0f, 1.0f,
            0.5f, 1.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.5f, 1.0f,
            0.0f, 1.0f, 1.0f, 1.0f,
            0.0f, 0.5f, 1.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f,
            0.5f, 0.0f, 1.0f, 1.0f,
            1.0f, 0.0f, 1.0f, 1.0f,
            1.0f, 0.0f, 0.5f, 1.0f
    };

    public FloatBuffer colors = BufferUtil.getBuffer(colorsf);

    private byte[] bytes = new byte[]{
            1, 2, 6,
            1, 7, 2,
            3, 4, 5,
            4, 3, 8,
            6, 5, 11,
            5, 6, 10,
            9, 10, 2,
            10, 9, 3,
            7, 8, 9,
            8, 7, 0,
            11, 0, 1,
            0, 11, 4,
            6, 2, 10,
            1, 6, 11,
            3, 5, 10,
            5, 4, 11,
            2, 7, 9,
            7, 1, 0,
            3, 9, 8,
            4, 8, 0,
    };

    public ByteBuffer indexes = BufferUtil.getBuffer(bytes);

    float[] normals = new float[]{
            0.000000f, -0.417775f, 0.675974f,
            0.675973f, 0.000000f, 0.417775f,
            0.675973f, -0.000000f, -0.417775f,
            -0.675973f, 0.000000f, -0.417775f,
            -0.675973f, -0.000000f, 0.417775f,
            -0.417775f, 0.675974f, 0.000000f,
            0.417775f, 0.675973f, -0.000000f,
            0.417775f, -0.675974f, 0.000000f,
            -0.417775f, -0.675974f, 0.000000f,
            0.000000f, -0.417775f, -0.675973f,
            0.000000f, 0.417775f, -0.675974f,
            0.000000f, 0.417775f, 0.675973f
    };

    public FloatBuffer normalBuffer = BufferUtil.getBuffer(normals);

    float[] lightAmbient = new float[]{//AMBIENT
            1.0f, 1.0f, 1.0f, 1.0f
    };

    public FloatBuffer ambientLightBuffer = BufferUtil.getBuffer(lightAmbient);

    float[] lightDiffuse = new float[]{
            0.7f, 0.7f, 0.7f, 1.0f
    };

    public FloatBuffer diffuseLightBuffer = BufferUtil.getBuffer(lightDiffuse);

    float[] lightSpecular = new float[]{//SPECULAR
            0.7f, 0.7f, 0.7f, 1.0f
    };

    public FloatBuffer specularLightBuffer = BufferUtil.getBuffer(lightSpecular);

    float[] lightPosition = new float[]{//SPECULAR
            0.0f, 10.0f, 10.0f, 0.0f
    };

    public FloatBuffer positionBuffer = BufferUtil.getBuffer(lightPosition);

    float[] lightDirection = new float[]{//方向
            0.0f, 0.0f, -1.0f
    };

    public FloatBuffer directionBuffer = BufferUtil.getBuffer(lightDirection);

    float[] ambientAndDiffuse = new float[]{0.0f, 0.1f, 0.9f, 1.0f};

    public FloatBuffer ambientAndDiffuseBuffer = BufferUtil.getBuffer(ambientAndDiffuse);


    float[] ambient = {0.0f, 0.1f, 0.9f, 1.0f};
    public FloatBuffer ambientBuffer = BufferUtil.getBuffer(ambient);
    float[] diffuse = new float[]{0.9f, 0.0f, 0.1f, 1.0f};
    public FloatBuffer diffuseBuffer = BufferUtil.getBuffer(diffuse);
    float[] specular = new float[]{0.9f, 0.9f, 0.1f, 1.0f};
    public FloatBuffer specularBuffer = BufferUtil.getBuffer(specular);
    float[] emission = new float[]{0.0f, 0.4f, 0.1f, 1.0f};//EMISSION
    public FloatBuffer emissionBuffer = BufferUtil.getBuffer(emission);

    int[] textrue = new int[1];
    public IntBuffer textrueBuffer = BufferUtil.getBuffer(textrue);

    float[] texCoordsSquare = new float[]{
            0.0f, 1.0f,
            1.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 0.0f
    };
    public FloatBuffer texCoordsBuffer = BufferUtil.getBuffer(texCoordsSquare);
    float[] texCoordsSquareVertices = new float[]{
            -1.0f, 1.0f, -0.0f,
            1.0f, 1.0f, -0.0f,
            -1.0f, -1.0f, -0.0f,
            1.0f, -1.0f, -0.0f
    };
    public FloatBuffer texCoordsSquareVerticesBuffer = BufferUtil.getBuffer(texCoordsSquareVertices);

    float[] texCoordsSquareNormals = new float[]{
            -1.0f, 1.0f, -0.0f,
            1.0f, 1.0f, -0.0f,
            -1.0f, -1.0f, -0.0f,
            1.0f, -1.0f, -0.0f
    };
    public FloatBuffer texCoordsSquareNormalsBuffer = BufferUtil.getBuffer(texCoordsSquareNormals);


}
