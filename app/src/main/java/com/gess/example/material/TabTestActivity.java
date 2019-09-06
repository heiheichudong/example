package com.gess.example.material;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.example.fragment.AFragment;
import com.gess.example.fragment.OnFragmentInteractionListener;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabTestActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] title = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        tabLayout = findViewById(R.id.design_tab);
//        tabLayout.addTab(tabLayout.newTab().setText("第一项"));
//        tabLayout.addTab(tabLayout.newTab().setText("第二项"));
//        tabLayout.addTab(tabLayout.newTab().setText("第三项"));
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            if (tabLayout.getChildAt(i) instanceof TabItem){
//                ((TabItem) tabLayout.getChildAt(i))
//            }
//        }
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

//        tabLayout.setupWithViewPager(viewPager);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(AFragment.newInstance("A", "B"));
        fragments.add(AFragment.newInstance("A", "B"));
        fragments.add(AFragment.newInstance("A", "B"));
        fragments.add(AFragment.newInstance("A", "B"));
        fragments.add(AFragment.newInstance("A", "B"));
        fragments.add(AFragment.newInstance("A", "B"));
        fragments.add(AFragment.newInstance("A", "B"));
//        fragments.add(AFragment.newInstance("A","B"));
//        fragments.add(AFragment.newInstance("A","B"));
//        fragments.add(AFragment.newInstance("A","B"));
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

//            @Nullable
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return title[position];
//            }


        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
