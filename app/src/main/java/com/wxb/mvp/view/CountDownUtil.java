package com.wxb.mvp.view;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by wuxiaobo on 2017/8/24.
 * 取消拜师 倒计时
 */
public class CountDownUtil extends CountDownTimer {
    private TextView tv;//
    private boolean isYzmCode = false;//验证码倒计时

    /**
     * @param millisInFuture    倒计时时间
     * @param countDownInterval 间隔
     * @param tv                控件
     *                          ex:60000,1000-->60s
     */
    public CountDownUtil(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tv = tv;
        isYzmCode = false;
    }

    public CountDownUtil(long millisInFuture, long countDownInterval, TextView tv, boolean isYzmCode) {
        super(millisInFuture, countDownInterval);
        this.tv = tv;
        this.isYzmCode = isYzmCode;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //这里接收的是毫秒值,当然,我们要将他格式化一下
        String content = "倒计时 " + (millisUntilFinished / 1000) + " 秒";
        tv.setClickable(false);
        tv.setText(content);//设置时间
    }

    @Override
    public void onFinish() {
        if (isYzmCode) {
            tv.setText("重新获取");
            tv.setClickable(true);//重新获得点击
        }
    }
}
