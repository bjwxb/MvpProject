package com.wxb.mvp.contract;

import com.wxb.mvp.base.BaseContract;

public class TestRvContract {

    public interface TestRvView extends BaseContract.BaseView{

    }

    public interface TestRvPresenter<T> extends BaseContract.BasePresenter<T>{

    }
}
