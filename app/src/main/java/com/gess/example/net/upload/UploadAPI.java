package com.gess.example.net.upload;

import com.gess.example.bean.BaseHttpBean;
import com.gess.example.bean.VoiceBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UploadAPI {


    @POST("/upload/voice.json")
    Observable<BaseHttpBean<VoiceBean>> voice(@Body()RequestBody voice);
}
