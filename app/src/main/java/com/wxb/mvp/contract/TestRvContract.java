package com.wxb.mvp.contract;

import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.bean.TokenBean;
import com.wxb.mvp.bean.success.MallUserInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class TestRvContract {

    public interface TestRvView extends BaseContract.BaseView{

    }

    public interface TestRvPresenter<T> extends BaseContract.BasePresenter<T>{
        void getToken(Map<String, String> map);
    }

    public interface TestRvModel{
        DisposableObserver getToken(Map<String, String> map, TestRvCallback callback);
    }

    public interface TestRvCallback{
        void success(MallUserInfoBean bean);

        void failed(String error);

        void complete();
    }


}
