package com.wxb.mvp.contract;

import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.bean.LoginBean;

import java.util.Map;

/**
 * Created by wuxiaobo on 2018/1/26.
 * login contract
 */
public class LoginContract{
    public interface LoginView extends BaseContract.BaseView{

        void loginSuccess(LoginBean.DatasBean dataBean);

        void loginError(String msg);
        /**
         * get user account
         * @return account(string)
         */
        String getAccount();

        /**
         * get user pwd
         * @return pwd(string)
         */
        String getPassword();
    }

    public interface LoginPresenter<T> extends BaseContract.BasePresenter<T>{
        /**
         * login
         */
        void login(Map<String , String> map);
    }
}
