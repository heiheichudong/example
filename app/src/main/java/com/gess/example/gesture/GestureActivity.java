package com.gess.example.gesture;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.gess.example.R;
import com.gess.note.utils.LogUtils;

import androidx.appcompat.app.AppCompatActivity;

public class GestureActivity extends AppCompatActivity {

    public static String TAG = "GestureActivity";
    private GestureFrameLayout mFrameLayout;
    private GestureDetector mGestureDetector;
    private MyGestureListener mGestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        mFrameLayout = findViewById(R.id.fl_gesture);
        mGestureListener = new MyGestureListener();
        mGestureDetector = new GestureDetector(this, mGestureListener);

        mFrameLayout.setGestureDetector(mGestureDetector);

        L l = new L();
        mFrameLayout.setOnClickListener(l);
        findViewById(R.id.fl_gesture2).setOnClickListener(l);
    }

    class L implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            LogUtils.d("11233" + v.getId());
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return mGestureDetector.onTouchEvent(event);
//    }

    class MyGestureListener implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            motionEvent.getX(0);
            LogUtils.d(TAG, "onDown:按下");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            LogUtils.d(TAG, "onShowPress:手指按下一段时间,不过还没到长按");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            LogUtils.d(TAG, "onSingleTapUp:手指离开屏幕的一瞬间");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            LogUtils.d(TAG, "onScroll:在触摸屏上滑动");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            LogUtils.d(TAG, "onLongPress:长按并且没有松开");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            LogUtils.d(TAG, "onFling:迅速滑动，并松开");
            return false;
        }
    }
}
