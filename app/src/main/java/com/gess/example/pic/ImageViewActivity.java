package com.gess.example.pic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.note.BaseActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ImageViewActivity extends BaseActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private String ss = "/sdcard/Huawei/MagazineUnlock";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = findViewById(R.id.iv_pic_act);
        String path = Environment.getExternalStorageDirectory().getPath() + "/Huawei/MagazineUnlock/aaa.jpg";
        try {
            File file = new File(path);
            LogUtils.d("exists = " + file.exists());
            LogUtils.d("path = " + path);
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            imageView.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        findViewById(R.id.btn_scale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix = new Matrix();
                matrix.postScale(-1f, 1f, 200, 200);
                Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                        bitmap.getHeight(), matrix, true);
                imageView.setImageBitmap(bm);
            }
        });
    }
}
