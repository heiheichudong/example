package com.gess.example.net;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.gess.example.R;
import com.gess.example.net.upload.UploadModel;
import com.gess.note.BaseActivity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NetActivity extends BaseActivity {


    public static final String TAG = "NetActivity";
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        findViewById(R.id.tv_net).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> map = new HashMap<>();
                map.put("token", "3CFF0C355D85E79BDF7990727E619422");
                map.put("timeLength", "111111");
                file = new File("/storage/emulated/0/看天下/1.m4a");

                LogUtils.d(TAG, "file--- 是否存在 = " + file.exists());
                LogUtils.d(TAG, "file--- 是否是file = " + file.isFile());
                LogUtils.d(TAG, "file--- 是否是Directory = " + file.isDirectory());

//                OkHttpUtils.postFile().file(file).url("http://www.love.tv/voice/upload.json").headers(map).build().execute(new Callback() {
//                    @Override
//                    public Object parseNetworkResponse(Response response, int id) throws Exception {
////                        ((TextView) findViewById(R.id.tv_net)).setText(response.toString());
//                        Logger.debug(TAG,response.body().toString());
//                        Logger.debug(TAG,"parseNetworkResponse" + Thread.currentThread().getName());
//                        return null;
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
////                        ((TextView) findViewById(R.id.tv_net)).setText(e.getMessage());
//                        Logger.debug(TAG,e.getMessage());
//                        Logger.debug(TAG,"onError" + Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onResponse(Object response, int id) {
////                        ((TextView) findViewById(R.id.tv_net)).setText(response.toString());
//                        try {
//                            Logger.debug(TAG,response.toString());
//                            Logger.debug(TAG,"onResponse" + Thread.currentThread().getName());
//                        }catch (Exception e){
//                            Logger.debug(TAG,"onResponse ");
//                        }
//                    }
//                });

//                OkHttpUtils.postFile().file(file).url("http://tmapi.mimi.com/upload/voice.json").headers(map).build().execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Logger.debug(TAG,e.getMessage());
//                        Logger.debug(TAG,"onError" + Thread.currentThread().getName());
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        try {
//                            Logger.debug(TAG,response);
//                            Logger.debug(TAG,"onResponse" + Thread.currentThread().getName());
//                        }catch (Exception e){
//                            Logger.debug(TAG,"onResponse ");
//                        }
//                    }
//                });


//                new Thread() {
//                    @Override
//                    public void run() {
//                        try {
//                            new UploadHelper().upload("", "", file);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }.start();


                UploadModel.uploadAudio(file,map);

            }
        });
    }
}
