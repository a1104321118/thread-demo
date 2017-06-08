package com.hr.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
public class DateUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String dateToString(Date date){
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String dateStr) throws ParseException {
        return simpleDateFormat.parse(dateStr);
    }
}
