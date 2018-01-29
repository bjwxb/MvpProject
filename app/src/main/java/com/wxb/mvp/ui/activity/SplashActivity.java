package com.wxb.mvp.ui.activity;

import android.os.Handler;
import android.view.KeyEvent;

import com.wxb.R;
import com.wxb.mvp.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    private static final long DELAY_TIME = 2000;//启动延迟时间

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
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
        new Handler().postDelayed(this::jump2login, DELAY_TIME);
    }

    //jump to login
    private void jump2login() {
        forward(LoginActivity.class);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK;
    }
}
