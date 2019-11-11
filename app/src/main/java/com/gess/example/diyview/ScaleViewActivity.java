package com.gess.example.diyview;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.gess.example.R;
import com.gess.note.BaseActivity;
import com.gess.note.widget.scaleview.VerticalScaleScrollView;

public class ScaleViewActivity extends BaseActivity {

    private VerticalScaleScrollView scrollView;
    private RelativeLayout ll_texts;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_view);
        scrollView = findViewById(R.id.vssv);
        ll_texts = findViewById(R.id.ll_texts);
        view = View.inflate(this, R.layout.ll_text_item, null);

        view.setOnTouchListener(new View.OnTouchListener() {
            private int startY;
//            private int startX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("打印操作：", "按下了");
                        //获取当前按下的坐标
//                        startX = (int) event.getRawX();
                        startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //获取移动后的坐标
//                        int moveX = (int) event.getRawX();
                        int moveY = (int) event.getRawY();
                        //拿到手指移动距离的大小
//                        int move_bigX = moveX - startX;
                        int move_bigY = moveY - startY;
//                        Log.e("打印操作：", "\nX移动了" + move_bigX + "\nY移动了" + move_bigY);
                        //拿到当前控件未移动的坐标
                        int left = view.getLeft();
                        int top = view.getTop();
//                        left += move_bigX;
                        top += move_bigY;
                        int right = left + view.getWidth();
                        int bottom = top + view.getHeight();
                        view.layout(left, top, right, bottom);
//                        startX = moveX;
                        startY = moveY;
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e("打印操作：", "抬起了");
                        break;
                }
                return true;//此处一定要返回true，否则监听不生效
            }
        });
        ll_texts.addView(view);
    }

}
