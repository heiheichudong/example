package com.gess.appkotlin.widget.calendar

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper
import com.gess.appkotlin.R

class SignDateAdapter(recyclerView: RecyclerView) :
        BGARecyclerViewAdapter<SignDataBean>(recyclerView, R.layout.item_sign) {

    override fun fillData(helper: BGAViewHolderHelper?, position: Int, model: SignDataBean?) {
        helper?.apply {
            model?.apply {
                if (model.day != 0){
                    getTextView(R.id.tv_sign_item).text = day.toString()
                    when(isSign){
                        else -> getImageView(R.id.iv_sign_item).setBackgroundResource(R.drawable.bga_adapter_divider_shape)
                    }
                }else{
                    getTextView(R.id.tv_sign_item).text = ""
                    getImageView(R.id.iv_sign_item).setBackgroundColor(Color.TRANSPARENT)
                }
            }
        }
    }
}