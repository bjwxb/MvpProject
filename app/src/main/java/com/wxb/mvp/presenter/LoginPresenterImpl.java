package com.wxb.mvp.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.wxb.app.common.Constants;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.base.BaseRxPresenter;
import com.wxb.mvp.bean.LoginBean;
import com.wxb.mvp.bean.LoginBean2;
import com.wxb.mvp.bean.success.SucLoginBean;
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
    private Context context;

    @Inject
    LoginPresenterImpl(Context context, ApiService mApiService) {
        this.mApiService = mApiService;
        this.context = context;
    }

    @Override
    public void login(Map<String, String> map) {
        addSubscribe(mApiService.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::parseData, mView::showError, mView::completed));
    }

    private void parseData(SucLoginBean loginBean) {
        Gson gson = new Gson();
        int code = loginBean.getCode();
        if (code == Constants.SUCCESS) {
            mView.loginSuccess2(loginBean.getDatas());
        } else if(code == 400){
            mView.loginError(loginBean.getError());
        }
    }
}
