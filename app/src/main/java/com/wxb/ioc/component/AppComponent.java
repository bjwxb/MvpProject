package com.wxb.ioc.component;

import com.wxb.ioc.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wuxiaobo on 2017/8/4.
 * component
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {
    ActivityComponent getActivityComponent();
}
