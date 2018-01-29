package com.wxb.mvp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.facebook.stetho.common.LogUtil;
import com.wxb.mvp.model.dao.DaoMaster;
import com.wxb.mvp.model.dao.DaoSession;
import com.wxb.mvp.model.dao.UserDao;
import com.wxb.mvp.model.entity.User;

import java.util.List;

/**
 * Created by wuxiaobo on 2018/1/29.
 * 数据库管理
 */
public class DbManager {
    private static volatile DbManager instance;
    private DaoMaster.DevOpenHelper openHelper;

    private DbManager(Context context) {
        openHelper = new DaoMaster.DevOpenHelper(context, getDbName());
    }

    private String getDbName() {
        return "account.db";
    }

    public static DbManager getInstance(Context context) {
        if (null == instance) {
            synchronized (DbManager.class) {
                if (null == instance) {
                    instance = new DbManager(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        return openHelper.getWritableDatabase();
    }

    private SQLiteDatabase getReadableDatabase() {
        return openHelper.getReadableDatabase();
    }

    public void saveUser(User user) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.save(user);
    }

    public void saveEncryptedUser(User user) {
        DaoMaster daoMaster = new DaoMaster(openHelper.getEncryptedReadableDb(user.getKey()));
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.save(user);
    }

    public boolean isExistUser(String mobile) {
        boolean isExist = false;
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        List<User> list = userDao.queryBuilder().list();
        if (null != list && list.size() > 0) {
            LogUtil.e("mobile is " + mobile + " , db mobile is " + list.get(0).getMobile());
            isExist = TextUtils.equals(mobile, list.get(0).getMobile());
        }
        return isExist;
    }

    public User getUser() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        return userDao.queryBuilder().list().get(0);
    }

    public User getEncryptedUser(String pwd) {
        DaoMaster master = new DaoMaster(openHelper.getEncryptedReadableDb(pwd));
        DaoSession daoSession = master.newSession();
        UserDao userDao = daoSession.getUserDao();
        return userDao.queryBuilder().list().get(0);
    }

    public void closeDB() {
        try {
            if (openHelper != null) {
                openHelper.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        instance = null;
    }
}
