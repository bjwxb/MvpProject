package com.wxb.mvp.ui.activity;

import android.os.Handler;
import android.view.KeyEvent;

import com.wxb.MainActivity;
import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.app.utils.ToastUtil;
import com.wxb.mvp.ui.activity.login.LoginActivity;
import com.wxb.mvp.ui.base.BaseActivity;
import com.wxb.mvp.view.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends BaseActivity {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_splash;
//    }


    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucent(this, 0);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        startByTime();
    }

    /**
     * 延迟2秒启动主Activity
     */

    private void startByTime() {
//        countdownTest();
        final int count = 3;
        //可以延时执行任务，可以做倒计时
        Disposable disposable = Flowable.intervalRange(0, count, 0, 1,TimeUnit.SECONDS)
                .map(aLong -> {return count - aLong;})
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(aLong -> {Dlog.e(">>>>>>>>>> countdown is " + (aLong));})
                .doOnComplete(this::jump2login)
                .subscribe();

        mCompositeDisposable.add(disposable);
    }

    private void countdownTest(){
        //interval 是会无限发送事件的。第一个参数开始的延时事件，二个参数为时间间隔，三个时间间隔单元（单位）
        Observable.interval(0,1, TimeUnit.SECONDS)
                //因为interval是无限发送的，所以使用take操作符，只会发送10个数据
                .take(5)
                //因为interval发送是从0开始的，而我们要使用的是10 - value 所以用map做一下转换
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long value) throws Exception {
                        Dlog.e(">>>>>>>>>> countdown is " + (value));
                        return 10 - value;
                    }
                })
                //这个操作是一个耗时操作不能在主线程中执行，就切换到其他线程
                .subscribeOn(Schedulers.io())
                //得到数据切换到主线程，做改变页面的显示操作
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Dlog.e("================= set textView value " + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Dlog.e("------------- complete");
                    }
                });
    }

    //jump to login
    private void jump2login() {
        forward(MainActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK;
    }
}
