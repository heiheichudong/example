package com.gess.example.diyview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class DiyViewGroupTest extends ViewGroup {
    public DiyViewGroupTest(Context context) {
        super(context);
    }

    public DiyViewGroupTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiyViewGroupTest(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
