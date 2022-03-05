package com.gess.example.hilt;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET
    Call<String> getHttp();
}
