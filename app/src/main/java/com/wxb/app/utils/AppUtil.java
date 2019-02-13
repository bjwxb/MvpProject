package com.wxb.app.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.wxb.app.App;

public class AppUtil {

    public static String getFlavorChannel() {
        try {
            PackageManager pm = App.getInstance().getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(App.getInstance().getPackageName(), PackageManager.GET_META_DATA);
            return appInfo.metaData.getString("channel");
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return "";
    }
}
