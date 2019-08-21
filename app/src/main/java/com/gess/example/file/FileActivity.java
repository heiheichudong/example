package com.gess.example.file;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.gess.example.R;
import com.gess.note.utils.Logger;

import androidx.appcompat.app.AppCompatActivity;

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
                Logger.debug(MEDIA_FILE_TMP);
                Logger.debug(MEDIA_SAVE_DIR);
                file.copyFileToDir(MEDIA_FILE_TMP + "/filter.jpg", MEDIA_SAVE_DIR);
            }
        });
    }
}
