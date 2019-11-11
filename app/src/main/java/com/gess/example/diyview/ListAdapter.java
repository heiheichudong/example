package com.gess.example.diyview;

import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;


public class ListAdapter extends BGARecyclerViewAdapter<String> {

    public ListAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.layout_single_textview);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, String model) {
        LogUtils.d("第" + position + "项 = " + model);
        helper.getTextView(R.id.single_text).setText(model);
    }
}
