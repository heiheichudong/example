package com.gess.example.list;

import androidx.recyclerview.widget.RecyclerView;

import com.gess.example.R;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

public class ListAdapter extends BGARecyclerViewAdapter<TestBean> {

    public ListAdapter(RecyclerView recyclerView) {
        super(recyclerView,R.layout.item_list_layout);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, TestBean model) {
        helper.getTextView(R.id.tv_list_1).setText(model.getId());
        helper.getTextView(R.id.tv_list_2).setText(model.getName());
        helper.getTextView(R.id.tv_list_3).setText(model.getContent());
    }

    public void addEmpty(){

    }
}
