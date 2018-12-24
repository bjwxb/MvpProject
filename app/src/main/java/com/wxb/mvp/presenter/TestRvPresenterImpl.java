package com.wxb.mvp.presenter;

import com.google.gson.Gson;
import com.wxb.app.App;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.base.BaseRxPresenter;
import com.wxb.mvp.bean.success.MallUserInfoBean;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.model.api.MallApiService;
import com.wxb.mvp.sp.UserInfoUtils;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TestRvPresenterImpl extends BaseRxPresenter<TestRvContract.TestRvView>
        implements TestRvContract.TestRvPresenter<TestRvContract.TestRvView> {

    private MallApiService mallApiService;

    @Inject
    TestRvPresenterImpl(MallApiService mallApiService) {
        this.mallApiService = mallApiService;
    }

    @Override
    public void getToken(Map<String, String> map) {
        map.put("grant_type", "password");
        map.put("username", "18514748006");
        map.put("password", "987654321");
        map.put("device_type", "android");
        map.put("device_token","");

        addSubscribe(mallApiService.getToken(map)
                .flatMap(tokenBean -> {
                    UserInfoUtils.saveTokenInfo(App.getInstance(), tokenBean);
                    return mallApiService.getUserInfo();
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::parseData, mView::showError,mView::completed));
    }

    private void parseData(MallUserInfoBean tokenBean) {
        Dlog.e(new Gson().toJson(tokenBean));
    }
}
