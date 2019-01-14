package com.wxb.mvp.ui.activity.home.interpolator;

import android.animation.TimeInterpolator;

import com.wxb.app.utils.Dlog;

/**
 * 自定义插值器
 */
public class CustomInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        // 参数说明
        // input值值变化范围是0-1，且随着动画进度（0% - 100% ）均匀变化
        // 即动画开始时，input值 = 0；动画结束时input = 1
        // 而中间的值则是随着动画的进度（0% - 100%）在0到1之间均匀增加

        // 插值器的计算逻辑
//        return 0; // 返回的值就是用于估值器继续计算的fraction值，下面会详细说明

        float result;
        if (input <= 0.5) {//Math.sin(Math.PI/2) = 1  正弦值先快后慢
            result = (float) (Math.sin(Math.PI * input)) / 2;
            // 使用正弦函数来实现先减速后加速的功能，逻辑如下：
            // 因为正弦函数初始弧度变化值非常大，刚好和余弦函数是相反的
            // 随着弧度的增加，正弦函数的变化值也会逐渐变小，这样也就实现了减速的效果。
            // 当弧度大于π/2之后，整个过程相反了过来，现在正弦函数的弧度变化值非常小，渐渐随着弧度继续增加，变化值越来越大，弧度到π时结束，这样从0过度到π，也就实现了先减速后加速的效果
        } else {
            result = (float) (2 - Math.sin(Math.PI* input)) / 2;
        }
        return result;
        // 返回的result值 = 随着动画进度呈先减速后加速的变化趋势
    }
}
