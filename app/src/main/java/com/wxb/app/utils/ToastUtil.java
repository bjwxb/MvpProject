package com.wxb.app.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 吐司封装类
 * 
 * @author wuxiaobo
 * 
 */
public class ToastUtil {
	private static String oldMsg;//正在显示的消息
	private static Toast toast = null;
	private static long oneTime = 0;//第一次显示消息的时间
	private static long twoTime = 0;//第二次显示消息的时间

	/**
	 * 吐司封装
	 * 
	 */
	public static void showToast(Context context, String s) {
		if (TextUtils.isEmpty(s)) {
			return;
		}
		if (toast == null) {
			toast = Toast.makeText(context.getApplicationContext(), s, Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.BOTTOM, 0, 100);
			toast.show();
			oneTime = System.currentTimeMillis();
		} else {
			twoTime = System.currentTimeMillis();
			if (s.equals(oldMsg)) {
				if (twoTime - oneTime > Toast.LENGTH_LONG) {
					toast.show();
				}
			} else {
				oldMsg = s;
				toast.setText(s);
				toast.show();
			}
		}
		oneTime = twoTime;
	}

	/**
	 * 吐司资源字符串
	 * 
	 */
	public static void showToast(Context context, int resId) {
		showToast(context, context.getString(resId));
	}
}
