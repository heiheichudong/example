package com.gess.example.hilt;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class NetModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder().client(client).baseUrl("http://www.baidu.com").build();
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }


}
