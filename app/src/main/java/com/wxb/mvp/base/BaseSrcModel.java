package com.wxb.mvp.base;

import com.wxb.BuildConfig;

/**
 * mvp-model基类，添加方法 判断 用ali还是ibm接口
 */
public class BaseSrcModel implements BaseContract.BaseModel {

    @Override
    public boolean isAli() {
        return BuildConfig.IS_ALI;//build.gradle中配置
    }
}
