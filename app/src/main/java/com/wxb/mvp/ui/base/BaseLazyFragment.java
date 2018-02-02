package com.wxb.mvp.ui.base;

/**
 * Created by wuxiaobo on 2017/8/24.
 * 懒加载 fragment
 */
public abstract class BaseLazyFragment extends BaseFragment {
    //用于标记视图是否初始化
    protected boolean isVisible;

    //在onCreate方法之前调用，用来判断Fragment的UI是否是可见的
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }
    /**
     * 视图可见
     * */
    private void onVisible(){
        lazyLoad();
    }

    /**
     * 自定义抽象加载数据方法
     * */
    protected abstract void lazyLoad();

    /**
     * 视图不可见
     * */
    protected void onInvisible(){}
}

