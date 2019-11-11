package com.gess.example.diyview;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.gess.example.R;
import com.gess.note.BaseActivity;

public class SimpleScaleViewActivity extends BaseActivity {

    private com.gess.note.widget.scaleview.SimpleScaleView scrollView;
    private RelativeLayout ll_texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_scale_view);
        scrollView = findViewById(R.id.vssv);
        scrollView.setMax(15);
        ll_texts = findViewById(R.id.ll_texts);
        addText();
    }

    public void addText(){
        final View view = View.inflate(this, R.layout.ll_text_item, null);
        view.findViewById(R.id.tv_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText();
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            private int startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("打印操作：", "按下了");
                        //获取当前按下的坐标
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        //获取移动后的坐标
                        int moveY = (int) event.getRawY();
                        //拿到手指移动距离的大小
                        int move_bigY = moveY - startY;
//                        Log.e("打印操作：", "\nX移动了" + move_bigX + "\nY移动了" + move_bigY);
                        //拿到当前控件未移动的坐标
                        int left = view.getLeft();
                        int top = view.getTop();
//                        left += move_bigX;
                        top += move_bigY;
                        int right = left + view.getWidth();
                        int bottom = top + view.getHeight();
//                        ll_texts.scrollTo(left,bottom);
//                        view.layout(left, top, right, bottom);
//                        view.setTop(top);
//                        view.setBottom(bottom);
                        view.offsetTopAndBottom(move_bigY);
//                        startX = moveX;
                        startY = moveY;
                        break;
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = view.getLeft();
                        layoutParams.topMargin = view.getTop();
                        view.setLayoutParams(layoutParams);
                        Log.e("打印操作：", "抬起了");
                        break;
                }
                return true;//此处一定要返回true，否则监听不生效
            }
        });
        ll_texts.addView(view);
    }
}
