package com.wxb.mvp.ui.activity.home.evaluator;

import android.animation.TypeEvaluator;

/**
 * 自定义估值器
 */
public class CustomEvaluator implements TypeEvaluator {
    /**
     * @param fraction 表示动画完成度（根据它来计算当前动画的值）
     * @param startValue 动画的初始值
     * @param endValue 动画的结束值
     * @return
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        return null;
    }
}
