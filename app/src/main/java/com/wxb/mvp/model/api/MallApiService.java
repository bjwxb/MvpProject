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
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

//商城接口
public interface MallApiService{
    @FormUrlEncoded
    @POST("/v0/oauth/token")
    Observable<TokenBean> getToken(@FieldMap Map<String, String> map);

    //post --- bean请求
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("/v0/oauth/token")
    Observable<TokenBean> getTokenByBody(@Body Token token);

    //版静态的url请求
    @GET("/v0/{role}/user")
    Observable<MallUserInfoBean>getUserInfo(@Path("role") String role);

    //动态的URL请求
    @GET
    Observable<MallUserInfoBean>getUserInfoByUrl(@Url String user);

    @GET("/v0/doctor/user")
    Observable<MallUserInfoBean>getUserInfo(@QueryMap Map<String, String> map);
}
