package com.gess.example.video;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.gess.example.R;

import androidx.appcompat.app.AppCompatActivity;
import jp.co.cyberagent.android.gpuimage.GPUImageView;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageLookupFilter;

public class GPUImageActivity extends AppCompatActivity {

    private String path = "/storage/emulated/0/cache/c668943a-57ac-4e21-9a06-65152a698065.jpg";
    private GPUImageView imageView;
    private GPUImageLookupFilter mFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpuimage);
        imageView = findViewById(R.id.gpuimage);
        imageView.setImage(Uri.parse("file://" + path));
    }

    public void gpu(View view) {
        switch (view.getId()) {
            case R.id.btn_gpu:
                mFilter = new GPUImageLookupFilter();
                mFilter.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.l1));
                imageView.setFilter(mFilter);
                break;
            case R.id.btn_gpu_sw:
                mFilter = new GPUImageLookupFilter();
                mFilter.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.l3));
                imageView.setFilter(mFilter);
                break;
            case R.id.btn_gpu_clear:
                mFilter = new GPUImageLookupFilter();
                mFilter.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.l0));
                imageView.setFilter(mFilter);
                break;
        }
    }

}
