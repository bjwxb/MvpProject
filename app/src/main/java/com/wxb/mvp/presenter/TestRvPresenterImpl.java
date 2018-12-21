package com.wxb.mvp.presenter;

import com.wxb.mvp.base.BaseRxPresenter;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.model.api.ApiService;

import javax.inject.Inject;

public class TestRvPresenterImpl extends BaseRxPresenter<TestRvContract.TestRvView>
        implements TestRvContract.TestRvPresenter<TestRvContract.TestRvView> {

    private ApiService mApiService;

    @Inject
    TestRvPresenterImpl(ApiService mApiService) {
        this.mApiService = mApiService;
    }

}
