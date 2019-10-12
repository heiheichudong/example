package com.gess.example.file;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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

        /*Glide.with(this)
                .asBitmap()
                .load("http://img1.imgtn.bdimg.com/it/u=2943189637,3941537920&fm=26&gp=0.jpg")
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        ((ImageView) findViewById(R.id.iv_file)).setImageBitmap(resource);
                    }
                });*/
        Glide.with(this).load("http://pic51.nipic.com/file/20141025/8649940_220505558734_2.jpg").apply(new RequestOptions().centerCrop()).into(((ImageView) findViewById(R.id.iv_file)));
//        Glide.with(this).load(R.drawable.l0).into(((ImageView) findViewById(R.id.iv_file)));

    }
}
