package com.codingassigment.billingsystem.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppUtils {

    private static final String DEFAULT_DATE_FORMAT = "yyyyMMddHHmmss";
    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);
    }

    public static String dateToSTring(Date date) {
        return dateToString(date, DEFAULT_DATE_FORMAT);
    }
}
