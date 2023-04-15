package com.bosc.assessment.util;

import java.util.Date;

import com.google.common.base.CaseFormat;

public class CommonUtil {

    public static Date parseDateString(String dataTimeStr) {
        return new Date();
    }

    public static String formatDate(Date date) {
        return "";
    }

    public static String toUnderscore(String str) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }
}
