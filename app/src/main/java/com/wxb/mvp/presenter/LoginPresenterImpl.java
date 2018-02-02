package com.wxb.mvp.presenter;

import com.google.gson.Gson;
import com.wxb.app.common.Constants;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.base.BaseRxPresenter;
import com.wxb.mvp.bean.LoginBean;
import com.wxb.mvp.contract.LoginContract;
import com.wxb.mvp.model.api.ApiService;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wuxiaobo on 2018/1/26.
 * login p
 */
public class LoginPresenterImpl extends BaseRxPresenter<LoginContract.LoginView>
        implements LoginContract.LoginPresenter<LoginContract.LoginView> {

    private ApiService mApiService;

    @Inject
    LoginPresenterImpl(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public void login(Map<String, String> map) {
        addSubscribe(mApiService.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::parseData, mView::showError, mView::completed));
    }

    private void parseData(LoginBean loginBean) {
        Gson gson = new Gson();
        int code = loginBean.getCode();
        if (code == Constants.SUCCESS) {
            mView.loginSuccess(loginBean.getDatas());
        } else if(code == 400){
            mView.loginError(loginBean.getError());
        }
    }
}