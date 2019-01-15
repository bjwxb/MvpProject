package com.wxb.mvp.base;

import com.wxb.BuildConfig;

public class BaseSrcModel implements BaseContract.BaseModel {

    @Override
    public boolean isAli() {
        return BuildConfig.IS_ALI;
    }
}
