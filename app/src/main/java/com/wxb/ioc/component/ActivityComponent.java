package com.wxb.ioc.component;

import com.wxb.ioc.scope.ActivityScope;
import com.wxb.mvp.ui.activity.home.TestAnimActivity;
import com.wxb.mvp.ui.activity.home.TestRecyclerViewActivity;
import com.wxb.mvp.ui.activity.login.LoginActivity;

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

    void inject(TestRecyclerViewActivity activity);

    void inject(TestAnimActivity activity);
}
