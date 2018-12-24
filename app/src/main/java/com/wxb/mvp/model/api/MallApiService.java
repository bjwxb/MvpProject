package com.wxb.mvp.model.api;

import com.wxb.mvp.bean.TokenBean;
import com.wxb.mvp.bean.request.Token;
import com.wxb.mvp.bean.success.MallUserInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

//商城接口
public interface MallApiService {
    @FormUrlEncoded
    @POST("/v0/oauth/token")
    Observable<TokenBean> getToken(@FieldMap Map<String, String> map);

    @POST("/v0/oauth/token")
    Observable<TokenBean> getTokenByBody(@Body Token token);

    @GET("/v0/doctor/user")
    Observable<MallUserInfoBean>getUserInfo();
}
