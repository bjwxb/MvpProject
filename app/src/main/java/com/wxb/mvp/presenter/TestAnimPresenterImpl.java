package com.wxb.mvp.presenter;

import com.google.gson.Gson;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.base.BaseRxPresenter;
import com.wxb.mvp.bean.BaseResponseBean;
import com.wxb.mvp.contract.TestAnimContract;
import com.wxb.mvp.model.api.TrtApiService;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class TestAnimPresenterImpl extends BaseRxPresenter<TestAnimContract.TestAnimView>
        implements TestAnimContract.TestAnimPresenter<TestAnimContract.TestAnimView> {

    private TrtApiService trtApiService;

    @Inject
    TestAnimPresenterImpl(TrtApiService trtApiService) {
        this.trtApiService = trtApiService;
    }

    @Override
    public void upload(RequestBody map, MultipartBody.Part file) {
        addSubscribe(trtApiService.upload(map, file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::parseData, mView::showError, mView::completed));
    }

    @Override
    public void upload2(Map<String, RequestBody> map) {
        addSubscribe(trtApiService.upload(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::parseData, mView::showError, mView::completed));
    }

    private void parseData(BaseResponseBean bean) {
        Dlog.e(new Gson().toJson(bean));
    }
}
