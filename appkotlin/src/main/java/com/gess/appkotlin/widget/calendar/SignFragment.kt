package com.gess.appkotlin.widget.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gess.appkotlin.R
import java.util.*
import kotlin.collections.ArrayList

class SignFragment() : Fragment() {

    private lateinit var mView: View
    private lateinit var mAdapter: SignDateAdapter
    private var year: Int = 0
    private var month: Int = 0
    private lateinit var clickDayListener: ClickDayListener

    fun setListener(listener: ClickDayListener) {
        this.clickDayListener = listener
    }

    interface ClickDayListener {
        fun clickDay(dataBean: SignDataBean)
    }

    companion object {
        const val YEAR = "year" //年
        const val MONTH = "month" //月

        @JvmStatic
        fun newInstance(year: Int, month: Int) =
                SignFragment().apply {
                    arguments = Bundle().apply {
                        putInt(YEAR, year)
                        putInt(MONTH, month)
                    }
                }

        @JvmStatic
        fun getToday() =
                SignDataBean(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH) + 1,
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH))


    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.frag_sign, null)
        initArguments()
        initView()
        initData()
        return mView
    }

    private fun initArguments() {
        arguments?.let {
            year = it.getInt(YEAR)
            month = it.getInt(MONTH)
        }
    }

    private fun initView() {
        val recyclerView = mView.findViewById<RecyclerView>(R.id.rv_sign)
        mAdapter = SignDateAdapter(recyclerView)
        recyclerView.adapter = mAdapter
        mAdapter.setOnRVItemClickListener { parent, itemView, position ->
            if (this::clickDayListener.isInitialized && this::clickDayListener != null) {
                clickDayListener.clickDay(mAdapter.getItem(position))
            }
        }
    }

    private fun initData() {
        val data = ArrayList<SignDataBean>()
        //获取第一天是星期几然后计算出需要填充的空白数据
        repeat(getMonthOneDayWeek() - 1) {
            //填充空白的
            data.add(SignDataBean(0, 0, 0))
        }
        //填充日期数据
        repeat(getMonthMaxDay()) {
            data.add(SignDataBean(year, month, it + 1))
        }
        mAdapter.data = data
    }

    /**
     * 刷新数据
     */
    fun refreshData() {
        mAdapter?.notifyDataSetChanged()
    }

    /**
     * 获取第一天为星期几
     */
    private fun getMonthOneDayWeek(): Int {
        val a: Calendar = Calendar.getInstance()
        a.set(Calendar.YEAR, year)
        a.set(Calendar.MONTH, month)
        a.set(Calendar.DATE, 1) //把日期设置为当月第一天
        return a.get(Calendar.DAY_OF_WEEK)
    }

    /**
     * 获取当月有几天
     */
    private fun getMonthMaxDay(): Int {
        val a: Calendar = Calendar.getInstance()
        a.set(Calendar.YEAR, year)
        a.set(Calendar.MONTH, month)
        return a.getActualMaximum(Calendar.DAY_OF_MONTH)
    }


}