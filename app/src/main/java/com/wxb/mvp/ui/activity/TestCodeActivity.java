package com.wxb.mvp.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.mvp.ui.base.BaseActivity;
import com.wxb.mvp.view.ToolbarSetting;
import com.wxb.mvp.view.VerificationCodeInput;
import com.wxb.mvp.view.VerificationCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自定义验证码输入测试
 */
public class TestCodeActivity extends BaseActivity {

    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_group)
    LinearLayout llGroup;
    @BindView(R.id.et_code)
    VerificationCodeView etCode;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_code;
    }

    @Override
    public void initViews() {
        initToolBar();
    }

    /**
     * init toolbar
     */
    private void initToolBar() {
        ToolbarSetting mToolbarSetting = new ToolbarSetting(llGroup);
        mToolbarSetting.setTitle("自定义验证码输入框")
                .isLeftShow(true)
                .setLeftImage(R.mipmap.ic_back_white)
                .isRightShow(false);
    }

    @Override
    public void initData() {
//        etCode.setOnCompleteListener(new VerificationCodeInput.Listener() {
//            @Override
//            public void onComplete(String content) {
//                btnConfirm.setEnabled(true);
//                btnConfirm.setBackgroundResource(R.drawable.selector_login);
//                btnConfirm.setTextColor(Color.parseColor("#ffffff"));
//                Dlog.e("************** content is " + content);
//            }
//        });
        etCode.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {
            @Override
            public void onComplete(String content) {
                btnConfirm.setEnabled(true);
                btnConfirm.setBackgroundResource(R.drawable.selector_login);
                btnConfirm.setTextColor(Color.parseColor("#ffffff"));
                Dlog.e("************** content is " + content);
            }
        });
    }

    @OnClick({R.id.ll_left,R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_left:
                finish();
                break;
            case R.id.btn_confirm:
                etCode.setEnabled(true);
                break;
            default:
                break;
        }
    }
}
