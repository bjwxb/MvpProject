package com.wxb.app.utils;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wxb.R;

/**
 *     new BaseDialog
 *                         .Builder()
 *                         .setContext(getActivity())
 *                         .setLayoutId(R.layout.dialog_simple_single_image_layout)
 *                         .setCloseId(R.id.img_close)
 *                         .build()
 *                         .showDialog();
 */
public class BaseDialog {

    private final Builder builder;

    public BaseDialog(Builder builder) {
        this.builder = builder;
    }

    public static class Builder {
        private ArrayMap<Integer, View.OnClickListener> map = new ArrayMap<>();
        private Context context;
        private OnHandleViewListener onHandleViewListener;
        private int layoutId;
        private int closeId = -1;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setLayoutId(int layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        public Builder setCloseId(int id) {
            this.closeId = id;
            return this;
        }

        public Builder setOnClickListener(int id, View.OnClickListener listener) {
            map.put(id, listener);
            return this;
        }

        public Builder setOnHandleViewListener(OnHandleViewListener onHandleViewListener) {
            this.onHandleViewListener = onHandleViewListener;
            return this;
        }

        public BaseDialog build() {
            return new BaseDialog(this);
        }
    }

    public interface OnHandleViewListener {
        void onHandle(View view);
    }

}
