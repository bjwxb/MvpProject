package com.wxb.mvp.ui.activity.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.wxb.MainActivity;
import com.wxb.R;
import com.wxb.app.utils.AppUtil;
import com.wxb.app.utils.Dlog;
import com.wxb.app.utils.ToastUtil;
import com.wxb.ioc.component.ActivityComponent;
import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.bean.LoginBean;
import com.wxb.mvp.bean.LoginBean2;
import com.wxb.mvp.contract.LoginContract;
import com.wxb.mvp.db.DbManager;
import com.wxb.mvp.model.entity.User;
import com.wxb.mvp.presenter.LoginPresenterImpl;
import com.wxb.mvp.ui.base.BaseCustomBarActivity;
import com.wxb.mvp.view.ClearEditText;
import com.wxb.mvp.view.ToolbarSetting;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 登录页面
 */
public class LoginActivity extends BaseCustomBarActivity implements LoginContract.LoginView {

    @Inject
    LoginPresenterImpl mPresenter;
    @BindView(R.id.ll_group)
    LinearLayout llGroup;
    @BindView(R.id.et_phone)
    ClearEditText etPhone;
    @BindView(R.id.et_pwd)
    ClearEditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return mPresenter;
    }

    @Override
    protected void setupActivityComponent(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void initViews() {
        initToolBar();

        Dlog.e("************** flavor channel is " + AppUtil.getFlavorChannel());
    }

    /**
     * init toolbar
     */
    private void initToolBar() {
        ToolbarSetting mToolbarSetting = new ToolbarSetting(llGroup);
        mToolbarSetting.setTitle("登录")
                .isLeftShow(false)
                .isRightShow(false);
    }


    @Override
    public void initData() {
        inputObserver();
    }

    //监听手机号和密码是否输入
    private void inputObserver() {
        Observable<CharSequence> observablePhone = RxTextView.textChanges(etPhone);
        Observable<CharSequence> observablePwd = RxTextView.textChanges(etPwd);

        Disposable disposable = Observable.combineLatest(observablePhone, observablePwd, ((phone, pwd) -> {
            return isPhoneValid(phone.toString()) && isPasswordValid(pwd.toString());
        })).subscribe(aBoolean -> {
            if (aBoolean) {
                btnLogin.setEnabled(true);
                btnLogin.setBackgroundResource(R.drawable.selector_login);
            } else {
                btnLogin.setEnabled(false);
                btnLogin.setBackgroundResource(R.drawable.bg_btn_disabled);
            }
        });

        mCompositeDisposable.add(disposable);

        //RxTextView.textChanges(etPhone).subscribe(etPwd::setText);
    }

    /**
     * 检查手机号是否有效
     *
     * @param phone phone
     * @return boolean
     */
    private boolean isPhoneValid(String phone) {
        return !TextUtils.isEmpty(phone) && phone.length() == 11;
    }

    /**
     * 检查密码是否有效
     *
     * @param password password
     * @return boolean
     */
    private boolean isPasswordValid(String password) {
        return !TextUtils.isEmpty(password) && password.length() > 5;
    }

    //login
    private void login() {
        Map<String, String> map = new HashMap<>();
        map.put("username", getAccount());
        map.put("password", getPassword());
        map.put("client", "android");
        mPresenter.login(map);
    }

    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            default:
                break;
        }
    }

    @Override
    public void loginSuccess(LoginBean.DatasBean datasBean) {
        Dlog.e("----------------------");
        User user = new User();
        user.setNickname(datasBean.getUsername());
        user.setHx_login(datasBean.getHx_login());
        user.setAccount(datasBean.getUsername());
        user.setMobile(datasBean.getMobile());
        user.setMember_avatar(datasBean.getMember_avatar());
        user.setKey(datasBean.getKey());
        if (DbManager.getInstance(this).isExistUser(datasBean.getMobile())) {
            user.setId(DbManager.getInstance(this).getUser().getId());
        }
        DbManager.getInstance(this).saveUser(user);
        forward(MainActivity.class);
    }

    @Override
    public void loginSuccess2(LoginBean2 datasBean) {
        Dlog.e(">>>>>>>>>> " + new Gson().toJson(datasBean));
        User user = new User();
        user.setNickname(datasBean.getUsername());
        user.setHx_login(datasBean.getHx_login());
        user.setAccount(datasBean.getUsername());
        user.setMobile(datasBean.getMobile());
        user.setMember_avatar(datasBean.getMember_avatar());
        user.setKey(datasBean.getKey());
        if (DbManager.getInstance(this).isExistUser(datasBean.getMobile())) {
            user.setId(DbManager.getInstance(this).getUser().getId());
        }
        DbManager.getInstance(this).saveUser(user);
        forward(MainActivity.class);
    }

    @Override
    public void loginError(String msg) {
        ToastUtil.showToast(getApplicationContext(), msg);
    }

    @Override
    public String getAccount() {
        return etPhone.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void showError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void completed() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
    }
}
