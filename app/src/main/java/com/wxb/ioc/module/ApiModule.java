package com.wxb.ioc.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.wxb.BuildConfig;
import com.wxb.app.utils.Dlog;
import com.wxb.ioc.api.Api;
import com.wxb.ioc.api.support.HeaderInterceptor;
import com.wxb.ioc.api.support.LoggingInterceptor;
import com.wxb.mvp.model.api.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by wuxiaobo on 2018/1/26.
 * api module
 */
@Module
public class ApiModule {
    private static final int TIME_OUT = 20 * 1000;

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor());

        if (BuildConfig.DEBUG) {
            LoggingInterceptor loggingInterceptor = new LoggingInterceptor(new MyLog());
            loggingInterceptor.setLevel(LoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(new StethoInterceptor());
        }

        return builder.build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(OkHttpClient okHttpClient){
        return Api.getInstance(okHttpClient).getApiService();
    }

    public static class MyLog implements LoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Dlog.json(message);
        }
    }
}
