package com.gess.example.diyview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;

import java.util.ArrayList;
import java.util.List;

public class SimpleScaleView extends View {

    public final String TAG = this.getClass().getSimpleName();
    /**
     * 画笔
     */
    private Paint mPaint;
    private int mViewHeight;
    private int mViewWidth;
    private int interval = SizeUtils.dp2px(8);
    private int lineWidth = SizeUtils.dp2px(2);
    private int scaleStopHeight = SizeUtils.dp2px(112);
    private int scaleStartHeight = SizeUtils.dp2px(48);
    private List<Double> doubles;
    private float gapStart = SizeUtils.dp2px(50);
    private float gapEnd = SizeUtils.dp2px(80);
    private boolean isGapStart = false;
    private boolean isGapEnd = false;
    private float moveX;

    public SimpleScaleView(Context context) {
        this(context, null);
    }

    public SimpleScaleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SimpleScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mViewHeight = SizeUtils.dp2px(120);
        mViewWidth = ScreenUtils.getScreenWidth();
        setMeasuredDimension(((ViewGroup) getParent()).getLayoutParams().width, mViewHeight);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(lineWidth);

        doubles = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            doubles.add(Math.random());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(lineWidth);
        drawTime(canvas);
        drawScale(canvas);
        drawGap(canvas);
    }

    private void drawTime(Canvas canvas) {
        mPaint.setTextSize(SizeUtils.dp2px(16));
        canvas.drawText("00:00", interval, SizeUtils.dp2px(24), mPaint);
        Rect rect = new Rect();
        mPaint.getTextBounds("00:80", 0, "00:80".length(), rect);
        canvas.drawText("00:80", mViewWidth - rect.width() - interval, SizeUtils.dp2px(24), mPaint);
    }

    private void drawGap(Canvas canvas) {
        mPaint.setStrokeWidth(lineWidth * 3);
        mPaint.setColor(Color.RED);
        canvas.drawLine(gapStart, SizeUtils.dp2px(32), gapStart, SizeUtils.dp2px(128), mPaint);
        canvas.drawLine(gapEnd, SizeUtils.dp2px(32), gapEnd, SizeUtils.dp2px(128), mPaint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moveX = event.getX();
                if (event.getX() > gapStart && event.getX() < gapStart + lineWidth * 3) {
                    isGapStart = true;
                }
                if (event.getX() > gapEnd && event.getX() < gapEnd + lineWidth * 3){
                    isGapEnd = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isGapStart) {
                    if (moveX < event.getX()){
                        if (gapStart + lineWidth * 8 < gapEnd){
                            gapStart = event.getX();
                            drawMove();
                        }
                    }else {
                        gapStart = event.getX();
                        drawMove();
                    }
                    moveX = event.getX();
                }
                if (isGapEnd){
                    if (moveX > event.getX()) {
                        if (gapEnd - lineWidth * 8 > gapStart) {
                            gapEnd = event.getX();
                            drawMove();
                        }
                    }else {
                        gapEnd = event.getX();
                        drawMove();
                    }
                }
                break;
            default:
                isGapStart = false;
                isGapEnd = false;
                break;
        }
        return true;

    }

    private void drawMove() {
        invalidate();
    }

    private void drawScale(Canvas canvas) {
        int remainder = (mViewWidth - interval * 2) % SizeUtils.dp2px(10);
        int startX = (interval * 2 + remainder) / 2;
        int number = (mViewWidth - (interval * 2 + remainder)) / SizeUtils.dp2px(10);
        canvas.drawLine(startX, scaleStartHeight, startX, scaleStopHeight, mPaint);
        for (int i = 0; i < number - 1; i++) {
            startX += SizeUtils.dp2px(10);
            if (doubles.get(i) > 0.4d) {
                canvas.drawLine(startX, SizeUtils.dp2px(60), startX, SizeUtils.dp2px(100), mPaint);
            } else {
                canvas.drawLine(startX, scaleStartHeight, startX, scaleStopHeight, mPaint);
            }
        }
        startX += SizeUtils.dp2px(10);
        canvas.drawLine(startX, scaleStartHeight, startX, scaleStopHeight, mPaint);
    }
}
