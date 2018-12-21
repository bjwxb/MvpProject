package com.wxb.mvp.ui.activity.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wxb.R;

import java.util.List;

public class TestRvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public TestRvAdapter(@Nullable List<String> data) {
        super(R.layout.rv_item_test_rv, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_content, item);
    }
}
