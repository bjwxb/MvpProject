package com.wxb.mvp.disposable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * rxjava 订阅关系管理类-单例
 */
public class SubscriptionManager implements SubscriptionHelper<Object> {

    private CompositeDisposable mCompositeDisposable;

    private SubscriptionManager(){
        mCompositeDisposable = new CompositeDisposable();
    }

    private static final class SubscriptionManagerHolder{
        private static final SubscriptionManager INSTANCE = new SubscriptionManager();
    }

    public static SubscriptionManager getInstance(){
        return SubscriptionManagerHolder.INSTANCE;
    }

    @Override
    public void add(Disposable subscription) {
        if (null != mCompositeDisposable){
            mCompositeDisposable.add(subscription);
        }
    }

    @Override
    public void cancel(Disposable t) {
        if (null != mCompositeDisposable){
            mCompositeDisposable.delete(t);
        }
    }

    @Override
    public void cancelAll() {
        if (null != mCompositeDisposable){
            mCompositeDisposable.clear();
        }
    }
}
