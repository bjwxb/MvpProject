package com.wxb.mvp.presenter.model.strategy;

import com.google.gson.Gson;
import com.wxb.app.App;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.bean.success.MallUserInfoBean;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.model.api.MallApiService;
import com.wxb.mvp.model.api.TrtApiService;
import com.wxb.mvp.sp.UserInfoUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * api策略实现-ali
 */
public class AliStrategy implements IStrategy {

    private MallApiService mallApiService;

    public AliStrategy(MallApiService mallApiService) {
        this.mallApiService = mallApiService;
    }

    @Override
    public DisposableObserver getToken(Map<String, String> map, TestRvContract.TestRvCallback callback) {
        Dlog.e("--------------- strategy -> ali api ");
        DisposableObserver<MallUserInfoBean> disposableObserver = new DisposableObserver<MallUserInfoBean>() {
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
        };

        mallApiService.getToken(map)
                .flatMap(tokenBean -> {
                    UserInfoUtils.saveTokenInfo(App.getInstance(), tokenBean);
                    return mallApiService.getUserInfo("doctor");
                })
//                .map(mallUserInfoBean -> {return parseData();})//也可以在此处转换好bean再处理
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver);

        return disposableObserver;
    }
}
