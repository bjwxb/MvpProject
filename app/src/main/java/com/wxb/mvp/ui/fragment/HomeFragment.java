package com.wxb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.ui.activity.TestCodeActivity;
import com.wxb.mvp.ui.base.BaseFragment;
import com.wxb.mvp.view.ObservableScrollView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wuxiaobo on 2017/8/8.
 * 首页
 */
public class HomeFragment extends BaseFragment implements ObservableScrollView.ScrollViewListener {

    @BindView(R.id.fake_statusbar_view)
    View fakeStatusbarView;
    @BindView(R.id.iv_banner)
    ImageView ivBanner;
    @BindView(R.id.scroll_view)
    ObservableScrollView scrollView;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        //fakeStatusbarView.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red));
        fakeStatusbarView.setVisibility(View.GONE);
    }

    private void init(View view) {
        scrollView.setScrollViewListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_10, R.id.btn_11, R.id.btn_12})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                overlay(TestCodeActivity.class);
                break;
            case R.id.btn_2:
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                break;
            case R.id.btn_5:
                break;
            case R.id.btn_6:
                break;
            case R.id.btn_7:
                break;
            case R.id.btn_8:
                break;
            case R.id.btn_9:
                break;
            case R.id.btn_10:
                break;
            case R.id.btn_11:
                break;
            case R.id.btn_12:
                break;
        }
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        Dlog.e("********** y = " + y + " , oldy = " + oldy);
    }
}
