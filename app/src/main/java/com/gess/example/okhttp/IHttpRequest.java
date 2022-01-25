package com.gess.example.okhttp;

public interface IHttpRequest {

    void setUrl(String url);

    void setData(byte[] bytes);

    void setListener(CallbackListener listener);

    void execute();
}
