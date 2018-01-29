package com.wxb.app;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.jiongbull.jlog.JLog;
import com.jiongbull.jlog.constant.LogLevel;
import com.jiongbull.jlog.constant.LogSegment;
import com.jiongbull.jlog.constant.ZoneOffset;
import com.wxb.BuildConfig;
import com.wxb.R;
import com.wxb.ioc.component.AppComponent;
import com.wxb.ioc.component.DaggerAppComponent;
import com.wxb.ioc.module.ApiModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxiaobo on 2018/1/26.
 * custom application
 */
public class App extends Application{

    private AppComponent mAppComponent;
    private static App instance = null;

    //application 单例
    public static App getInstance(){
        return  instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;//application init

        initDebug();
        initLog();
    }

    private void initDebug(){
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
    public static void initLog() {
        List<LogLevel> logLevels = new ArrayList<>();
        logLevels.add(LogLevel.ERROR);
        JLog.init()
                .setDebug(BuildConfig.DEBUG)//正式发包前 放开注释关闭日志
                .writeToFile(true)
                .setLogSegment(LogSegment.ONE_HOUR)//TWENTY_FOUR_HOURS
                .setLogDir(".a" + getInstance().getString(R.string.app_name) + "V4")
//                .setLogDir("ajxV4")
                .setZoneOffset(ZoneOffset.P0800)
                .setTimeFormat("yyyy年MM月dd日 HH时mm分ss秒")
                .setLogLevelsForFile(logLevels)
                .setPackagedLevel(1);

    }


    //获取AppComponent 以便于SubComponent继承
    public AppComponent getAppComponent() {
        if (null == mAppComponent) {
            this.setupAppComponent();
        }
        return mAppComponent;
    }

    private void setupAppComponent() {
        mAppComponent = DaggerAppComponent.builder().apiModule(new ApiModule()).build();
    }

}
