package com.gess.note.utils;

import android.graphics.Matrix;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.TextureView;


public class TextureUtil {

    public static void setTextureViewSize(TextureView textureVideoView, MediaPlayer mp) {
        Log.d("MainVideoActivity", textureVideoView.getWidth() + "==" + textureVideoView.getHeight());
        float sx = (float) textureVideoView.getWidth() / (float) mp.getVideoWidth();
        float sy = (float) textureVideoView.getHeight() / (float) mp.getVideoHeight();

        Matrix matrix = new Matrix();
        float maxScale = Math.max(sx, sy);

        //第1步:把视频区移动到View区,使两者中心点重合.
        matrix.preTranslate((textureVideoView.getWidth() - mp.getVideoWidth()) / 2, (textureVideoView.getHeight() - mp.getVideoHeight()) / 2);

        //第2步:因为默认视频是fitXY的形式显示的,所以首先要缩放还原回来.
        matrix.preScale(mp.getVideoWidth() / (float) textureVideoView.getWidth(), mp.getVideoHeight() / (float) textureVideoView.getHeight());

        //第3步,等比例放大或缩小,直到视频区的一边超过View一边, 另一边与View的另一边相等. 因为超过的部分超出了View的范围,所以是不会显示的,相当于裁剪了.
        matrix.postScale(maxScale, maxScale, textureVideoView.getWidth() / 2, textureVideoView.getHeight() / 2);//后两个参数坐标是以整个View的坐标系以参考的

        textureVideoView.setTransform(matrix);
        textureVideoView.postInvalidate();
    }
}
