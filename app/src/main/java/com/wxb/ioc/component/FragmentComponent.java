package com.wxb.ioc.component;

import com.wxb.ioc.scope.FragmentScope;
import com.wxb.mvp.ui.fragment.HomeFragment;
import com.wxb.mvp.ui.fragment.MallFragment;

import dagger.Subcomponent;

/**
 * Created by wuxiaobo on 2017/8/8.
 *
 */
@FragmentScope
@Subcomponent
public interface FragmentComponent {

    void inject(HomeFragment homeFragment);
    void inject(MallFragment mallFragment);
}
