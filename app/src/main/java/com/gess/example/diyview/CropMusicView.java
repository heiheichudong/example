package com.gess.example.diyview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class CropMusicView extends ViewGroup {

    public CropMusicView(Context context) {
        super(context);
        init();
    }

    public CropMusicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CropMusicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CropMusicView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
