package com.wxb.app.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;

import com.wxb.app.utils.Dlog;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.net.ConnectivityManager.TYPE_WIFI;
import static android.provider.ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE;

/**
 * 监听网络变化
 */
public class NetworkStateReceiver extends AbsBroadcastReceiver {

    public interface Listener {
        void onNetworkStateChanged(int state);
    }

    private final Listener mListener;
    private static final String ACTION = ConnectivityManager.CONNECTIVITY_ACTION;

    public NetworkStateReceiver(Listener listener) {
        mListener = listener;
    }

    public final void register(@NonNull Context ctx) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION);
        ctx.getApplicationContext().registerReceiver(this, filter);
    }

    public final void unregister(@NonNull Context ctx) {
        ctx.getApplicationContext().unregisterReceiver(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null == intent) {
            return;
        }
        int netWorkStates = NetworkUtil.getNetWorkStates(context);
        mListener.onNetworkStateChanged(netWorkStates);
    }
}
