
package com.shark.utils.library.core;

import android.util.Log;

import com.shark.utils.library.UtilsSetting;



public class SLog {

	public static final boolean IS_DEBUG = true;
	public static final String GLOBAL_TAG = UtilsSetting.APP_LOG_TAG;

	public static String getObjectName(Object object) {
		String temp = object.getClass().getName();
		return temp.substring(temp.lastIndexOf(".") + 1, temp.length());
	}

	public static void v(Object obj, String msg) {
		if (IS_DEBUG) {
			Log.v(getObjectName(obj), GLOBAL_TAG + msg);
		}
	}

	public static void e(Object obj, String msg) {
		if (IS_DEBUG) {
			Log.e(getObjectName(obj), GLOBAL_TAG + msg);
		}
	}

	public static void i(Object obj, String msg) {
		if (IS_DEBUG) {
			Log.i(getObjectName(obj), GLOBAL_TAG + msg);
		}
	}

	public static void d(Object obj, String msg) {
		if (IS_DEBUG) {
			Log.d(getObjectName(obj), GLOBAL_TAG + msg);
		}
	}
}
