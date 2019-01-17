package com.wxb.mvp.view;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wxb.R;


/**
 * 底部对话框基类封装
 */
public class BaseBottomDialog {

    private final Builder builder;
    private Dialog mShareDialog;

    public BaseBottomDialog(Builder builder) {
        this.builder = builder;
    }

    /**
     * 显示分享弹出框
     */
    public BaseBottomDialog showDialog() {
        if (mShareDialog == null) {
            initShareDialog();
        }
        mShareDialog.show();
        return this;
    }

    public void dismissDialog() {
        if (mShareDialog != null && mShareDialog.isShowing()) {
            mShareDialog.dismiss();
        }
    }

    /**
     * 初始化分享弹出框
     */
    private void initShareDialog() {
        mShareDialog = new Dialog(builder.context, R.style.dialog_bottom_full);
        mShareDialog.setCanceledOnTouchOutside(true);
        mShareDialog.setCancelable(true);

        View view = View.inflate(builder.context, builder.layoutId, null);
        for (Integer integer : builder.map.keySet()) {
            view.findViewById(integer).setOnClickListener(builder.map.get(integer));
        }
        if (builder.closeId != -1) {
            view.findViewById(builder.closeId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismissDialog();
                }
            });
        }

        Window window = mShareDialog.getWindow();
        if (null != window){
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.share_animation);
            window.setContentView(view);
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
        }

    }

    public static class Builder {
        private Context context;
        private int layoutId;
        private int closeId = -1;
        private ArrayMap<Integer, View.OnClickListener> map = new ArrayMap<>();

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setLayoutId(int layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        public Builder setOnClickListener(int id, View.OnClickListener listener) {
            map.put(id, listener);
            return this;
        }

        public Builder setCloseId(int id) {
            this.closeId = id;
            return this;
        }

        public BaseBottomDialog build() {
            return new BaseBottomDialog(this);
        }
    }

}
