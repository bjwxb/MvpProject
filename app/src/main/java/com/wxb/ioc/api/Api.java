package com.wxb.ioc.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wxb.app.common.URLConfig;
import com.wxb.mvp.model.api.ApiService;
import com.wxb.mvp.model.api.MallApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private Api() {
    }

    private static class ApiHolder{
        private static Api instance = new Api();
    }

    public static Api getInstance() {
        return ApiHolder.instance;
    }

    public ApiService getApiService(OkHttpClient okHttpClient) {
        Retrofit retrofit = getRetrofit(okHttpClient, URLConfig.BASE_URL);
        return retrofit.create(ApiService.class);
    }

    public MallApiService getMallApiService(OkHttpClient okHttpClient){
        Retrofit retrofit = getRetrofit(okHttpClient, URLConfig.MALL_BASE_URL);
        return retrofit.create(MallApiService.class);
    }

    private Retrofit getRetrofit(OkHttpClient okHttpClient, String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create(/*gson*/)) // 添加Gson转换器
                .client(okHttpClient)
                .build();
    }
}
