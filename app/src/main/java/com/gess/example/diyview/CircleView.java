package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.Nullable;

import com.blankj.utilcode.util.SizeUtils;

public class CircleView extends View {

    private Paint mPaint;


    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(SizeUtils.dp2px(5));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(SizeUtils.dp2px(80), SizeUtils.dp2px(80));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        drawRect(canvas);
//        drawCircle(canvas);
        drawPath(canvas);
    }


    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(SizeUtils.dp2px(40), SizeUtils.dp2px(40), SizeUtils.dp2px(20), mPaint);
    }

    private void drawRect(Canvas canvas) {
        RectF rect = new RectF(0, 0,
                SizeUtils.dp2px(80),
                SizeUtils.dp2px(80));
        canvas.drawRoundRect(rect, 20, 20, mPaint);
//        canvas.drawRect(rect,mPaint);
    }

    private void drawPath(Canvas canvas) {
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(40), SizeUtils.dp2px(40), SizeUtils.dp2px(20), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);
    }


}
