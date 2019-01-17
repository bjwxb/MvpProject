package com.wxb.mvp.presenter.model.proxy;

import com.wxb.app.utils.Dlog;
import com.wxb.mvp.contract.TestRvContract;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

//ibm proxy
public class TestIbmProxy implements IProxy {

    @Override
    public DisposableObserver getToken(Map<String, String> map, TestRvContract.TestRvCallback callback) {
        Dlog.e("*************** ibm proxy api");
        return null;
    }
}
