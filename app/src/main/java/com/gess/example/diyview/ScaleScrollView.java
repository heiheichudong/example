package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;

import java.util.ArrayList;
import java.util.List;

public class ScaleScrollView extends View {

    public final String TAG = this.getClass().getSimpleName();

    private enum PaintType {
        TIME,//时间
        TIME_START,//开始时间
        TIME_END,//结束时间
        LINE,//线
        LINE_DARK,//线
    }

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
     * 间隔（每个刻度间隔距离）
     */
    private int interval = SizeUtils.dp2px(6);
    /**
     * 线宽
     */
    private int lineWidth = SizeUtils.dp2px(1);
    /**
     * 每一个段的距离（刻度间距离 + 刻度宽度）
     */
    private int segmentWidth = interval + lineWidth;
    /**
     * 线高中心数值（dp）
     */
    private int scaleMiddle = 64;
    /**
     * 线高度集合
     */
    private int[][] scaleHeight = {
            {SizeUtils.dp2px(scaleMiddle - 12), SizeUtils.dp2px(scaleMiddle + 12)},
            {SizeUtils.dp2px(scaleMiddle - 8), SizeUtils.dp2px(scaleMiddle + 8)},
            {SizeUtils.dp2px(scaleMiddle - 16), SizeUtils.dp2px(scaleMiddle + 16)},
            {SizeUtils.dp2px(scaleMiddle - 20), SizeUtils.dp2px(scaleMiddle + 20)},
            {SizeUtils.dp2px(scaleMiddle - 36), SizeUtils.dp2px(scaleMiddle + 36)},
    };

    /**
     * 刻度个数
     */
    private int scaleNumber;
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
     * 触摸移动x
     */
    private float moveX;

    /**
     * 最左
     */
    private int viewStart;

    /**
     * 最右
     */
    private int viewEnd;
    /**
     *
     */
    private int startGap, endGap;

    public ScaleScrollListent listent;

    public interface ScaleScrollListent {
        void range(int start, int end);
    }

    public void setListent(ScaleScrollListent listent) {
        this.listent = listent;
    }

    public ScaleScrollView(Context context) {
        this(context, null);
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
//        mViewWidth = ScreenUtils.getScreenWidth();
        mViewWidth = MeasureSpec.getSize(widthMeasureSpec);
        measure();
        setMeasuredDimension(mViewWidth, mViewHeight);
    }

    private void measure() {
        //view的宽度 - 2个最边缘刻度与view边的距离 与 每一个段的距离（刻度间距离 + 刻度宽度） 取余
        int remainder = (mViewWidth - interval * 2) % segmentWidth;
        //最边缘刻度与view边的最终距离
        viewStart = (interval * 2 + remainder) / 2;
        viewEnd = mViewWidth - viewStart;
        //去掉余数后的的总长（减掉余数就可平分每一段）
        overall = (mViewWidth - (interval * 2 + remainder));
        //刻度个数
        scaleNumber = overall / segmentWidth;
        initScaleNum(scaleNumber);
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
        mPaint.setTextSize(SizeUtils.dp2px(12));
    }

