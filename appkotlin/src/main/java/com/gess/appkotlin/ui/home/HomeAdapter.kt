package com.gess.appkotlin.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gess.appkotlin.R
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(var context:Context) : Adapter<HomeViewHolder>() {

    var mData = arrayListOf("http://mvideo.com.tv/2019/4/6/A5B03A1B8E6EFD7B12E9B87364F9AD642BB7F9C5C357533E2F09BD4B35BFF68F/540.mp4",
            "http://mvideo.com.tv/2019/5/2/95BB7C6D41D1FF7B945F49FBF6E726A555ED8092132A46F98BE77C9C1FDAE4FF/540.mp4",
            "http://mvideo.com.tv/2019/9/20/D5416F44182E8AD2EB691265C5F898C76264716A0E3EC3814D8923FDA11B98A0/540.mp4",
            "http://mvideo.com.tv/2019/1/31/EAF378E2482371A24CF98CA0F5529B60DFF951384F88E3132597552847203D3B/540.mp4")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home,null))
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view.ctv_item.path = mData[position]
        holder.view.tv_item.text = "$position"
//        holder.view.ctv_item.customPlay()
    }
}

class HomeViewHolder(var view: View) : ViewHolder(view)