package com.wxb.mvp.ui.activity.home;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxb.R;
import com.wxb.app.utils.Dlog;
import com.wxb.app.utils.DpPxUtils;
import com.wxb.app.utils.ToastUtil;
import com.wxb.ioc.component.ActivityComponent;
import com.wxb.mvp.base.BaseContract;
import com.wxb.mvp.contract.TestAnimContract;
import com.wxb.mvp.presenter.TestAnimPresenterImpl;
import com.wxb.mvp.ui.activity.home.interpolator.CustomInterpolator;
import com.wxb.mvp.ui.base.BaseActivity;
import com.wxb.mvp.view.ToolbarSetting;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class TestAnimActivity extends BaseActivity implements TestAnimContract.TestAnimView {

    @Inject
    TestAnimPresenterImpl mPresenter;

    @BindView(R.id.ll_group)
    LinearLayout llGroup;
    @BindView(R.id.tv_anim_translation)
    TextView tvAnimTranslation;
    @BindView(R.id.tv_anim_alpha)
    TextView tvAnimAlpha;
    @BindView(R.id.tv_anim_rotation)
    TextView tvAnimRotation;
    @BindView(R.id.tv_anim_scale)
    TextView tvAnimScale;
    @BindView(R.id.tv_custom_interpolator)
    TextView tvCustomInterpolator;

    @BindView(R.id.iv_test)
    ImageView ivTest;


    //start this activity
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, TestAnimActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_anim;
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
        mToolbarSetting.setTitle("属性动画")
                .setLeftImage(R.mipmap.ic_back_white)
                .isLeftShow(true)
                .setLeftClick(v -> {
                    finish();
                })
                .isRightShow(false);
    }

    @Override
    public void initData() {
//        test();

        testAnimTranslation();
        testAnimAlpha();
        testAnimRotation();
        testAnimScale();

        testCustomInterpolator();
        testInterpolator();
    }

    private void testInterpolator() {
        float curTranslationY = tvAnimTranslation.getTranslationY();
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivTest, "translationY", curTranslationY, curTranslationY + 300);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(ivTest, "scaleX", 1f, 1.5f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(ivTest, "scaleY", 1f, 1.5f);
//        animator.setInterpolator(new CycleInterpolator(3f));
//        animator.setInterpolator(new BounceInterpolator());


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator1, animator2);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.setDuration(3 * 1000);
        animatorSet.start();
    }

    private void testAnimTranslation() {
        tvAnimTranslation.setOnClickListener(v -> {
            ToastUtil.showToast(this, "属性动画点击事件");
        });
        float curTranslationX = tvAnimTranslation.getTranslationX();
        float curTranslationY = tvAnimTranslation.getTranslationY();
        // 获得当前按钮的位置
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimTranslation, "translationX", curTranslationX, 300, curTranslationX, 400);

        // 表示的是:
        // 动画作用对象是tvAnimTranslation
        // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
        // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
        animator.setDuration(5000);
        new LinearInterpolator();//匀速
        new AccelerateInterpolator();//加速
        new DecelerateInterpolator();//减速
        new AccelerateDecelerateInterpolator();//先加速 再减速
        new OvershootInterpolator();//快速完成动画，超出再回到结束样式
        new AnticipateInterpolator();//先退后再加速前进
        new AnticipateOvershootInterpolator();//先退后再加速前进，超出终点后再回终点
        new BounceInterpolator();//最后阶段弹球效果
        new CycleInterpolator(1f);//周期运动
        animator.setInterpolator(new LinearInterpolator());
//        animator.start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tvAnimTranslation, "translationY", curTranslationY, 300, curTranslationY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator1);
        animatorSet.setDuration(2 * 1000);
        animatorSet.start();
    }

    private void testAnimAlpha() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimAlpha, "alpha", 1f, 0.2f, 1f, 0.5f);
        animator.setDuration(2000);
//        animator.setRepeatCount(-1);//无限循环
        animator.setRepeatCount(2);
        animator.start();
    }

    private void testAnimRotation() {
        float curTranslationX = tvAnimTranslation.getTranslationX();
        float curTranslationY = tvAnimTranslation.getTranslationY();

        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimRotation, "rotation", 0f, 360f);
        animator.setDuration(2000);
//        animator.start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tvAnimRotation, "translationX", curTranslationX, 300, curTranslationX, 400);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(tvAnimRotation, "translationY", curTranslationY, 300, curTranslationY);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator1, animator2);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }

    private void testAnimScale() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimScale, "scaleX", 1f, 2f, 1f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tvAnimScale, "scaleY", 1f, 2f, 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator1);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    private void testCustomInterpolator() {
        float curTranslationX = tvAnimTranslation.getTranslationX();
        float curTranslationY = tvAnimTranslation.getTranslationY();
        float width = DpPxUtils.getScreenWidth(this);
        // 获得当前按钮的位置
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvCustomInterpolator, "translationX", curTranslationX, width - 300, curTranslationX);
        animator.setInterpolator(new CustomInterpolator());//test 自定义插值器

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.setDuration(4 * 1000);
        animatorSet.start();

        tvCustomInterpolator.setOnClickListener(v -> {
            if (!animatorSet.isRunning()) {
                animatorSet.start();
            } else {
                Dlog.e("---------------- animator is running");
            }
        });
    }

    //test upload pic
    private void test() {
        File file = new File("sdcard/xzl/22.png");

        final RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        if (file.exists()) {
            String from = "android";
            RequestBody model = RequestBody.create(MediaType.parse("multipart/form-data"), from);

            Dlog.e("____________ " + file.getAbsolutePath());
            mPresenter.upload(model, body);
        } else {
            Dlog.e("=================== file not exists");
        }
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
    public void showError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void completed() {
        Dlog.e(">>>>>>>>> completed >>>>>>>>>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //若动画为无限循环动画, 这里应该掉用animator.cancel() 以避免内存泄漏
    }
}
