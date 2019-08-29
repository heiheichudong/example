package com.gess.example.statusBar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.SizeUtils;
import com.gess.example.R;
import com.gess.example.pic.ImageViewActivity;
import com.gess.example.pic.PictureActivity;

public class StatusActivity extends AppCompatActivity {

    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        radioButton = findViewById(R.id.rb_test);
        Drawable drawable = getResources().getDrawable(R.drawable.draw_select);
        drawable.setBounds(0, 0, SizeUtils.dp2px(24), SizeUtils.dp2px(24));
        radioButton.setCompoundDrawables(null, drawable, null, null);
    }

    public void button(View v) {
        switch (v.getId()) {
            case R.id.btn_sb_color:
                startActivity(new Intent(this, ColorActivity.class));
                break;
            case R.id.btn_sb_list:
                startActivity(new Intent(this, MatchActionBarActivity.class));
                break;
            case R.id.btn_sb_match:
                startActivity(new Intent(this, SamplesListActivity.class));
                break;
            case R.id.btn_pic:
                startActivity(new Intent(this, PictureActivity.class));
                break;
            case R.id.btn_image:
                startActivity(new Intent(this, ImageViewActivity.class));
                break;
        }
    }
}
