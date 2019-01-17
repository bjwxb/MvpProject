package com.wxb.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.ui.base.BaseFragment;
import com.wxb.mvp.view.StatusBarUtil;

/**
 * Created by wuxiaobo on 2017/8/8.
 * 加入我们
 */
public class JoinUsFragment extends BaseFragment {

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_join_us;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater , container , savedInstanceState);
        init(view);
        return view;
    }

    private void init(View view) {
        Dlog.e("++++++++++++++++3");
    }
}