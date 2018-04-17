package com.shark.utils.library.core;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * 各种常见正则验证集合
 * Created by renyuxiang on 2017/12/1.
 */

public class RegxUtils {

    public static boolean regexValidate(String regex, String target) {
        if (TextUtils.isEmpty(regex) || TextUtils.isEmpty(target)) return false;
        return Pattern.compile(regex).matcher(target).matches();
    }

    /**
     * 验证手机号码的合法性
     *
     * @param phoneNumber 手机号码
     * @return
     */
    public static boolean isCellPhoneValidate(String phoneNumber) {
        return regexValidate("^1[3|4|5|7|8][0-9]\\d{8}$", phoneNumber);
    }

    /**
     * 验证姓名的合法性
     * 中文2-15或英文4-60
     *
     * @param userName 姓名
     * @return
     */
    public static boolean isUserNameValidate(String userName) {
        return regexValidate("^([\\u4e00-\\u9fa5]{2,15}|([a-zA-Z]\\s?){4,30})$", userName);
    }

    /**
     * 验证邮箱的合法性
     *
     * @param email 邮箱
     * @return
     */
    public static boolean isEmailValidate(String email) {
        return regexValidate("(?=^[\\w.@]{6,50}$)\\w+@\\w+(?:\\.[\\w]{2,3}){1,2}", email);
    }

    /**
     * 验证身份证号的合法性
     *
     * @param id
     * @return
     */
    public static boolean isIdValidate(String id) {
        return regexValidate("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$", id);
    }

    /**
     * 验证车架的合法性
     *
     * @param frameNo
     * @return
     */
    public static boolean isCarFrameNoValidate(String frameNo) {
        return regexValidate("^[A-Z0-9]{17}$", frameNo);
    }

    /**
     * 验证发动机号合法性
     *
     * @param engineNumber
     * @return
     */
    public static boolean isEngineNoValidate(String engineNumber) {
        return regexValidate("^[A-Z0-9]{4,16}$", engineNumber);
    }

    /**
     * 验证车牌号合法性（5位经典车牌）
     *
     * @param carPlateNo
     * @return
     */
    public static boolean isCarPlate5Validate(String carPlateNo) {
        return regexValidate("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(\\*$|[A-Z0-9]{4,5}[A-Z0-9挂学警港澳]{1})$|[京津沪渝]{1}\\*$", carPlateNo);
    }

    /**
     * 验证车牌号合法性（六位新能源车牌）
     *
     * @param carPlateNo
     * @return
     */
    public static boolean isCarPlate6Validate(String carPlateNo) {
        return regexValidate("^(([\\u4e00-\\u9fa5][A-Z])[-]?|([wW][Jj][\\u4e00-\\u9fa5][-]?)|([a-zA-Z]{2}))([A-Za-z0-9]{5}|[DdFf][A-HJ-NP-Za-hj-np-z0-9][0-9]{4}|[0-9]{5}[DdFf])$", carPlateNo);
    }
}
