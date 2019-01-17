package com.wxb.mvp.presenter.model.strategy;

import com.wxb.app.utils.Dlog;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.model.api.MallApiService;
import com.wxb.mvp.model.api.TrtApiService;

import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * api策略实现-IBM
 */
public class IBMStrategy implements IStrategy {

    private TrtApiService trtApiService;

    public IBMStrategy(TrtApiService trtApiService) {
        this.trtApiService = trtApiService;
    }
    @Override
    public DisposableObserver getToken(Map<String, String> map, TestRvContract.TestRvCallback callback) {
        Dlog.e("========== strategy -> ibm api ===========");
        return null;
    }
}
