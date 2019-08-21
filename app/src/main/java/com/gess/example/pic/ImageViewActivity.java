package com.gess.example.pic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.gess.example.R;
import com.gess.note.utils.Logger;

import androidx.appcompat.app.AppCompatActivity;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView = findViewById(R.id.iv_pic_act);
        String path = Environment.getExternalStorageDirectory().getPath() + "/Huawei/MagazineUnlock/aaa.jpg";
        Logger.debug("path = " + path);
        bitmap = BitmapFactory.decodeFile(path);
        imageView.setImageBitmap(bitmap);
        findViewById(R.id.btn_scale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matrix matrix = new Matrix();
                matrix.postScale(-1f, 1f,200,200);
                Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                        bitmap.getHeight(), matrix, true);
                imageView.setImageBitmap(bm);
            }
        });
    }
}
