package com.wxb.mvp.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.ioc.component.ActivityComponent;
import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.presenter.TestRvPresenterImpl;
import com.wxb.mvp.ui.activity.home.adapter.TestRvAdapter;
import com.wxb.mvp.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

//test recyclerview 下拉刷新和上拉加载
public class TestRecyclerViewActivity extends BaseActivity implements TestRvContract.TestRvView {

    @Inject
    TestRvPresenterImpl mPresenter;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.srl_test)
    SwipeRefreshLayout srlTest;


    private TestRvAdapter mAdapter;
    private List<String> mList = new ArrayList<>();

    //start this activity
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, TestRecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_recycler_view;
    }

    @Override
    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return mPresenter;
    }

    @Override
    protected void setupActivityComponent(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void initViews() {
        for (int i=0; i<15; i++){
            mList.add("index + " + i);
        }
        mAdapter = new TestRvAdapter(mList);

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mAdapter.loadMoreComplete();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.loadMoreEnd();
                    }
                },2000);
            }
        }, rvContent);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvContent.setLayoutManager(manager);
        rvContent.setAdapter(mAdapter);
        initRvHeader();
    }

    private void initRvHeader(){
        //init banner
        View banner = LayoutInflater.from(this).inflate(R.layout.header_banner, rvContent, false);

        mAdapter.addHeaderView(banner);
    }

    @Override
    public void initData() {
        srlTest.setEnabled(true);
        srlTest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srlTest.setEnabled(false);
                    }
                },2000);
            }
        });
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void completed() {

    }
}
