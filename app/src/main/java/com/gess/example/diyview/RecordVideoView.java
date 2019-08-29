package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.blankj.utilcode.util.SizeUtils;


public class RecordVideoView extends SurfaceView implements SurfaceHolder.Callback {

    public final static String TAG = "RecordVideoView";
    private int radius = 40;//外圈半径dp
    private int viewRadius = 60;//view半径dp
    private int pathWidth = 8;//外圈圆宽度dp
    private Paint mPaint;
    private Canvas mCanvas;
    private SurfaceHolder mHolder;
    private AnimationThread mThread;
    private Enum recordVideoStatus = status.INTNIAL;

    private int time = 200;
    private int width = 1;
    private int recordingWidth = 8;
    private boolean isPlus;
    private boolean isDestroy;
    private changeRecordlistent recordlistent;

    public enum status {
        TAKE_PHOTO,
        TAKE_PHOTO_END,
        INTNIAL,            //初始
        INTNIAL_END,        //初始完毕
        ACTION_BEFORE,      //运动中
        ACTION_AFTER,       //运动中
        SCALE_BEFORE,       //运动中
    }

    public void setRecordVideoStatus(Enum recordVideoStatus) {
        this.recordVideoStatus = recordVideoStatus;
    }

    public Enum getRecordVideoStatus() {
        return recordVideoStatus;
    }

    public interface changeRecordlistent {
        void recording();

        void stopRecord();

        void takePhoto();
    }

    public void setRecordlistent(changeRecordlistent recordlistent) {
        this.recordlistent = recordlistent;
    }

    public RecordVideoView(Context context) {
        this(context, null);
    }

    public RecordVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecordVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {               //初始化
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mHolder = getHolder();
        mHolder.addCallback(this);
        setZOrderOnTop(true);
        mHolder.setFormat(PixelFormat.TRANSLUCENT);
//        mThread = new AnimationThread(mHolder);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(SizeUtils.dp2px(viewRadius * 2), SizeUtils.dp2px(viewRadius * 2));
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d(TAG, "surfaceCreated");
        isDestroy = true;
        if (mThread != null)
            mThread = null;
        mThread = new AnimationThread(holder);
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d(TAG, "surfaceDestroyed");
        isDestroy = false;
        recordVideoStatus = status.INTNIAL;
        time = 200;
        if (mThread != null)
            mThread = null;
    }

    class AnimationThread extends Thread {

        private SurfaceHolder holder;

        public AnimationThread(SurfaceHolder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            try {
                synchronized (holder) {
                    while (isDestroy) {
                        if (recordVideoStatus == status.TAKE_PHOTO){
                            mCanvas = holder.lockCanvas();
                            initTake(mCanvas);
                            holder.unlockCanvasAndPost(mCanvas);
                        }
                        if (recordVideoStatus == status.INTNIAL) {
                            mCanvas = holder.lockCanvas();
                            initStatus(mCanvas);
                            holder.unlockCanvasAndPost(mCanvas);
                        }
                        if (recordVideoStatus == status.ACTION_BEFORE) {
                            mCanvas = holder.lockCanvas();
                            time = 20;
                            actioning(mCanvas, width);
                            holder.unlockCanvasAndPost(mCanvas);
                        }
                        if (recordVideoStatus == status.ACTION_AFTER) {
                            mCanvas = holder.lockCanvas();
                            time = 150;
                            recording(mCanvas, recordingWidth);
                            holder.unlockCanvasAndPost(mCanvas);
                        }
                        if (recordVideoStatus == status.SCALE_BEFORE) {
                            mCanvas = holder.lockCanvas();
                            time = 20;
                            scale(mCanvas, width);
                            holder.unlockCanvasAndPost(mCanvas);
                        }
                        Log.d(TAG, "while " + " recordVideoStatus = " + recordVideoStatus);
                        Thread.sleep(time);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initStatus(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        //外圈
        mPaint.setStrokeWidth(SizeUtils.dp2px(pathWidth));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);

        //内圈
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius - pathWidth), mPaint);

        if (recordlistent != null){
            recordlistent.stopRecord();
        }
        recordVideoStatus = status.INTNIAL_END;
    }

    private void initTake(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        //外圈
        mPaint.setStrokeWidth(SizeUtils.dp2px(pathWidth));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);

        //内圈
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius - pathWidth), mPaint);

        if (recordlistent != null){
            recordlistent.takePhoto();
        }
        recordVideoStatus = status.TAKE_PHOTO_END;
    }

    private void actioning(Canvas canvas, int f) {
        if (width == 9) {
            time = 200;
            action(canvas);
            return;
        }
        width++;
        scaleing(canvas, f);
    }

    private void scale(Canvas canvas, int f) {
        if (width == 0) {
            time = 200;
            initStatus(canvas);
            return;
        }
        width--;
        scaleing(canvas, f);
    }

    private void scaleing(Canvas canvas, int f) {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(SizeUtils.dp2px(pathWidth + f));
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius + f), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);

        mPaint.setStrokeWidth(0);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius - pathWidth - 2 * f), mPaint);
    }

    private void action(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(SizeUtils.dp2px(pathWidth * 2));
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius + pathWidth), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        RectF rect = new RectF(SizeUtils.dp2px(45), SizeUtils.dp2px(45),
                SizeUtils.dp2px(75),
                SizeUtils.dp2px(75));
        canvas.drawRoundRect(rect, 20, 20, mPaint);

        if (recordlistent != null){
            recordlistent.recording();
        }
        recordVideoStatus = status.ACTION_AFTER;
    }

    private void recording(Canvas canvas, int f) {
        if (isPlus) {
            if (recordingWidth == 8) {
                isPlus = false;
                return;
            }
            recordingWidth++;
        } else {
            if (recordingWidth == 0) {
                isPlus = true;
                return;
            }
            recordingWidth--;
        }
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(SizeUtils.dp2px(pathWidth + f));
        Path path = new Path();
        path.addCircle(SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(viewRadius), SizeUtils.dp2px(radius + pathWidth), Path.Direction.CCW);
        canvas.drawPath(path, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        RectF rect = new RectF(SizeUtils.dp2px(45), SizeUtils.dp2px(45),
                SizeUtils.dp2px(75),
                SizeUtils.dp2px(75));
        canvas.drawRoundRect(rect, 20, 20, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (recordVideoStatus == status.INTNIAL_END) {
            recordVideoStatus = status.ACTION_BEFORE;
        }
        if (recordVideoStatus == status.ACTION_AFTER) {
            recordVideoStatus = status.SCALE_BEFORE;
        }
        if (recordVideoStatus == status.TAKE_PHOTO_END){
            recordVideoStatus = status.TAKE_PHOTO;
        }
        return false;
    }
}
