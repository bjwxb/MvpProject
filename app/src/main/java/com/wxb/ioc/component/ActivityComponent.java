package com.wxb.ioc.component;

import com.wxb.ioc.scope.ActivityScope;
import com.wxb.mvp.ui.activity.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by wuxiaobo on 2017/8/4.
 * activity component
 */
@ActivityScope
@Subcomponent
public interface ActivityComponent {

    FragmentComponent fragmentComponent();

    /* login */
    void inject(LoginActivity loginActivity);
}
