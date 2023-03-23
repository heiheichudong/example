package com.gess.example.list;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.gess.example.R;
import com.gess.note.BaseActivity;


public class ListActivity extends BaseActivity {


    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListViewModel viewModel = new ViewModelProvider.NewInstanceFactory().create(ListViewModel.class);
        mRecyclerView = ((RecyclerView) findViewById(R.id.rv_list));
        ListAdapter mAdapter = new ListAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        viewModel.getUsers().observe(this, testBeans -> {
            mAdapter.addMoreData(testBeans);
        });
        viewModel.loadUsers(false);

    }
}