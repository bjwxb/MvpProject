package com.wxb.mvp.sp;

import android.content.Context;
import android.content.SharedPreferences;

import com.wxb.mvp.bean.TokenBean;

public class UserInfoUtils {
    private static final String XML_USER_INFO = "doctor_user_info";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String TOKEN_EXPIRE_TIME = "token_expire_time";                        //token过期时间


    public static String getAccessToken(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(ACCESS_TOKEN, "");
    }

    public static String getRefreshToken(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(REFRESH_TOKEN, "");
    }


    public static String getTokenExpireTime(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(TOKEN_EXPIRE_TIME, "0");
    }

    public static void saveTokenInfo(Context context, TokenBean bean) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        String accessToken = bean.getAccess_token();
        String refreshToken = bean.getRefresh_token();
        String tokenExpireTime = String.valueOf(bean.getExpires_in() * 1000 + System.currentTimeMillis());
        if (accessToken != null) {
            edit.putString(ACCESS_TOKEN, accessToken);
        }
        if (refreshToken != null) {
            edit.putString(REFRESH_TOKEN, refreshToken);
        }
        edit.putString(TOKEN_EXPIRE_TIME, tokenExpireTime);
        edit.apply();
    }

    public static void clear(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.clear();
        edit.apply();
    }
}
