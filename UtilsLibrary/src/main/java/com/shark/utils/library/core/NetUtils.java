package com.shark.utils.library.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by renyuxiang on 2017/10/31.
 */

public class NetUtils {
    /**
     * <b>isMobileNetwork。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 是否连接的是移动通信网。
     *
     * @param context
     * @return
     */
    public static boolean isMobileNetwork(Context context) {
        if (context != null) {
            NetworkInfo info = getActiveNetworkInfo(context);
            if (info == null) {
                return false;
            }
            return (info != null) && (info.getType() == 0) && (info.isConnected());
        }
        return false;
    }

    /**
     * <b>isWifi。</b>
     * <p><b>详细说明：</b></p>
     * <!-- 在此添加详细说明 -->
     * 是否处于WIFI网络
     *
     * @param
     * @return
     */
    public static boolean isWifi(Context context) {
        NetworkInfo activeNetInfo = getActiveNetworkInfo(context);
        return (activeNetInfo != null) && (activeNetInfo.getType() == 1);
    }

    /**
     * 获取网络状态信息
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            return connectivity.getActiveNetworkInfo();
        } else {
            return null;
        }
    }
}
