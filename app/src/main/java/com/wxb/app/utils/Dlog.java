package com.wxb.app.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jiongbull.jlog.JLog;
import com.wxb.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wuxiaobo on 2018/1/26.
 * Debug log
 */
public class Dlog {
    private static boolean isDebug(){
        //return BuildConfig.DEBUG
        return true;
    }

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
            Log.e(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.e(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }
    public static void json(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        printLine(tag, true);
        message = headString + LINE_SEPARATOR + message;
        String[] lines = message.split(LINE_SEPARATOR);
        for (String line : lines) {
            Log.e(tag, "║ " + line);
        }
        printLine(tag, false);
    }

    public static void i(String msg) {
        if (isDebug())
            JLog.i(msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug())
            JLog.i(tag, msg);
    }

    public static void e(String msg) {
        if (isDebug())
            JLog.e(msg);
    }

    public static void e(String tag, String message, Throwable t) {
        if (isDebug())
            JLog.e(tag, t, message);
    }

    public static void e(Throwable t, String message) {
        if (isDebug())
            JLog.e(t, message);
    }

    public static void e(String tag, @NonNull String message) {
        if (isDebug())
            JLog.e(tag, message);
    }

    public static void e(String tag, @NonNull Throwable t) {
        if (isDebug())
            JLog.e(tag, t);
    }

    public static void json(String msg) {
        if (isDebug())
            JLog.e(msg.replaceAll(" ", ""));
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
