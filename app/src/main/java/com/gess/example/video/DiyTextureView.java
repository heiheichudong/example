package com.gess.example.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

import com.blankj.utilcode.util.LogUtils;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IjkMediaPlayer;

public class DiyTextureView extends TextureView implements TextureView.SurfaceTextureListener{

    public static String TAG = "DiyTextureView";
    private Surface data;
    private IjkMediaPlayer mMediaPlayer;
//    private AudioManager mAudioManager;

    private int mVideoWidth;
    private int mVideoHeight;

    public DiyTextureView(Context context) {
        this(context,null);
    }

    public DiyTextureView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DiyTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSurfaceTextureListener(this);

        mVideoWidth = 0;
        mVideoHeight = 0;

//        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
//        mAudioManager.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

    }


    public void setPath(String path){
        if (!TextUtils.isEmpty(path)){
            Uri uri = Uri.parse(path);
            setPath(uri);
        }
    }

    public void setPath(Uri path){
        try {
            if (mMediaPlayer == null){
                mMediaPlayer = new IjkMediaPlayer();
            }
            LogUtils.d(TAG,"prepareAsync");
            mMediaPlayer.setDataSource(getContext(),path);
            mMediaPlayer.prepareAsync();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        initPlayer(surface);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        if (mMediaPlayer != null){
            mMediaPlayer.pause();
            mMediaPlayer.stop();
            mMediaPlayer.reset();

        }
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    private void initPlayer(SurfaceTexture surface) {
        if (mMediaPlayer == null){
            mMediaPlayer = new IjkMediaPlayer();
        }

        mMediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                LogUtils.d(TAG,"setOnPreparedListener");
//                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mMediaPlayer.setVolume(1f,1f);
                mMediaPlayer.start();
            }
        });

        mMediaPlayer.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() {
            @Override
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {
                mVideoHeight = mMediaPlayer.getVideoHeight();
                mVideoWidth = mMediaPlayer.getVideoWidth();
                LogUtils.d(TAG,"mVideoHeight = " + mVideoHeight );
                LogUtils.d(TAG,"mVideoWidth = " + mVideoWidth);
//                updateTextureViewSizeCenterCrop();
            }
        });

        data = new Surface(surface);
        mMediaPlayer.setSurface(data);
    }

    public void start(){
        if (mMediaPlayer != null){
            LogUtils.d(TAG,"start");
            mMediaPlayer.start();
        }
    }

    public void pause(){
        if (mMediaPlayer != null){
            LogUtils.d(TAG,"pause");
            mMediaPlayer.pause();
        }
    }

    //重新计算video的显示位置，裁剪后全屏显示
    private void updateTextureViewSizeCenterCrop(){

        float sx = (float) getWidth() / (float) mVideoWidth;
        float sy = (float) getHeight() / (float) mVideoHeight;

        Matrix matrix = new Matrix();
        float maxScale = Math.max(sx, sy);

        //第1步:把视频区移动到View区,使两者中心点重合.
        matrix.preTranslate((getWidth() - mVideoWidth) / 2, (getHeight() - mVideoHeight) / 2);

        //第2步:因为默认视频是fitXY的形式显示的,所以首先要缩放还原回来.
        matrix.preScale(mVideoWidth / (float) getWidth(), mVideoHeight / (float) getHeight());

        //第3步,等比例放大或缩小,直到视频区的一边超过View一边, 另一边与View的另一边相等. 因为超过的部分超出了View的范围,所以是不会显示的,相当于裁剪了.
        matrix.postScale(maxScale, maxScale, getWidth() / 2, getHeight() / 2);//后两个参数坐标是以整个View的坐标系以参考的

        setTransform(matrix);
        postInvalidate();
    }

	//重新计算video的显示位置，让其全部显示并据中
    private void updateTextureViewSizeCenter(){

        float sx = (float) getWidth() / (float) mVideoWidth;
        float sy = (float) getHeight() / (float) mVideoHeight;

        Matrix matrix = new Matrix();

        //第1步:把视频区移动到View区,使两者中心点重合.
        matrix.preTranslate((getWidth() - mVideoWidth) / 2, (getHeight() - mVideoHeight) / 2);

        //第2步:因为默认视频是fitXY的形式显示的,所以首先要缩放还原回来.
        matrix.preScale(mVideoWidth / (float) getWidth(), mVideoHeight / (float) getHeight());

        //第3步,等比例放大或缩小,直到视频区的一边和View一边相等.如果另一边和view的一边不相等，则留下空隙
        if (sx >= sy){
            matrix.postScale(sy, sy, getWidth() / 2, getHeight() / 2);
        }else{
            matrix.postScale(sx, sx, getWidth() / 2, getHeight() / 2);
        }

        setTransform(matrix);
        postInvalidate();
    }

}
