package com.wxb.mvp.contract;

import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.bean.success.MallUserInfoBean;

import java.util.Map;

public class TestRvContract {

    public interface TestRvView extends BaseContract.BaseView{

    }

    public interface TestRvPresenter<T> extends BaseContract.BasePresenter<T>{
        void getToken(Map<String, String> map);
    }

    public interface TestRvModel extends BaseContract.BaseModel{
        void getToken(Map<String, String> map, TestRvCallback callback);
    }

    public interface TestRvCallback{
        void success(MallUserInfoBean bean);

        void failed(String error);

        void complete();
    }


}
