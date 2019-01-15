package com.wxb.mvp.presenter;

import com.google.gson.Gson;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.base.BaseRxPresenter;
import com.wxb.mvp.bean.success.MallUserInfoBean;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.presenter.model.TestRvModelImpl;

import java.util.Map;

import javax.inject.Inject;

public class TestRvPresenterImpl extends BaseRxPresenter<TestRvContract.TestRvView>
        implements TestRvContract.TestRvPresenter<TestRvContract.TestRvView> {

//    private MallApiService mallApiService;
//
//    @Inject
//    TestRvPresenterImpl(MallApiService mallApiService) {
//        this.mallApiService = mallApiService;
//    }
    private TestRvModelImpl model;

    @Inject
    TestRvPresenterImpl(TestRvModelImpl model) {
        this.model = model;
    }

    @Override
    public void getToken(Map<String, String> map) {

        model.getToken(map, new TestRvContract.TestRvCallback() {
            @Override
            public void success(MallUserInfoBean bean) {
                Dlog.e(new Gson().toJson(bean));
            }

            @Override
            public void failed(String error) {
                Dlog.e("---------------------");
            }

            @Override
            public void complete() {
                mView.completed();
            }
        });

//        map.put("grant_type", "password");
//        map.put("username", "18514748006");
//        map.put("password", "987654321");
//        map.put("device_type", "android");
//        map.put("device_token","");
//
//        addSubscribe(mallApiService.getToken(map)
//                .flatMap(tokenBean -> {
//                    UserInfoUtils.saveTokenInfo(App.getInstance(), tokenBean);
//                    return mallApiService.getUserInfo("doctor");
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(this::parseData, mView::showError,mView::completed));
    }

    private void parseData(MallUserInfoBean tokenBean) {
        Dlog.e(new Gson().toJson(tokenBean));
    }
}
