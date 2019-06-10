package com.gess.example.diyview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.gess.note.utils.Logger;
import com.gess.note.utils.SizeUtils;

import androidx.annotation.Nullable;

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
        Logger.debug(TAG, "view 宽度 = " + SizeUtils.px2dp(MeasureSpec.getSize(widthMeasureSpec)) + "dp");
        Logger.debug(TAG, "view 高度 = " + SizeUtils.px2dp(MeasureSpec.getSize(heightMeasureSpec)) + "dp");
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
