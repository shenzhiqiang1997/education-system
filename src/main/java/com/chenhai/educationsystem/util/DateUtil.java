package com.chenhai.educationsystem.util;


import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public Date getTomorrowBegin(){
        Date endOfToday = getEndOfToday();
        return new Date(endOfToday.getTime()+1000);
    }

    public Date getTomorrowEnd(){
        Date endOfToday = getEndOfToday();
        return new Date(endOfToday.getTime()+24*3600*1000);
    }

    private Date getEndOfToday(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                23,59,59);
        return calendar.getTime();
    }
}
