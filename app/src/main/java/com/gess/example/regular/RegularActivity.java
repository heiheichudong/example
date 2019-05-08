package com.gess.example.regular;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gess.example.R;
import com.gess.example.bean.UserInfoBean;

import androidx.appcompat.app.AppCompatActivity;

public class RegularActivity extends AppCompatActivity {

    private UserInfoBean infoBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        infoBean = getData();
        textClick(infoBean.getAlias(), ((TextView) findViewById(R.id.tv_regular)));
    }

    public UserInfoBean getData(){
        UserInfoBean user = new UserInfoBean();
        user.setAlias("@昵称&123456");
        user.setName("用户名");
        user.setUserId(001);
        return user;
    }

    /**
     * 设置点击
     */
    private void textClick(String string, TextView textView) {
        final String[] str = string.split("&");//假装正则
        textView.setText(str[0]);
        SpannableStringBuilder stringBuilder = ((SpannableStringBuilder) textView.getText());
        stringBuilder.setSpan(new ForegroundColorSpan(Color.BLUE), 0, str[0].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(new StyleSpan(Typeface.BOLD), 0, str[0].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(new BackgroundColorSpan(Color.TRANSPARENT), 0, str[0].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringBuilder.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegularActivity.this,str[1],Toast.LENGTH_LONG).show();
            }
        }, 0, str[0].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(stringBuilder);
    }
}
