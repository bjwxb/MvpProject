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
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.app.utils.ToastUtil;
import com.wxb.ioc.component.ActivityComponent;
import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.bean.TokenBean;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.presenter.TestRvPresenterImpl;
import com.wxb.mvp.ui.activity.home.adapter.TestRvAdapter;
import com.wxb.mvp.ui.base.BaseActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

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

    TextView tvTest;
    private void initRvHeader(){
        //init banner
        View banner = LayoutInflater.from(this).inflate(R.layout.header_banner, rvContent, false);
        tvTest = (TextView)banner.findViewById(R.id.tv_test);

        mAdapter.addHeaderView(banner);
    }

    @Override
    public void initData() {
        srlTest.setEnabled(true);
        srlTest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Map<String, String> map = new HashMap<>();
                map.put("grant_type", "password");
                map.put("username", "18514748006");
                map.put("password", "987654321");
                map.put("device_type", "android");
                map.put("device_token", "");
                mPresenter.getToken(map);
            }
        });
        testRx();
    }

    private void testRx(){
        final int count = 6;
        //可以延时执行任务，可以做倒计时
//        Flowable.intervalRange(0, count, 0, 1,TimeUnit.SECONDS)
//                .map(aLong -> {return count - aLong;})
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(aLong -> {tvTest.setText("Hello " + (aLong -1) + "S");})
//                .doOnComplete(()->{tvTest.setText("Hello");})
//                .subscribe();
    }

    @Override
    public void showError(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof HttpException){
            ResponseBody body = ((HttpException) throwable).response().errorBody();
            if (null != body) {
                try {
                    TokenBean bean = new Gson().fromJson(body.string(), TokenBean.class);
                    ToastUtil.showToast(this, bean.getError_description());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        srlTest.setRefreshing(false);
    }

    @Override
    public void completed() {
        srlTest.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
