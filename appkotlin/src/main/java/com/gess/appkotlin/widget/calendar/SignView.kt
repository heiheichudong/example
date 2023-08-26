package com.gess.appkotlin.widget.calendar

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.gess.appkotlin.R
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class SignView : FrameLayout {

    private lateinit var mViewPager: ViewPager2
    private val fragments: ArrayList<SignFragment> = ArrayList()
    private var fragmentAdapter: SignFragAdapter? = null
    private var currentPos = 0

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        View.inflate(context, R.layout.view_sign, this)
        initView()
        initFragments()
        initListener()
    }

    private fun initView() {
        mViewPager = findViewById(R.id.vp_sign)
    }

    private fun initFragments() {
        fragments.clear()
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        var offsetItem = (currentYear - 2023) * 12 + 6
        for (i in currentMonth - offsetItem until currentMonth) {
            var month = i
            var year = currentYear
            if (i < 0) {
                month = 12 - abs(i)
                year = currentYear - 1
            }
            val fragment = SignFragment.newInstance(year, month)
            fragments.add(fragment)
        }
        //后面的默认多出5页，然后随着页面滑动来动态增加页数
        for (i in currentMonth..currentMonth + 5) {
            var month = i
            var year = currentYear
            if (i > 11) {
                month = i - 12
                year = currentYear + 1
            }
            val fragment = SignFragment.newInstance(year, month)
            fragments.add(fragment)
        }
        currentPos = fragments.size - 6
        if (context is FragmentActivity) {
            val activity = context as FragmentActivity
            fragmentAdapter = SignFragAdapter(activity, fragments)
            mViewPager.adapter = fragmentAdapter
            mViewPager.setCurrentItem(currentPos, false)
        }
    }

    private fun initListener(){
        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPos = position
                fragments[currentPos].arguments?.let {
                    val currentPageYear = it.getInt(SignFragment.YEAR) //当前页的年
                    val currentPageMonth = it.getInt(SignFragment.MONTH) //当前页的月
                    //展示的月需要加1（因为系统中的月是从0开始的）
//                    onPageChangedCallBack?.onPageChanged(currentPageYear,currentPageMonth + 1)
                }
                //刷新下当前的数据
                fragments[currentPos].refreshData()
                if(currentPos + 3 > fragments.size){
                    addNextFragment()
                }
            }
        })
    }

    /**
     * 动态添加后面的日历
     */
    private fun addNextFragment() {
        fragments[fragments.size - 1].arguments?.let {
            //获取展示的最小的年和月
            val minYear = it.getInt(SignFragment.YEAR)
            val minMonth = it.getInt(SignFragment.MONTH)
            //动态加两个
            for (i in minMonth + 1 until minMonth + 2) {
                var month = i
                var year = minYear
                if (i > 11) {
                    month = i - 12
                    year = minYear + 1
                }
                val fragment = SignFragment.newInstance(year, month)
                fragments.add(fragment)
            }
            fragmentAdapter?.notifyDataSetChanged()
        }
    }

}