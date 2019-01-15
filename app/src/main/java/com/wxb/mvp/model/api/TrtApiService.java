package com.wxb.mvp.model.api;

import com.wxb.mvp.bean.BaseResponseBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface TrtApiService{
    @Multipart
    @Headers({"X-ZHIYUN-API-TOKEN:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE1NDcwODgwMjUsImFnZW5jeV9pZCI6MSwiZXhwIjoxNTU0ODY0MDI1LCJ0eXBlIjoiQiIsImlhdCI6MTU0NzA4ODAyNSwidXBkYXRlX3RpbWUiOiIyMDE5LTAxLTA5IDA4OjMwOjMxIn0.SPtH3RWjkPV_MpG-AHy8PdUZ4hyNW7BdRHaFlrAHUu0",
            "X-ZHIYUN-API-FOR-USER:13636382436"})
    @POST("/api16/photos/face")
    Observable<BaseResponseBean> upload(@Part("model") RequestBody model, @Part MultipartBody.Part file);

    @Multipart
    @Headers({"X-ZHIYUN-API-TOKEN:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE1NDcwODgwMjUsImFnZW5jeV9pZCI6MSwiZXhwIjoxNTU0ODY0MDI1LCJ0eXBlIjoiQiIsImlhdCI6MTU0NzA4ODAyNSwidXBkYXRlX3RpbWUiOiIyMDE5LTAxLTA5IDA4OjMwOjMxIn0.SPtH3RWjkPV_MpG-AHy8PdUZ4hyNW7BdRHaFlrAHUu0",
              "X-ZHIYUN-API-FOR-USER:13636382436"})
    @POST("/api16/photos/face")
    Observable<BaseResponseBean> upload(@PartMap() Map<String, RequestBody> map);
}
