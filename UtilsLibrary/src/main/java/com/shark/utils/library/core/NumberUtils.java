package com.shark.utils.library.core;

import java.util.regex.Pattern;

/**
 * Created by renyuxiang on 2017/12/1.
 */
public class NumberUtils {

    public static boolean isNumeric(String numberString) {
        return Pattern.compile("[0-9]*").matcher(numberString).matches();
    }
}
