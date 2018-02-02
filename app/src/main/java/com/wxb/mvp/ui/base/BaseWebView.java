package com.wxb.mvp.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.wxb.R;

/**
 * Created by wuxiaobo on 2017/11/10.
 * 自定义baseview
 */
public class BaseWebView extends RelativeLayout {
    private Context mContext;
    private WebView webView;
    private ProgressBar progressBar;//加载进度

    public BaseWebView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BaseWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    public BaseWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_webview, this);
        webView = (WebView) view.findViewById(R.id.webView);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        initWebViewSet();
    }

    /**
     * 初始化WebView设置(里面是适配的关键配置)
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void initWebViewSet() {
        // 设置编码
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        // User settings
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//支持通过JS打开新窗口
        webView.getSettings().setUseWideViewPort(true);//关键点 //将图片调整至适合webview大小
        webView.getSettings().setJavaScriptEnabled(true); // 设置支持javascript脚本
        webView.getSettings().setAllowFileAccess(true); // 允许访问文件

        //缩放操作
        webView.getSettings().setSupportZoom(true); //支持缩放，默认为true。
        webView.getSettings().setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则不可缩放
        webView.getSettings().setDisplayZoomControls(false); //隐藏原生的缩放控件
        webView.getSettings().setLoadsImagesAutomatically(true);  //支持自动加载图片
        webView.getSettings().setSavePassword(false);//SDK18之下默认为true，sdk19+默认为false。解决乐视机型
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);  //设置存储状态
        webView.getSettings().setDatabaseEnabled(true);    //设置数据库启用

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//解决5.0之后https图片不显示问题
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        //隐藏滚动条
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);

        webView.getSettings().setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        DisplayMetrics metrics = new DisplayMetrics();
        int mDensity = metrics.densityDpi;
        if (mDensity == 240) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == 160) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if (mDensity == 120) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        } else if (mDensity == DisplayMetrics.DENSITY_XHIGH) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else if (mDensity == DisplayMetrics.DENSITY_TV) {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        } else {
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        }
        /*
         * 用WebView显示图片，可使用这个参数 设置网页布局类型： 1、LayoutAlgorithm.NARROW_COLUMNS ：
         * 适应内容大小 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
         */
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        // 重新WebView加载URL的方法
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }
        });
    }

    /**
     * 获取WebView实例
     */
    public WebView getWebView() {
        return webView;
    }

    /**
     * 这个自定义web是否支持缩放（暂时测试只有图片可以缩放，网页自适应）
     */
    public void setZoom(boolean flag) {
        webView.getSettings().setSupportZoom(flag);
    }

    //web 清空，避免内存泄露
    public void webDestory() {
        if (webView != null) {
            webView.removeAllViews();
            webView.destroy();
            webView = null;
        }
    }
}
