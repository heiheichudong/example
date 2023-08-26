package com.gess.appkotlin.widget.calendar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignFragAdapter(fm: FragmentActivity, fragments:List<Fragment>) : FragmentStateAdapter(fm) {
    private var mFragments:List<Fragment> = fragments

    override fun getItemCount(): Int {
        return mFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragments[position]
    }
}