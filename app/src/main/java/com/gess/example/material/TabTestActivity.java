package com.gess.example.material;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.example.fragment.AFragment;
import com.gess.example.fragment.OnFragmentInteractionListener;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabTestActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    public final static String TAG = "TabTestActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] title = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        tabLayout = findViewById(R.id.design_tab);
        viewPager = findViewById(R.id.vp_tab);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LogUtils.dTag(com.gess.example.TAG.TAG_TAB, "onTabSelected " + tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LogUtils.dTag(com.gess.example.TAG.TAG_TAB, "onTabUnselected " + tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                LogUtils.dTag(com.gess.example.TAG.TAG_TAB, "onTabReselected " + tab.getText());
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            fragments.add(AFragment.newInstance("A", title[i]));
        }
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        LogUtils.d(TAG,"uri = " + uri);
    }
}