    private void initScaleNum(int num) {
        doubles = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            doubles.add(Math.random());
        }
    }

    /**
     * 改变笔
     */
    private void changePaint(PaintType type) {
        switch (type) {
            case TIME:
                mPaint.setColor(Color.RED);
                mPaint.setStrokeWidth(lineWidth * 3);
                break;
            case TIME_START:
                mPaint.setColor(Color.parseColor("#ffabea"));
                mPaint.setStrokeWidth(lineWidth * 3);
                break;
            case TIME_END:
                mPaint.setColor(Color.parseColor("#ddddaa"));
                mPaint.setStrokeWidth(lineWidth * 3);
                break;
            case LINE:
                mPaint.setColor(Color.GRAY);
                mPaint.setStrokeWidth(lineWidth);
                break;
            case LINE_DARK:
                mPaint.setColor(Color.parseColor("#ffddaa"));
                mPaint.setStrokeWidth(lineWidth);
                break;
            default:
                break;
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
        drawTime(canvas);
        drawScale(canvas);
        drawGap(canvas);
        drawRangeNum(canvas);
    }

    /**
     * 绘制时间
     *
     * @param canvas
     */
    private void drawTime(Canvas canvas) {
        changePaint(PaintType.TIME);
        mPaint.setTextSize(SizeUtils.dp2px(12));
        canvas.drawText("00:00", interval, scaleHeight[4][1], mPaint);
        Rect rect = new Rect();
        String max = secToTime(maxScale);
        mPaint.getTextBounds(max, 0, max.length(), rect);
        canvas.drawText(max, mViewWidth - rect.width() - interval, scaleHeight[4][1], mPaint);
    }

    public void drawRangeNum(Canvas canvas) {
        changePaint(PaintType.TIME);
        Rect rect = new Rect();
        String max = secToTime(endGap - startGap);
        mPaint.getTextBounds(max, 0, max.length(), rect);
        canvas.drawText(max, mViewWidth / 2 - rect.width() / 2 - interval, scaleHeight[4][1], mPaint);
    }

    /**
     * 绘制阶段
     *
     * @param canvas
     */
    private void drawGap(Canvas canvas) {
        changePaint(PaintType.TIME_START);
        canvas.drawLine(gapStart, scaleHeight[3][0], gapStart, scaleHeight[3][1], mPaint);
        float start = (gapStart - viewStart) * maxScale / overall;
        int starts = (int) start;
        startGap = starts;
        Rect sr = new Rect();
        String s = secToTime(starts);
        mPaint.getTextBounds(s, 0, s.length(), sr);
        canvas.drawText(s, gapStart - sr.width() / 2, scaleHeight[4][0], mPaint);

        changePaint(PaintType.TIME_END);
        canvas.drawLine(gapEnd, scaleHeight[3][0], gapEnd, scaleHeight[3][1], mPaint);
        float end = (gapEnd - viewStart) * maxScale / overall;
        int ends = (int) end;
        endGap = ends;
        Rect er = new Rect();
        String e = secToTime(ends);
        mPaint.getTextBounds(e, 0, e.length(), er);
        canvas.drawText(secToTime(ends), gapEnd - er.width() / 2, scaleHeight[4][0], mPaint);
    }

    /**
     * 绘制刻度
     *
     * @param canvas
     */
    private void drawScale(Canvas canvas) {
        changePaint(PaintType.LINE_DARK);
        //记录刻度初始
        int startX = viewStart;
        //画最边缘刻度
        canvas.drawLine(startX, scaleHeight[2][0], startX, scaleHeight[2][1], mPaint);
        //画其他刻度
        for (int i = 0; i < scaleNumber - 1; i++) {
            startX += segmentWidth;
            LogUtils.d("startX = " + startX + " gapStart = " + gapStart + " gapEnd = " + gapEnd);
            if (startX < gapStart || startX > gapEnd) {
                changePaint(PaintType.LINE_DARK);
            } else {
                changePaint(PaintType.LINE);
            }
            if (doubles.get(i) > 0.66d) {
                canvas.drawLine(startX, scaleHeight[2][0], startX, scaleHeight[2][1], mPaint);
            } else if (doubles.get(i) < 0.33d) {
                canvas.drawLine(startX, scaleHeight[0][0], startX, scaleHeight[0][1], mPaint);
            } else {
                canvas.drawLine(startX, scaleHeight[1][0], startX, scaleHeight[1][1], mPaint);
            }
        }
        startX += segmentWidth;
        //画最边缘刻度
        canvas.drawLine(startX, scaleHeight[2][0], startX, scaleHeight[2][1], mPaint);
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
                break;
            case MotionEvent.ACTION_MOVE:
                //判断是否移出view
                if (moveX == event.getX() || event.getX() > viewEnd || event.getX() < viewStart) {
                    return true;
                }
                if (Math.abs(event.getX() - gapStart) < Math.abs(event.getX() - gapEnd)) {
                    gapStart = event.getX();
                } else if (Math.abs(event.getX() - gapStart) > Math.abs(event.getX() - gapEnd)) {
                    gapEnd = event.getX();
                } else {
                    if (moveX > event.getX()) {
                        gapStart = event.getX();
                    } else {
                        gapEnd = event.getX();
                    }
                }
                drawMove();
                moveX = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                listent.range(startGap, endGap);
                break;
            default:
                break;
        }
        return true;

    }

    private void drawMove() {
        invalidate();
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
