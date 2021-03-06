package com.wxb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.ui.base.BaseFragment;

/**
 * Created by wuxiaobo on 2017/8/8.
 * 我的
 */
public class MineFragment extends BaseFragment {

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_mine;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater , container , savedInstanceState);
        init(view);
        return view;
    }

    private void init(View view) {
        Dlog.e("++++++++++++++++5");
    }
}