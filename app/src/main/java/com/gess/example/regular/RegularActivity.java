package com.gess.example.regular;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
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

import androidx.core.content.FileProvider;

import com.gess.example.BuildConfig;
import com.gess.example.R;
import com.gess.example.bean.UserInfoBean;
import com.gess.example.fragment.DialogWindowFragment;
import com.gess.note.BaseActivity;

import java.io.File;

public class RegularActivity extends BaseActivity {

    private UserInfoBean infoBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular);
        infoBean = getData();
        textClick(infoBean.getAlias(), ((TextView) findViewById(R.id.tv_regular)));
        findViewById(R.id.btn_regular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogWindowFragment fragment = DialogWindowFragment.newInstance("","");
                fragment.show(getSupportFragmentManager(),"");
            }
        });
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File saveFile = new File("/storage/emulated/0/picwall/tmp/4f574ac8-af0a-4371-8812-5398e87cfe47.apk");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(RegularActivity.this, BuildConfig.APPLICATION_ID + ".file.PathProvider", saveFile);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                startActivity(intent);
            }
        });
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
