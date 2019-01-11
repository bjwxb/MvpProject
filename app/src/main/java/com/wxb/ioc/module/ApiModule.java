package com.wxb.ioc.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jiongbull.jlog.JLog;
import com.wxb.BuildConfig;
import com.wxb.app.utils.Dlog;
import com.wxb.ioc.api.Api;
import com.wxb.ioc.api.support.HeaderInterceptor;
import com.wxb.ioc.api.support.LoggingInterceptor;
import com.wxb.mvp.model.api.ApiService;
import com.wxb.mvp.model.api.MallApiService;
import com.wxb.mvp.model.api.TrtApiService;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
            LoggingInterceptor loggingInterceptor = new LoggingInterceptor("OkHttp");
            loggingInterceptor.setLevel(LoggingInterceptor.Level.BODY);
            //log颜色级别，决定了log在控制台显示的颜色
            loggingInterceptor.setColorLevel(Level.WARNING);
            builder.addInterceptor(loggingInterceptor)
                    .addNetworkInterceptor(new StethoInterceptor());
        }

        return builder.build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(OkHttpClient okHttpClient){
        return Api.getInstance().getApiService(okHttpClient);
    }

    @Singleton
    @Provides
    MallApiService provideMallApiService(OkHttpClient okHttpClient){
        return Api.getInstance().getMallApiService(okHttpClient);
    }

    @Singleton
    @Provides
    TrtApiService provideTrtApiService(OkHttpClient okHttpClient){
        return Api.getInstance().getTrtService(okHttpClient);
    }
}
