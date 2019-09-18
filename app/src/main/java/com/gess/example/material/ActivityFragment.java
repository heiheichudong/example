package com.gess.example.material;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.gess.example.R;


public class ActivityFragment extends Fragment {

    private ActivityViewModel mActivityViewModel;

    public static ActivityFragment newInstance() {
        return new ActivityFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);
        // TODO: Use the ActivityViewModel
    }

}
