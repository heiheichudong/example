package com.gess.example.widget.viewpager;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;

public final class VerticalViewPagerCompat {
    private VerticalViewPagerCompat() {}

    public static void setDataSetObserver(PagerAdapter adapter, DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }
}
