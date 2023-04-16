package com.bosc.assessment.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.common.base.CaseFormat;

public class CommonUtil {

    public static Date parseDateString(String dataTimeStr) {
        return new Date();
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static List<Date> getLatestNDates(int n) {
        List<Date> resultList = new ArrayList<>();
        if(n <= 0) {
            return resultList;
        }
        Date today = new Date();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(today);
        calendar.add(GregorianCalendar.DATE, -n);
        for(int i = 0; i < n; i++) {
            resultList.add(new Date(calendar.getTime().getTime()));
            calendar.add(GregorianCalendar.DATE, 1);
        }
        return resultList;
    }

    public static String toUnderscore(String str) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }
}
