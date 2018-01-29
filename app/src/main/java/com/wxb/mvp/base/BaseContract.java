package com.wxb.mvp.base;

/**
 * Created by wuxiaobo on 2017/6/30.
 * contract base
 */
public interface BaseContract {

    interface BasePresenter<T>{
        void attachView(T view);
        void detachView();
    }

    interface BaseView{
        /**
         * error msg
         * @param throwable error info
         */
        void showError(Throwable throwable);
        void completed();
    }
}
