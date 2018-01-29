package com.wxb.ioc.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wuxiaobo on 2018/1/26.
 * app module
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
