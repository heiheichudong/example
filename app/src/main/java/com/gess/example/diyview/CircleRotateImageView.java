package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class CircleRotateImageView extends AppCompatImageView {
    public CircleRotateImageView(Context context) {
        super(context);
    }

    public CircleRotateImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleRotateImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }



}
