package com.wxb.mvp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.wxb.R;

/**
 * Created by wuxiaobo on 2018/2/2.
 * 自定义验证码输入框
 */
public class VerificationCodeView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {

    private Context mContext;
    private long endTime = 0;
    private OnCodeFinishListener onCodeFinishListener;

    /**
     * 输入框数量
     */
    private int mEtNumber;

    /**
     * 输入框类型
     */
    private VCInputType mEtInputType;
    /**
     * 输入框的宽度
     */
    private int mEtWidth;

    /**
     * 输入框高度
     */
    private int mEtHeight;

    /**
     * 文字颜色
     */
    private int mEtTextColor;

    /**
     * 文字大小
     */
    private float mEtTextSize;

    /**
     * 输入框背景
     */
    private int mEtTextBg;


    public void setOnCodeFinishListener(OnCodeFinishListener onCodeFinishListener) {
        this.onCodeFinishListener = onCodeFinishListener;
    }

    public enum VCInputType {
        NUMBER,
        NUMBERPASSWORD,
        TEXT,
        TEXTPASSWORD,
    }

    public VerificationCodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.VerificationCodeView);
        mEtNumber = typedArray.getInteger(R.styleable.VerificationCodeView_vcv_et_number, 4);
        int inputType = typedArray.getInt(R.styleable.VerificationCodeView_vcv_et_inputType, VCInputType.NUMBER.ordinal());
        mEtInputType = VCInputType.values()[inputType];
        mEtWidth = typedArray.getDimensionPixelSize(R.styleable.VerificationCodeView_vcv_et_width, 120);
        mEtHeight = typedArray.getDimensionPixelSize(R.styleable.VerificationCodeView_vcv_et_height, 120);

        mEtTextColor = typedArray.getColor(R.styleable.VerificationCodeView_vcv_et_text_color, Color.BLACK);
        mEtTextSize = typedArray.getDimension(R.styleable.VerificationCodeView_vcv_et_text_size, 16);
        mEtTextBg = typedArray.getResourceId(R.styleable.VerificationCodeView_vcv_et_bg, 0);

        //释放资源
        typedArray.recycle();
        initView();
    }

    @SuppressLint("ResourceAsColor")
    private void initView() {
        for (int i = 0; i < mEtNumber; i++) {
            EditText editText = new EditText(mContext);
            editText.setCursorVisible(false);
            initEditText(editText, i);
            addView(editText);
            if (i == 0) { //设置第一个editText获取焦点
                editText.setFocusable(true);
            }
        }
    }

    private void initEditText(EditText editText, int i) {
        int childHPadding = getResources().getDimensionPixelSize(R.dimen.dp_6);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mEtWidth, mEtHeight);
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = childHPadding;
        layoutParams.rightMargin = childHPadding;
        layoutParams.gravity = Gravity.CENTER;
        editText.setLayoutParams(layoutParams);
        editText.setGravity(Gravity.CENTER);
        editText.setId(i);
        editText.setCursorVisible(false);
        editText.setMaxEms(1);
        editText.setTextColor(mEtTextColor);
        editText.setTextSize(mEtTextSize);
        editText.setMaxLines(1);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        switch (mEtInputType) {
            case NUMBER:
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case NUMBERPASSWORD:
                editText.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                break;
            case TEXT:
                editText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case TEXTPASSWORD:
                editText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            default:
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
        editText.setPadding(0, 0, 0, 0);
        editText.setOnKeyListener(this);
        editText.setBackgroundResource(mEtTextBg);

//        //修改光标的颜色（反射）
//        try {
//            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
//            f.setAccessible(true);
//            f.set(editText, mCursorDrawable);
//        } catch (Exception ignored) {
//        }
        editText.addTextChangedListener(this);
        editText.setOnFocusChangeListener(this);
        editText.setOnKeyListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() != 0) {
            focus();
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            backFocus();
        }
        return false;
    }

    @Override
    public void setEnabled(boolean enabled) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.setEnabled(enabled);
        }
    }

    /**
     * 获取焦点
     */
    private void focus() {
        int count = getChildCount();
        EditText editText;
        //利用for循环找出还最前面那个还没被输入字符的EditText，并把焦点移交给它。
        for (int i = 0; i < count; i++) {
            editText = (EditText) getChildAt(i);
            if (editText.getText().length() < 1) {
                editText.requestFocus();
                return;
            }
        }
        //如果最后一个输入框有字符，则返回结果
        EditText lastEditText = (EditText) getChildAt(mEtNumber - 1);
        if (lastEditText.getText().length() > 0) {
            getResult();
        }
    }

    private void backFocus() {
        //博主手机不好，经常点一次却触发两次`onKey`事件，就设置了一个防止多点击，间隔100毫秒。
        long startTime = System.currentTimeMillis();
        EditText editText;
        //循环检测有字符的`editText`，把其置空，并获取焦点。
        for (int i = mEtNumber - 1; i >= 0; i--) {
            editText = (EditText) getChildAt(i);
            if (editText.getText().length() >= 1 && startTime - endTime > 100) {
                editText.setText("");
                editText.requestFocus();
                endTime = startTime;
                return;
            }
        }
    }

    private void getResult() {
        StringBuilder builder = new StringBuilder();
        EditText editText;
        for (int i = 0; i < mEtNumber; i++) {
            editText = (EditText) getChildAt(i);
            builder.append(editText.getText());
        }
        if (onCodeFinishListener != null) {
            onCodeFinishListener.onComplete(builder.toString());
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            focus();
        }
    }

    public interface OnCodeFinishListener {
        void onComplete(String content);
    }
}