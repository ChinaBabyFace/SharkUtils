package com.shark.utils.library.core;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * Created by renyuxiang on 2017/10/31.
 */

public class AndroidUtils {
    public static String getVersionName(Context context) {
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getMipmapResourceByName(Context context, String imageName) {
        return getResourceByName(context, "mipmap", imageName);
    }

    public static int getResourceByName(Context context, String resType, String imageName) {
        return context.getResources().getIdentifier(imageName, resType, context.getPackageName());
    }

    public static String getDeviceId(Context context) {
        String deviceId = "";

        deviceId = getPhoneDeviceId(context);
        if (!TextUtils.isEmpty(deviceId) && !isAllZero(deviceId)) return deviceId;

        deviceId = getAndroidId(context);
        if (!TextUtils.isEmpty(deviceId)
                && !isAllZero(deviceId)
                && !"9774d56d682e549c".equals(deviceId)) return deviceId;

        deviceId = java.util.UUID.randomUUID().toString();
        if (!TextUtils.isEmpty(deviceId)) return deviceId;

        return Long.toString(System.currentTimeMillis());
    }

    public static String getAndroidId(Context context) {
        return android.provider.Settings.Secure.getString(
                context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);
    }

    public static String getPhoneDeviceId(Context context) {
        boolean isPermission = PackageManager.PERMISSION_GRANTED
                ==
                context.getPackageManager().checkPermission(Manifest.permission.READ_PHONE_STATE, context.getPackageName());
        return isPermission ? ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId() : "";
    }

    private static boolean isAllZero(String str) {
        str.replaceAll("0", " ");
        return TextUtils.isEmpty(str.trim());
    }
}
