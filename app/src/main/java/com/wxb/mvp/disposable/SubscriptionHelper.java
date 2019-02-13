package com.wxb.mvp.disposable;

import io.reactivex.disposables.Disposable;

/**
 * RxJava 订阅关系管理接口
 * @param <T>
 */
public interface SubscriptionHelper<T> {
    //添加一个异步请求
    void add(Disposable subscription);

    //取消一个异步请求
    void cancel(Disposable t);

    //取消所有异步请求
    void cancelAll();
}
