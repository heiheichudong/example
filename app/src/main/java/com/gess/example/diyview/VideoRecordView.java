package com.gess.example.diyview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.Nullable;

import com.blankj.utilcode.util.SizeUtils;

public class VideoRecordView extends View  {

    private int radius = 40;
    private int pathWidth = 8;
    private int viewRadius = (radius + pathWidth);
    private Paint mPaint;
    private boolean isStart = false;

    private int status = 0;
    public final static int START_ACTION = 1;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case START_ACTION:
                    status = START_ACTION;
                    invalidate();
                    break;
            }
        }
    };

    public Handler getHandler() {
        return mHandler;
    }

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
        switch (status){
            case 0:
                drawPath(canvas);
                drawCircle(canvas);
                break;
            case START_ACTION:
                startAction(canvas);
                break;
        }
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

    private void startAction(final Canvas canvas) {
        ValueAnimator animator = ValueAnimator.ofInt(0,10);
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int f = ((int) animation.getAnimatedValue());
                if (f % 2 == 0){
                    pathWidth += 1;
                    action(canvas);
                }
            }
        });
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                isStart = false;
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isStart = true;
            }
        });

    }

    private void action(Canvas canvas){
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(pathWidth * 2);
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        RectF rect = new RectF(SizeUtils.dp2px(33), SizeUtils.dp2px(33),
                SizeUtils.dp2px(63),
                SizeUtils.dp2px(63));
        canvas.drawRoundRect(rect, 20, 20, mPaint);
    }
}
