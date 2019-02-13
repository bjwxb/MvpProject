package com.wxb.mvp.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wxb.app.utils.Dlog;
import com.wxb.ioc.component.FragmentComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wuxiaobo on 2017/6/30.
 * fragment 基类
 */
public abstract class BaseFragment extends Fragment {

    @LayoutRes
    public abstract int getLayoutResId();

    protected View parentView;
    protected LayoutInflater inflater;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        setupFragmentComponent(((BaseActivity) getActivity()).getActivityComponent().fragmentComponent());
        this.inflater = inflater;
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
    }

    protected void setupFragmentComponent(FragmentComponent fragmentComponent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 直接跳转到另一个Activity界面
     *
     * @param classObj ***Activity.class
     */
    public void overlay(Class<?> classObj) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setClass(getActivity(), classObj);
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
        intent.setClass(getActivity(), classObj);
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
        Intent intent = new Intent(getActivity(), classObj);
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
        Intent intent = new Intent(getActivity(), classObj);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 启动另一个Activity，并结束当前Activity
     *
     * @param classObj class对象
     */
    public void forward(Class<?> classObj) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * 启动另一个Activity，带有bundle参数，并结束当前Activity
     *
     * @param classObj class对象
     * @param params   bundle参数
     */
    public void forward(Class<?> classObj, Bundle params) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(params);
        startActivity(intent);
        getActivity().finish();
    }

}
