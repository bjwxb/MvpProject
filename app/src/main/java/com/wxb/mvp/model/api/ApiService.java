package com.wxb.mvp.model.api;

import com.wxb.mvp.bean.AllGroupBean;
import com.wxb.mvp.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by wuxiaobo on 2018/1/26.
 * 接口
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("mobile/index.php?act=login&op=index")
    Observable<LoginBean> login(@FieldMap Map<String, String> map);

    //推广赚->全部开团页面接口
    @GET("/mobile/?act=pintuan&op=goods_list")
    Observable<AllGroupBean> getAllGroupList(@QueryMap Map<String, String> map);
}
