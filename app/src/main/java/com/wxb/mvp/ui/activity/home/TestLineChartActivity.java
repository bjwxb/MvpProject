package com.wxb.mvp.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.ui.base.BaseActivity;
import com.wxb.mvp.view.ToolbarSetting;
import com.wxb.mvp.view.chart.MyLineChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestLineChartActivity extends BaseActivity {

    @BindView(R.id.ll_group)
    LinearLayout llGroup;
    @BindView(R.id.line_chart)
    MyLineChartView lineChart;

    //start this activity
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, TestLineChartActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_line_chart;
    }


    @Override
    public void initViews() {
        initToolBar();
        setSwipeBackEnable(false);
    }

    /**
     * init toolbar
     */
    private void initToolBar() {
        ToolbarSetting mToolbarSetting = new ToolbarSetting(llGroup);
        mToolbarSetting.setTitle("自定义图表")
                .setLeftImage(R.mipmap.ic_back_white)
                .isLeftShow(true)
                .setLeftClick(v -> {
                    finish();
                })
                .isRightShow(false);
    }

    @Override
    public void initData() {

        List<String> xValues = new ArrayList<>();
        List<Integer> yValues = new ArrayList<>();
        xValues.add("02-26");
        xValues.add("02-27");
        xValues.add("02-28");
        xValues.add("03-01");

        for (int i = 0; i < 80; i++) {
            xValues.add("02-26");
            yValues.add((int) (Math.random() * 20));
        }
        // xy轴集合自己添加数据
        lineChart.setXValues(xValues);
        lineChart.setYValues(yValues);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //land
            Dlog.e("================= 横屏 ==================");
        }
        else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //port
            Dlog.e("------------------ 竖屏 ------------------");
        }
    }

    @OnClick(R.id.tv_switch)
    public void onViewClicked() {

        if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
             setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
