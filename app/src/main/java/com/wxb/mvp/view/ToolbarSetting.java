package com.wxb.mvp.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxb.R;

/**
 * Created by wuxiaobo on 2017/7/18.
 * custom toolbar
 */
public class ToolbarSetting {
    //标题，左边内容，右边内容
    private TextView tvTitle, tvLeft, tvRight;
    private LinearLayout llLeft, llRight;

    //两边内容是否显示
    private boolean mLeftShow = false;
    private boolean mRightshow = false;

    /**
     * 初始化View
     *
     */
    public ToolbarSetting(ViewGroup group) {
        if (group != null) {
            llLeft = (LinearLayout) group.findViewById(R.id.ll_left);
            llRight = (LinearLayout) group.findViewById(R.id.ll_right);
            tvTitle = (TextView) group.findViewById(R.id.tv_title);
            tvLeft = (TextView) group.findViewById(R.id.tv_left);
            tvRight = (TextView) group.findViewById(R.id.tv_right);
            tvTitle.setText("");
            tvLeft.setText("");
            tvRight.setText("");
        }
    }

    /**
     * 设置标题
     *
     * @param title title
     */
    public ToolbarSetting setTitle(String title) {
        if (title != null) {
            tvTitle.setText(title);
        }
        return this;
    }

    /**
     * 左边是否显示，默认不显示
     *
     * @param leftShow boolean
     */
    public ToolbarSetting isLeftShow(boolean leftShow) {
        mLeftShow = leftShow;
        if (leftShow) {
            llLeft.setVisibility(View.VISIBLE);
        } else {
            llLeft.setVisibility(View.GONE);
        }
        return this;
    }

    /**
     * 右边是否显示，默认不显示
     */
    public ToolbarSetting isRightShow(boolean rightShow) {
        mRightshow = rightShow;
        if (rightShow) {
            llRight.setVisibility(View.VISIBLE);
        } else {
            llRight.setVisibility(View.INVISIBLE);
        }
        return this;
    }

    /**
     * 设置左边的文字
     */
    public ToolbarSetting setLeftText(String leftText) {
        if (leftText != null) {
            tvLeft.setText(leftText);
        }
        return this;
    }

    /**
     * 设置右边的文字
     */
    public ToolbarSetting setRightText(String rightText) {
        if (rightText != null) {
            tvRight.setText(rightText);
        }
        return this;
    }

    /**
     * 设置左边的图片
     */
    public ToolbarSetting setLeftImage(int leftImage) {
        if (leftImage != 0) {
            tvLeft.setBackgroundResource(leftImage);
        }
        return this;
    }

    /**
     * 设置右边的图片
     */
    public ToolbarSetting setRightImage(int rightImage) {
        if (rightImage != 0) {
            tvRight.setBackgroundResource(rightImage);
        }
        return this;
    }

    /**
     * 设置左边的监听
     */
    public ToolbarSetting setLeftClick(View.OnClickListener leftClick) {
        if (mLeftShow)
            llLeft.setOnClickListener(leftClick);
        return this;
    }

    /**
     * 设置右边的监听
     */
    public ToolbarSetting setRightClick(View.OnClickListener rightClick) {
        if (mRightshow)
            llRight.setOnClickListener(rightClick);
        return this;
    }
}
