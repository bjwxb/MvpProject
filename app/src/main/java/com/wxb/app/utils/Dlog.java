package com.wxb.app.utils;

import android.support.annotation.NonNull;

import com.jiongbull.jlog.JLog;
import com.wxb.BuildConfig;

/**
 * Created by wuxiaobo on 2018/1/26.
 * Debug log
 */
public class Dlog {
    public static void i(String msg) {
        if (BuildConfig.DEBUG)
            JLog.i(msg);
    }

    public static void i(String tag, String msg) {
        if (BuildConfig.DEBUG)
            JLog.i(tag, msg);
    }

    public static void e(String msg) {
        if (BuildConfig.DEBUG)
            JLog.e(msg);
    }

    public static void e(String tag, String message, Throwable t) {
        if (BuildConfig.DEBUG)
            JLog.e(tag, t, message);
    }

    public static void e(Throwable t, String message) {
        if (BuildConfig.DEBUG)
            JLog.e(t, message);
    }

    public static void e(String tag, @NonNull String message) {
        if (BuildConfig.DEBUG)
            JLog.e(tag, message);
    }

    public static void e(String tag, @NonNull Throwable t) {
        if (BuildConfig.DEBUG)
            JLog.e(tag, t);
    }

    public static void json(String msg) {
        if (BuildConfig.DEBUG)
            JLog.json(msg);
    }

    public static void de(String msg) {
        if (msg.length() > 4000) {
            for (int i = 0; i < msg.length(); i += 4000) {
                if (i + 4000 < msg.length())
                    e("segment " + i, msg.substring(i, i + 4000));
                else
                    e("segment " + i, msg.substring(i, msg.length()));
            }
        } else
            e("segments ", msg);
    }
}
