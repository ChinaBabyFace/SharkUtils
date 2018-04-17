package com.shark.utils.library.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by renyuxiang on 2017/11/22.
 */

public class DateUtils {
    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";

    public static final long SECOND = 1000;
    public static final long MINUTE = SECOND * 60;
    public static final long HOURS = MINUTE * 60;
    public static final long DAY = HOURS * 24;

    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String formatDateToLocalString(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        return dateFormat.format(date);
    }

    public static Date stringConvertDateByPattern(String dateStr, String formatStr) {
        if (dateStr == null || formatStr == null) {
        } else {
            try {
                SimpleDateFormat dd = new SimpleDateFormat(formatStr, Locale.getDefault());
                return dd.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
