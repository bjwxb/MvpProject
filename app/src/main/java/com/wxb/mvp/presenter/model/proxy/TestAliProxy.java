package com.wxb.mvp.presenter.model.proxy;

import com.wxb.app.utils.Dlog;
import com.wxb.mvp.contract.TestRvContract;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

//ali proxy
public class TestAliProxy implements IProxy {

    @Override
    public DisposableObserver getToken(Map<String, String> map, TestRvContract.TestRvCallback callback) {
        Dlog.e("------------------- ali proxy api");
        return null;
    }
}
