package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class TestImageView extends AppCompatImageView {

    private Paint mPaint;
    private int MIN_WIDTH = 300;
    private float bitmapArea = 0.87f;


    public TestImageView(Context context) {
        super(context);
        init();
    }

    public TestImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int w = Math.min(widthSpecSize, heightSpecSize);
        w = Math.min(w, MIN_WIDTH);
        setMeasuredDimension(w, w);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        getPaint();
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) * bitmapArea, mPaint);
    }

    public Paint getPaint() {
        Bitmap bitmap = drawableToBitmap(getDrawable());
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        float r = getWidth() * 1f / bitmap.getWidth() * 1f;
        r = r * 0.74f;
        matrix.setScale(r, r);
        matrix.postTranslate(getWidth() * 0.13f, getWidth() * 0.13f);
        shader.setLocalMatrix(matrix);
        mPaint.setShader(shader);
        return mPaint;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            return bitmapDrawable.getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        if (w <= 0 || h <= 0) {
            w = 100;
            h = 100;
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

}
