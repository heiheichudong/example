package com.gess.example.property;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ScreenUtils;
import com.gess.example.R;

import org.jetbrains.annotations.NotNull;

public class ViewPropertyActivity extends AppCompatActivity {

    private RelativeLayout rlRoot;
    private TextView tvRootCon;
    private RelativeLayout llOut;
    private TextView tvOutCon;
    private LinearLayout llInCon;
    private TextView tvInCon;
    private TextView tv_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
//        layoutParams.width = 1000;
//        layoutParams.height = 2000;
//        layoutParams.alpha = 0.3f;
        getWindow().setAttributes(layoutParams);
//        getWindow().getDecorView().setAlpha(0.3f);
        rlRoot = findViewById(R.id.rl_root);
        tvRootCon = findViewById(R.id.tv_root_con);
        llOut = findViewById(R.id.ll_out);
        tvOutCon = findViewById(R.id.tv_out_con);
        llInCon = findViewById(R.id.ll_in_con);
        tvInCon = findViewById(R.id.tv_in_con);
        tv_screen = findViewById(R.id.tv_screen);

        tv_screen.setText(getScreen());

        tvInCon.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvRootCon.setText(getViewProperty(rlRoot));
                tvOutCon.setText(getViewProperty(llOut));
                tvInCon.setText(getViewProperty(llInCon));
            }
        }, 1000);
    }

    @NotNull
    private String getScreen() {
        StringBuffer sb = new StringBuffer();
        sb.append("ScreenW = " + ScreenUtils.getScreenWidth());
        sb.append("\nScreenH = " + ScreenUtils.getScreenHeight());
        sb.append("\nAppScrW = " + ScreenUtils.getAppScreenWidth());
        sb.append("\nAppScrH = " + ScreenUtils.getAppScreenHeight());
        sb.append("\nWindow = " + getWindow().getAttributes().width);
        sb.append("\nWindow = " + getWindow().getAttributes().height);
        return sb.toString();
    }

    private String getViewProperty(View view) {
        StringBuffer sb = new StringBuffer();
        sb.append("top = " + view.getTop());
        sb.append("\nbottom = " + view.getBottom());
        sb.append("\nleft = " + view.getLeft());
        sb.append("\nright = " + view.getRight());
        int[] screen = new int[2];
        view.getLocationOnScreen(screen);
        sb.append("\nScreen[0] = " + screen[0]);
        sb.append("\nScreen[1] = " + screen[1]);
        int[] window = new int[2];
        view.getLocationInWindow(window);
        sb.append("\nWindow[0] = " + window[0]);
        sb.append("\nWindow[1] = " + window[1]);
        return sb.toString();
    }
}
