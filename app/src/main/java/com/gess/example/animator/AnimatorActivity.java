package com.gess.example.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gess.example.R;
import com.gess.note.utils.Logger;
import com.gess.note.utils.SizeUtils;

import androidx.appcompat.app.AppCompatActivity;

public class AnimatorActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "AnimatorActivity";
    private ImageView iv_animator;
    private ObjectAnimator animator;
    private ValueAnimator mAnimator;
    private int distance = 180;
    private int height, width;
    private float r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        findViewById(R.id.iv_bg).setOnClickListener(this);
        iv_animator = findViewById(R.id.iv_animator);

        findViewById(R.id.iv_bg).post(new Runnable() {
            @Override
            public void run() {
                height = findViewById(R.id.iv_bg).getHeight();
                Logger.debug(TAG, "height eeeeeeeeee= " + height);
                width = findViewById(R.id.iv_bg).getWidth();
                Logger.debug(TAG, "width eeeeeeeeee= " + width);
                r = (float) width / height;
                Logger.debug(TAG, "r eeeeeeeeee= " + r);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_bg:
                if (animator != null && animator.isRunning()) {
                    return;
                }
                Logger.debug(TAG, "height = " + height);
                if (animator == null) {
                    animator = ObjectAnimator.ofFloat(iv_animator, "translationY", 0, -SizeUtils.dp2px(distance));

                    mAnimator = ValueAnimator.ofInt(0, SizeUtils.dp2px(distance));
                    mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int v = (int) animation.getAnimatedValue();
                            ViewGroup.LayoutParams layoutParams = findViewById(R.id.iv_bg).getLayoutParams();
                            layoutParams.height = height - v;
                            layoutParams.width = (int) (layoutParams.height * r);
                            findViewById(R.id.iv_bg).setLayoutParams(layoutParams);
//                            findViewById(R.id.iv_bg).requestFocus();
                            if (v == SizeUtils.dp2px(distance)){
                                height = height - v;
                                Logger.debug(TAG, "addUpdateListener777      = " + height);
                            }
                        }
                    });
                } else {
                    if (animator.getRepeatMode() == ValueAnimator.RESTART) {
                        animator = null;
                        animator = ObjectAnimator.ofFloat(iv_animator, "translationY", -SizeUtils.dp2px(distance), 0);
                        animator.setRepeatMode(ValueAnimator.REVERSE);

                        mAnimator.removeAllUpdateListeners();
                        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int v = (int) animation.getAnimatedValue();
                                ViewGroup.LayoutParams layoutParams = findViewById(R.id.iv_bg).getLayoutParams();
                                layoutParams.height = height + v;
                                layoutParams.width = (int) (layoutParams.height * r);
                                findViewById(R.id.iv_bg).setLayoutParams(layoutParams);
//                                  findViewById(R.id.iv_bg).requestFocus();
//                                Logger.debug(TAG,"mAnimator height = " + (height));
//                                Logger.debug(TAG,"mAnimator v = " + (v));
//                                Logger.debug(TAG,"mAnimator = " + (height + v));
                                if (v == SizeUtils.dp2px(distance)){
                                    height = height + v;
                                    Logger.debug(TAG, "addUpdateListener      = " + height);
                                }
                            }
                        });
                    } else {
                        animator = null;
                        animator = ObjectAnimator.ofFloat(iv_animator, "translationY", 0, -SizeUtils.dp2px(distance));
                        animator.setRepeatMode(ValueAnimator.RESTART);

                        mAnimator.removeAllUpdateListeners();
                        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int v = (int) animation.getAnimatedValue();
                                ViewGroup.LayoutParams layoutParams = findViewById(R.id.iv_bg).getLayoutParams();
                                layoutParams.height = height - v;
                                layoutParams.width = (int) (layoutParams.height * r);
                                findViewById(R.id.iv_bg).setLayoutParams(layoutParams);
//                                  findViewById(R.id.iv_bg).requestFocus();
                                if (v == SizeUtils.dp2px(distance)){
                                    height = height - v;
                                    Logger.debug(TAG, "addUpdateListener8888   = " + height);
                                }
                            }
                        });
                    }
                }
                Logger.debug(TAG, "顺序 = " + animator.getRepeatMode());
                animator.setDuration(500);
                mAnimator.setDuration(500);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator).with(mAnimator);
                animatorSet.start();
//                animator.start();
//                mAnimator.start();
                break;
        }
    }
}
