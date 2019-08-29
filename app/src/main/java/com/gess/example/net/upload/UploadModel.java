package com.gess.example.net.upload;


import com.blankj.utilcode.util.LogUtils;
import com.gess.example.bean.BaseHttpBean;
import com.gess.example.bean.VoiceBean;
import com.gess.example.net.NetActivity;
import com.gess.example.net.URL;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadModel {


    public static RequestBody getBody(File file, String mediaType, String paramKey, String fileName, MediaType type, Map<String, String> map) {
        RequestBody fileBody = RequestBody.create(MediaType.parse(mediaType), file);
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(type)
                .addFormDataPart(paramKey, fileName, fileBody)
                .build();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            LogUtils.d(NetActivity.TAG,"map = " + key);
            builder.addFormDataPart(key, map.get(key));
        }
        return builder.build();
    }

    public static RequestBody getBody(File file, Map<String, String> map) {
        return getBody(file, "audio", "voice", "voice.mp3", MultipartBody.FORM, map);
    }

    public static void uploadAudio(File file,Map<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL.BASE_URL)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(UploadAPI.class)
                .voice(getBody(file,map))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseHttpBean<VoiceBean>>() {
                    @Override
                    public void accept(BaseHttpBean<VoiceBean> result) throws Exception {
                        LogUtils.d(NetActivity.TAG,"result = " + result);
                    }
                });
    }
}
