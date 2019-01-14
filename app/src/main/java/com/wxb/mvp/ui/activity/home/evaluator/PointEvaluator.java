package com.wxb.mvp.ui.activity.home.evaluator;

import android.animation.TypeEvaluator;

import com.wxb.mvp.ui.activity.home.bean.Point;

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startPos, Point endPos) {
        // 将动画初始值startValue 和 动画结束值endValue 强制类型转换成Point对象

        // 根据fraction来计算当前动画的x和y的值

        //计算每次更新时的x坐标
        float x = startPos.getX() + fraction * (endPos.getX() - startPos.getX());
        //将y坐标进行联动
        float y =  (float) (Math.sin(x * Math.PI / 180) * 300);
//        float y = (float) endPos.getY() + fraction * endPos.getY()*3;
        // 将计算后的坐标封装到一个新的Point对象中并返回
        return new Point(x, y);
    }
}
