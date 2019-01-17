package com.wxb;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxb.app.utils.Dlog;
import com.wxb.app.utils.ToastUtil;
import com.wxb.mvp.db.DbManager;
import com.wxb.mvp.model.entity.User;
import com.wxb.mvp.ui.base.BaseActivity;
import com.wxb.mvp.ui.base.BaseCustomBarActivity;
import com.wxb.mvp.ui.fragment.HomeFragment;
import com.wxb.mvp.ui.fragment.JoinUsFragment;
import com.wxb.mvp.ui.fragment.MallFragment;
import com.wxb.mvp.ui.fragment.MineFragment;
import com.wxb.mvp.ui.fragment.NearbyFragment;
import com.wxb.mvp.view.StatusBarUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseCustomBarActivity {
    @BindView(R.id.iv_menu_home)
    ImageView ivHome;
    @BindView(R.id.iv_menu_mall)
    ImageView ivMall;
    @BindView(R.id.iv_menu_join_us)
    ImageView ivJoinUs;
    @BindView(R.id.iv_menu_nearby)
    ImageView ivNearby;
    @BindView(R.id.iv_menu_mine)
    ImageView ivMine;
    @BindView(R.id.tv_menu_home)
    TextView tvHome;
    @BindView(R.id.tv_menu_mall)
    TextView tvMall;
    @BindView(R.id.tv_menu_join_us)
    TextView tvJoinUs;
    @BindView(R.id.tv_menu_nearby)
    TextView tvNearby;
    @BindView(R.id.tv_menu_mine)
    TextView tvMine;
    private HomeFragment mHomeFragment;
    private MallFragment mMallFragment;
    private JoinUsFragment mJoinUsFragment;
    private NearbyFragment mNearbyFragment;
    private MineFragment mMineFragment;
    private static final int HOME = 0X01;
    private static final int MALL = 0X02;
    private static final int JOIN_US = 0X03;
    private static final int NEARBY = 0X04;
    private static final int MINE = 0X05;
    // 定义一个变量，来标识是否退出
    private boolean isExit = false;
    // handler 消息ID S
    private final int MSG_EXIT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void setStatusBar() {
//        StatusBarUtil.setTranslucentForImageView(this, null);
//        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.red), 0);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void init() {
        showFragment(HOME);
        User user = DbManager.getInstance(this).getUserById("13651269612");
        if (null != user) {
            Dlog.e(" ,nickname is " + user.getNickname());
        }
    }

    /**
     * 页面显示管理
     */
    private void showFragment(int index) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        initBottomBtn();
        switch (index) {
            case HOME:
                if (mHomeFragment != null) {
                    ft.show(mHomeFragment);
                } else {
                    mHomeFragment = new HomeFragment();
                    ft.add(R.id.fl_container_main, mHomeFragment, "HomeFragment");
                }
                ivHome.setImageResource(R.mipmap.home_selected);
                tvHome.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case MALL:
                if (mMallFragment != null) {
                    ft.show(mMallFragment);
                } else {
                    mMallFragment = new MallFragment();
                    ft.add(R.id.fl_container_main, mMallFragment, "MallFragment");
                }
                ivMall.setImageResource(R.mipmap.category_selected);
                tvMall.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case JOIN_US:
                if (mJoinUsFragment != null) {
                    ft.show(mJoinUsFragment);
                } else {
                    mJoinUsFragment = new JoinUsFragment();
                    ft.add(R.id.fl_container_main, mJoinUsFragment, "JoinUsFragment");
                }
                ivJoinUs.setImageResource(R.mipmap.collect_selected);
                tvJoinUs.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case NEARBY:
                if (mNearbyFragment != null) {
                    ft.show(mNearbyFragment);
                } else {
                    mNearbyFragment = new NearbyFragment();
                    ft.add(R.id.fl_container_main, mNearbyFragment, "NearbyFragment");
                }
                ivNearby.setImageResource(R.mipmap.discovery_selected);
                tvNearby.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            case MINE:
                if (mMineFragment != null) {
                    ft.show(mMineFragment);
                } else {
                    mMineFragment = new MineFragment();
                    ft.add(R.id.fl_container_main, mMineFragment, "MineFragment");
                }
                ivMine.setImageResource(R.mipmap.setting_selected);
                tvMine.setTextColor(ContextCompat.getColor(this, R.color.main_color));
                break;
            default:
                break;
        }
        //ft.commit();
        ft.commitAllowingStateLoss();
    }

    /**
     * 隐藏Fragment
     */
    public void hideFragments(FragmentTransaction ft) {
        if (mHomeFragment != null) {
            ft.hide(mHomeFragment);
        }
        if (mMallFragment != null) {
            ft.hide(mMallFragment);
        }
        if (mJoinUsFragment != null) {
            ft.hide(mJoinUsFragment);
        }
        if (mNearbyFragment != null) {
            ft.hide(mNearbyFragment);
        }
        if (mMineFragment != null) {
            ft.hide(mMineFragment);
        }
    }

    /**
     * 初始化底部按钮状态
     */
    private void initBottomBtn() {
        ivHome.setImageResource(R.mipmap.home_normal);
        ivMall.setImageResource(R.mipmap.category_normal);
        ivJoinUs.setImageResource(R.mipmap.collect_normal);
        ivNearby.setImageResource(R.mipmap.discovery_normal);
        ivMine.setImageResource(R.mipmap.setting_normal);
        tvHome.setTextColor(ContextCompat.getColor(this, R.color.gray_5));
        tvMall.setTextColor(ContextCompat.getColor(this, R.color.gray_5));
        tvJoinUs.setTextColor(ContextCompat.getColor(this, R.color.gray_5));
        tvNearby.setTextColor(ContextCompat.getColor(this, R.color.gray_5));
        tvMine.setTextColor(ContextCompat.getColor(this, R.color.gray_5));
    }

    @OnClick({R.id.rl_menu_home, R.id.rl_menu_mall, R.id.rl_menu_join_us, R.id.rl_menu_nearby, R.id.rl_menu_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_menu_home:
                showFragment(HOME);
                break;
            case R.id.rl_menu_mall:
                showFragment(MALL);
                break;
            case R.id.rl_menu_join_us:
                showFragment(JOIN_US);
                break;
            case R.id.rl_menu_nearby:
                showFragment(NEARBY);
                break;
            case R.id.rl_menu_mine:
                showFragment(MINE);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private final Handler mHandler = new Handler(message -> {
        switch (message.what) {
            case MSG_EXIT:
                isExit = false;
                break;
            default:
                break;
        }
        return false;
    });

    /**
     * 退出
     */
    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtil.showToast(this, "再按一次退出");
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(MSG_EXIT, 2000);
        } else {
            moveTaskToBack(true);
//            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
