package com.wxb.mvp.ui.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.wxb.R;
import com.wxb.app.App;
import com.wxb.ioc.component.ActivityComponent;
import com.wxb.ioc.component.AppComponent;
import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.view.StatusBarUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wuxiaobo on 2018/1/26.
 * activity 基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected AppComponent mAppComponent;
    protected ActivityComponent mActivityComponent;
    protected Unbinder mUnbinder;//注解

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//setting orientation
        setStatusBar();
        initButterknife();
        initComponent();
        initPresenter();

        initViews();
        initData();
    }

    protected void setStatusBar() {
        //StatusBarUtil.setTranslucent(this, 0);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void initViews();

    public abstract void initData();


    //注解初始化
    private void initButterknife() {
        mUnbinder = ButterKnife.bind(this);
    }

    //init component
    private void initComponent() {
        mAppComponent = App.getInstance().getAppComponent();
        mActivityComponent = mAppComponent.getActivityComponent();
//        mApi = mAppComponent.getApi();
//        mApiService = mApi.getApiService();
//        setupActivityComponent(mAppComponent);
        setupActivityComponent(mActivityComponent);
    }

    //set presenter
    private void initPresenter() {
        BaseContract.BasePresenter presenter = getPresenter();
        if (getPresenter() != null) {
            presenter.attachView(this);
        }
    }

//    protected void setupActivityComponent(AppComponent appComponent) {
//    }

    public int getLayoutId() {
        return -1;
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    protected void setupActivityComponent(ActivityComponent activityComponent) {
    }

    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return null;
    }

    /**
     * 直接跳转到另一个Activity界面
     *
     * @param classObj ***Activity.class
     */
    public void overlay(Class<?> classObj) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(this, classObj);
        startActivity(intent);
    }

    /**
     * 直接跳转到另一个Activity，并带有bundle参数
     *
     * @param classObj cls
     * @param params   bundle
     */
    public void overlay(Class<?> classObj, Bundle params) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(this, classObj);
        intent.putExtras(params);
        startActivity(intent);
    }

    /**
     * 以satartActivityForResult方式启动另一个Activity
     *
     * @param classObj    class对象
     * @param params      bundle参数
     * @param requestCode 请求码
     */
    public void overlay(Class<?> classObj, Bundle params, int requestCode) {
        Intent intent = new Intent(this, classObj);
        intent.putExtras(params);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 以satartActivityForResult方式启动另一个Activity
     *
     * @param classObj    class对象
     * @param requestCode 请求码
     */
    public void overlay(Class<?> classObj, int requestCode) {
        Intent intent = new Intent(this, classObj);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 启动另一个Activity，并结束当前Activity
     *
     * @param classObj class对象
     */
    public void forward(Class<?> classObj) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
        this.finish();
    }

    /**
     * 启动另一个Activity，带有bundle参数，并结束当前Activity
     *
     * @param classObj class对象
     * @param params   bundle参数
     */
    public void forward(Class<?> classObj, Bundle params) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(params);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
}
