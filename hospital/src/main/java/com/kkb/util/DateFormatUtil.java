package com.kkb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String format(Date date){
        if(date==null){
            return "-";
        }
        return format.format(date);
    }

    public static long toTime(String formatString){
        long time = 0;
        try {
            time = format.parse(formatString).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}