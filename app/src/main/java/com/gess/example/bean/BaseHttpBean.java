package com.gess.example.bean;

public class BaseHttpBean<T> {

    /**
     * code : 200
     * msg : success
     * key : null
     * data : {"voiceId":"51410af8e70740e2a48b2cbe9c6e36f2","path":"2019/7/20/15/51410af8e70740e2a48b2cbe9c6e36f2.mp3","timeLength":12,"ipfsHash":null,"ipfshost":null}
     */

    private int code;
    private String msg;
    private String key;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
