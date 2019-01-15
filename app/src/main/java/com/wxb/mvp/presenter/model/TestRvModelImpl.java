package com.wxb.mvp.presenter.model;

import com.google.gson.Gson;
import com.wxb.app.App;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.base.BaseSrcModel;
import com.wxb.mvp.bean.TokenBean;
import com.wxb.mvp.bean.success.MallUserInfoBean;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.model.api.MallApiService;
import com.wxb.mvp.model.api.TrtApiService;
import com.wxb.mvp.sp.UserInfoUtils;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TestRvModelImpl extends BaseSrcModel implements TestRvContract.TestRvModel {

    private MallApiService mallApiService;
    private TrtApiService trtApiService;

    @Inject
    TestRvModelImpl(MallApiService mallApiService, TrtApiService trtApiService) {
        this.mallApiService = mallApiService;
        this.trtApiService = trtApiService;
    }

    @Override
    public void getToken(Map<String, String> map, TestRvContract.TestRvCallback callback) {
        if (isAli()) {
            fromAli(callback);
        } else {
            fromIbm(callback);
        }
    }

    private void fromAli(TestRvContract.TestRvCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "password");
        map.put("username", "18514748006");
        map.put("password", "987654321");
        map.put("device_type", "android");
        map.put("device_token", "");

        mallApiService.getToken(map)
                .flatMap(tokenBean -> {
                    UserInfoUtils.saveTokenInfo(App.getInstance(), tokenBean);
                    return mallApiService.getUserInfo("doctor");
                })
//                .map(mallUserInfoBean -> {return parseData();})//也可以在此处转换好bean再处理
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MallUserInfoBean>() {
                    @Override
                    public void onNext(MallUserInfoBean mallUserInfoBean) {
                        Dlog.e(new Gson().toJson(mallUserInfoBean));
                        //mallUserInfo ----> 可以转换为需要的bean再给callback
                        callback.success(mallUserInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        callback.failed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        callback.complete();
                        Dlog.e("--------------------onComplete");
                    }
                });
    }

    private TokenBean parseData(){
        return new TokenBean();
    }
    private void fromIbm(TestRvContract.TestRvCallback callback) {
        Dlog.e("***************** api ibm *************");
//        trtApiService.upload()
    }

}
