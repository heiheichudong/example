package com.gess.example.diyview;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.note.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ScaleViewTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_view_test);
        findViewById(R.id.btn_ssmax).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((SimpleScaleView) findViewById(R.id.ssv_test)).setMaxScale(60);
                ((ScaleScrollView) findViewById(R.id.ssv_test)).setMaxScale(60);
            }
        });
        findViewById(R.id.btn_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopuptWindow();
            }
        });
        ((ScaleScrollView) findViewById(R.id.ssv_test)).setListent(new ScaleScrollView.ScaleScrollListent(){

            @Override
            public void range(int start, int end) {
                LogUtils.d("start = " + start,"end = " + end);
            }
        });
    }

    private PopupWindow mPopupWindow;

    /**
     * 初始化popupWindow
     */
    private void initPopuptWindow() {
        View pop_view = View.inflate(this, R.layout.layout_pop_list, null);
        RecyclerView recyclerView = ((RecyclerView) pop_view.findViewById(R.id.rv_pop));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter adapter = new ListAdapter(recyclerView);
        List<String> list =  new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("第" + i +"个");
        }
        adapter.setData(list);
        recyclerView.setAdapter(adapter);

        mPopupWindow = new PopupWindow(pop_view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setFocusable(true);//设置pw中的控件能够获取焦点
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        mPopupWindow.setBackgroundDrawable(dw);//设置mPopupWindow背景颜色或图片，这里设置半透明
        mPopupWindow.setOutsideTouchable(true); //设置可以通过点击mPopupWindow外部关闭mPopupWindow
//        mPopupWindow.setAnimationStyle(R.style.PopupAnimationAmount);//设置mPopupWindow的进出动画
        mPopupWindow.update();//刷新mPopupWindow
        mPopupWindow.showAsDropDown(findViewById(R.id.btn_pop), 0, 0);//mPopupWindow显示的位置

        /**
         * PopupWindow消失监听方法
         */
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
    }

}
