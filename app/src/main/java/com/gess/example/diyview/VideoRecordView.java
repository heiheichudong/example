package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.gess.note.utils.SizeUtils;

import androidx.annotation.Nullable;

public class VideoRecordView extends View  {

    private int radius = 40;
    private int pathWidth = 8;
    private int viewRadius = (radius + pathWidth);
    private Paint mPaint;
    private boolean isStart = false;

    public VideoRecordView(Context context) {
        this(context, null);
    }

    public VideoRecordView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoRecordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(SizeUtils.dp2px(pathWidth));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(SizeUtils.dp2px(viewRadius * 2), SizeUtils.dp2px(viewRadius * 2));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPath(canvas);
        drawCircle(canvas);
    }

    private void drawPath(Canvas canvas) {
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);
    }

    private void drawCircle(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius - pathWidth), mPaint);
    }

    public void startAction(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);
    }
}
