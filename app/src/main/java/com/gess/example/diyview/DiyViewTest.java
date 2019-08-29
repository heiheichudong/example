package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;

public class DiyViewTest extends View {
    public static String TAG = "DiyViewTest";

    public DiyViewTest(Context context) {
        this(context, null);
    }

    public DiyViewTest(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DiyViewTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        LogUtils.d(TAG, "view 宽度 = " + SizeUtils.px2dp(MeasureSpec.getSize(widthMeasureSpec)) + "dp");
        LogUtils.d(TAG, "view 高度 = " + SizeUtils.px2dp(MeasureSpec.getSize(heightMeasureSpec)) + "dp");
        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.EXACTLY://match_parent 确定的数值
                break;
            case MeasureSpec.AT_MOST:// wrap_content
                break;
            case MeasureSpec.UNSPECIFIED: //很少用
                break;
            default:
                break;
        }
        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.EXACTLY://match_parent 确定的数值
                break;
            case MeasureSpec.AT_MOST:// wrap_content
                height = SizeUtils.dp2px(48);
                break;
            case MeasureSpec.UNSPECIFIED: //很少用
                break;
            default:
                break;
        }
        setMeasuredDimension(width, height);
    }

}
