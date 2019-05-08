package com.gess.example.utils;

import android.graphics.Matrix;
import android.util.Log;

import com.gess.example.widget.TextureVideoView;
import com.tencent.ijk.media.player.IMediaPlayer;

public class TextureUtil {

    public static void setTextureViewSize(TextureVideoView textureVideoView, IMediaPlayer mp) {
        Log.e("MainVideoActivity", textureVideoView.getWidth() + "==" + textureVideoView.getHeight());
        float sx = 1;
        Matrix txform = new Matrix();
        textureVideoView.getTransform(txform);
        float ratio = ((float) mp.getVideoWidth()) / ((float) textureVideoView.getWidth());
        float h = (mp.getVideoHeight() / ratio);
        if (textureVideoView.getHeight() - h > 10) {
            sx = textureVideoView.getHeight() / ((float) h);
        }
        float aspectRatio;
        if (textureVideoView.getHeight() < 10) {
            aspectRatio = h / ((float) textureVideoView.getLayoutParams().height);
        } else {
            aspectRatio = h / ((float) textureVideoView.getHeight());
        }
        txform.setScale(sx, (float) aspectRatio * sx);
        textureVideoView.setTag(aspectRatio);
        textureVideoView.setTransform(txform);
    }
}
