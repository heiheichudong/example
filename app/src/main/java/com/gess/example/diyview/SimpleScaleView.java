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
    /**
     * 最大刻度
     */
    private int maxScale = 48;
    /**
     * 总长
     */
    private int overall;
    /**
     * view的宽高
     */
    private int mViewHeight, mViewWidth;
    /**
     * 间隔
     */
    private int interval = SizeUtils.dp2px(8);
    /**
     * 线宽
     */
    private int lineWidth = SizeUtils.dp2px(2);
    /**
     * 刻度结束高度
     */
    private int scaleStopHeight = SizeUtils.dp2px(108);
    /**
     * 刻度开始高度
     */
    private int scaleStartHeight = SizeUtils.dp2px(56);
    /**
     * 随机点
     */
    private List<Double> doubles;
    /**
     * 段头
     */
    private float gapStart = SizeUtils.dp2px(50);
    /**
     * 段尾
     */
    private float gapEnd = SizeUtils.dp2px(80);
    /**
     * 是否触摸段头
     */
    private boolean isGapStart = false;
    /**
     * 是否触摸段尾
     */
    private boolean isGapEnd = false;
    /**
     * 触摸移动x
     */
    private float moveX;

    /**
     * 最左
     *
     * @param context
     */
    private int viewStart;

    /**
     * 最右
     *
     * @param context
     */
    private int viewEnd;

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

    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mViewHeight = SizeUtils.dp2px(120);
        mViewWidth = ScreenUtils.getScreenWidth();
        setMeasuredDimension(((ViewGroup) getParent()).getLayoutParams().width, mViewHeight);
    }


    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(lineWidth);

        doubles = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            doubles.add(Math.random());
        }
    }

    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(lineWidth);
        drawTime(canvas);
        drawScale(canvas);
        drawGap(canvas);
    }

    /**
     * 绘制时间
     *
     * @param canvas
     */
    private void drawTime(Canvas canvas) {
        mPaint.setTextSize(SizeUtils.dp2px(16));
        canvas.drawText("00:00", interval, SizeUtils.dp2px(24), mPaint);
        Rect rect = new Rect();
        String max = timeFormat(maxScale);
        mPaint.getTextBounds(max, 0, max.length(), rect);
        canvas.drawText(max, mViewWidth - rect.width() - interval, SizeUtils.dp2px(24), mPaint);
    }

    /**
     * 绘制阶段
     *
     * @param canvas
     */
    private void drawGap(Canvas canvas) {
        mPaint.setStrokeWidth(lineWidth * 3);
        mPaint.setColor(Color.RED);
        canvas.drawLine(gapStart, SizeUtils.dp2px(42), gapStart, SizeUtils.dp2px(116), mPaint);
        float start = (gapStart - viewStart) * maxScale / overall;
        int starts = (int) start;
        Rect sr = new Rect();
        String s = timeFormat(starts);
        mPaint.getTextBounds(s, 0, s.length(), sr);
        canvas.drawText(s, gapStart - sr.width() / 2, SizeUtils.dp2px(24), mPaint);


        canvas.drawLine(gapEnd, SizeUtils.dp2px(42), gapEnd, SizeUtils.dp2px(116), mPaint);
        float end = (gapEnd - viewStart) * maxScale / overall;
        int ends = (int) end;
        Rect er = new Rect();
        String e = timeFormat(ends);
        mPaint.getTextBounds(e, 0, e.length(), er);
        canvas.drawText(timeFormat(ends), gapEnd - er.width() / 2, SizeUtils.dp2px(24), mPaint);
    }

    public void setMaxScale(int maxScale) {
        this.maxScale = maxScale;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                moveX = event.getX();
                if (event.getX() > gapStart && event.getX() < gapStart + lineWidth * 3) {
                    isGapStart = true;
                }
                if (event.getX() > gapEnd && event.getX() < gapEnd + lineWidth * 3) {
                    isGapEnd = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (moveX == event.getX() || event.getX() > viewEnd || event.getX() < viewStart) {
                    return true;
                }
                if (isGapStart) {
                    if (moveX < event.getX()) {
                        if (gapStart + lineWidth * 8 < gapEnd) {
                            gapStart = event.getX();
                            drawMove();
                        } else {
                            isGapStart = false;
                        }
                    } else {
                        gapStart = event.getX();
                        drawMove();
                    }
                    moveX = event.getX();
                }
                if (isGapEnd) {
                    if (moveX > event.getX()) {
                        if (gapEnd - lineWidth * 8 > gapStart) {
                            gapEnd = event.getX();
                            drawMove();
                        } else {
                            isGapEnd = false;
                        }
                    } else {
                        gapEnd = event.getX();
                        drawMove();
                    }
                    moveX = event.getX();
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

    /**
     * 绘制刻度
     *
     * @param canvas
     */
    private void drawScale(Canvas canvas) {
        int remainder = (mViewWidth - interval * 2) % SizeUtils.dp2px(10);
        int startX = (interval * 2 + remainder) / 2;
        overall = (mViewWidth - (interval * 2 + remainder));
        int number = overall / SizeUtils.dp2px(10);
        viewStart = startX;
        canvas.drawLine(startX, scaleStartHeight, startX, scaleStopHeight, mPaint);
        for (int i = 0; i < number - 1; i++) {
            startX += SizeUtils.dp2px(10);
            if (doubles.get(i) > 0.4d) {
                canvas.drawLine(startX, SizeUtils.dp2px(64), startX, SizeUtils.dp2px(96), mPaint);
            } else {
                canvas.drawLine(startX, scaleStartHeight, startX, scaleStopHeight, mPaint);
            }
        }
        startX += SizeUtils.dp2px(10);
        viewEnd = startX;
        canvas.drawLine(startX, scaleStartHeight, startX, scaleStopHeight, mPaint);
    }

    private String timeFormat(int time) {
        int miao = time % 60;
        int fen = time / 60;
        int hour = 0;
        if (fen >= 60) {
            hour = fen / 60;
            fen = fen % 60;
        }
        String timeString = "";
        String miaoString = "";
        String fenString = "";
        String hourString = "";
        if (miao < 10) {
            miaoString = "0" + miao;
        } else {
            miaoString = miao + "";
        }
        if (fen < 10) {
            fenString = "0" + fen;
        } else {
            fenString = fen + "";
        }
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = hour + "";
        }
        if (hour != 0) {
            timeString = hourString + ":" + fenString + ":" + miaoString;
        } else {
            timeString = fenString + ":" + miaoString;
        }
        return timeString;
    }

}
