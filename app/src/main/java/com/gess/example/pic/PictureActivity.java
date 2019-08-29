package com.gess.example.pic;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;

public class PictureActivity extends AppCompatActivity {

    private UCropView mUCropView;
    private GestureCropImageView mGestureCropImageView;
    private OverlayView mOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        mUCropView = findViewById(R.id.ucropview);
        mGestureCropImageView = mUCropView.getCropImageView();
        mOverlayView = mUCropView.getOverlayView();

        setGesture();
        setConfig();
    }

    private void setGesture() {
        try{
            String path = Environment.getExternalStorageDirectory().getPath() + "/Huawei/MagazineUnlock/aaa.jpg";
            LogUtils.d("path = " + path);
            Uri uri = Uri.parse("file://" + path);
            mGestureCropImageView.setImageUri(uri,uri);
            mGestureCropImageView.setRotateEnabled(true);//是否可以旋转(默认为true)
            mGestureCropImageView.setScaleEnabled(true);//是否可以缩放(默认为true)
            mGestureCropImageView.setDoubleTapScaleSteps(5);//双击放大
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setConfig() {
        mOverlayView.setCircleDimmedLayer(false);//圆形头像(默认false)
        mOverlayView.setCropFrameColor(Color.RED);//边框颜色
        mOverlayView.setCropFrameStrokeWidth(10);//边框宽度
        mOverlayView.setCropGridColor(Color.BLUE);//内边框颜色
        mOverlayView.setCropGridColumnCount(1);//内边框条数
        mOverlayView.setCropGridRowCount(1);//内边框条数
        mOverlayView.setCropGridStrokeWidth(10);//内边框宽度
//        mOverlayView.setDimmedColor(Color.GREEN);//边框外颜色
        mOverlayView.setDragFrame(true);//裁剪线可否拖动
        mOverlayView.setFreestyleCropEnabled(true);//自由裁剪
//        mOverlayView.setOverlayViewChangeListener(new OverlayViewChangeListener() {
//            @Override
//            public void onCropRectUpdated(RectF cropRect) {
//
//            }
//        });
        mOverlayView.setShowCropFrame(true);//是否展示边框
        mOverlayView.setShowCropGrid(true);//是否展示内边框
        mOverlayView.setTargetAspectRatio(1);
        mOverlayView.setupCropBounds();
    }
}
