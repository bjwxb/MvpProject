package com.wxb.mvp.contract;

import com.wxb.mvp.base.BaseContract;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class TestAnimContract {
    public interface TestAnimView extends BaseContract.BaseView{

    }

    public interface TestAnimPresenter<T> extends BaseContract.BasePresenter<T>{
        void upload(RequestBody map, MultipartBody.Part file);

        void upload2(Map<String, RequestBody> map);

    }
}
