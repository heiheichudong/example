package com.gess.example.diyview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SimpleScaleView extends View {
    public SimpleScaleView(Context context) {
        this(context,null);
    }

    public SimpleScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SimpleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    protected void init(){

    }
}
