package com.gess.example.file;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.gess.example.R;

public class FileActivity extends AppCompatActivity {

    public static final String MEDIA_FILE_TMP = Environment.getExternalStorageDirectory().getAbsolutePath() + "/picwall/tmp";      //存储临时文件
    public static final String MEDIA_SAVE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/mimi";              //保存用户文件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        findViewById(R.id.tv_file_copy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.d(MEDIA_FILE_TMP);
                LogUtils.d(MEDIA_SAVE_DIR);
                file.copyFileToDir(MEDIA_FILE_TMP + "/filter.jpg", MEDIA_SAVE_DIR);
            }
        });

        Glide.with(this)
                .asBitmap()
                .load("http://mimg.com.tv/img/2019/8/17/418226540F7EA75F13061F370A6DD17277C65738347E4FC797DCF52B8970F9D1")
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        ((ImageView) findViewById(R.id.iv_file)).setImageBitmap(resource);
                    }
                });

    }
}
