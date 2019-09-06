package com.gess.example.fragment;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class FragmentPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Fragment> ivGoodsList;

    public FragmentPagerAdapter(Context context, ArrayList<Fragment> ivGoodsList) {
        this.context = context;
        this.ivGoodsList = ivGoodsList;
    }

    @Override
    public int getCount() {
        return ivGoodsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

//    @Override
//    public ImageView instantiateItem(ViewGroup container, int position) {
//        ImageView imageView = ivGoodsList.get(position);
//        container.addView(imageView);
//        return imageView;
//    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        ImageView imageView = (ImageView) object;
//        container.removeView(imageView);
//    }
}

