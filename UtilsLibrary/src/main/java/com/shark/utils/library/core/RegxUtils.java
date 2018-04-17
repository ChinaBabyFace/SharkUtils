package com.shark.utils.library.core;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by renyuxiang on 2017/12/1.
 */

public class RegxUtils {

    public static boolean regexValidate(String regex, String target) {
        if (TextUtils.isEmpty(regex) || TextUtils.isEmpty(target)) return false;
        return Pattern.compile(regex).matcher(target).matches();
    }


    public static boolean isCellPhoneValidate(String phoneNumber) {
        return regexValidate("^1[3|4|5|7|8][0-9]\\d{8}$", phoneNumber);
    }


    public static boolean isUserNameValidate(String userName) {
        return regexValidate("^([\\u4e00-\\u9fa5]{2,15}|([a-zA-Z]\\s?){4,30})$", userName);
    }


    public static boolean isEmailValidate(String email) {
        return regexValidate("(?=^[\\w.@]{6,50}$)\\w+@\\w+(?:\\.[\\w]{2,3}){1,2}", email);
    }


    public static boolean isIdValidate(String id) {
        return regexValidate("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$", id);
    }

    public static boolean isCarFrameNoValidate(String frameNo) {
        return regexValidate("^[A-Z0-9]{17}$", frameNo);
    }

    public static boolean isEngineNoValidate(String engineNumber) {
        return regexValidate("^[A-Z0-9]{4,16}$", engineNumber);
    }

//    public static boolean isCarPlate5Validate(String carPlateNo) {
//    }


    public static boolean isCarPlate6Validate(String carPlateNo) {
        return regexValidate("^(([\\u4e00-\\u9fa5][A-Z])[-]?|([wW][Jj][\\u4e00-\\u9fa5][-]?)|([a-zA-Z]{2}))([A-Za-z0-9]{5}|[DdFf][A-HJ-NP-Za-hj-np-z0-9][0-9]{4}|[0-9]{5}[DdFf])$", carPlateNo);
    }
}
