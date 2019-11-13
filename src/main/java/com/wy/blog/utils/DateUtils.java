package com.wy.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 将日期按照指定格式转换成字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 将字符串按照指定格式转换成日期格式
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date stringtoDate(String dateStr,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(dateStr);
        return date;

    }
}
