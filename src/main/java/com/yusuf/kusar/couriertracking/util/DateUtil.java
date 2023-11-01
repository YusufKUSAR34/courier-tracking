package com.yusuf.kusar.couriertracking.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static DateUtil instance;

    private DateUtil() {
    }

    public static synchronized DateUtil getInstance() {
        if (instance == null) {
            instance = new DateUtil();
        }
        return instance;
    }

    public boolean isDateExpired(Date date, Date expireDate) {
        return (expireDate.getTime() - date.getTime()) < 0;
    }

    public Date addToDateByMinutes(Date baseDate, Integer minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(Calendar.MINUTE, minutes);

        return calendar.getTime();
    }
}
