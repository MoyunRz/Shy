package com.springmvc.utils;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 判断指定的日期是否在区间内
     * @param nowTime 要判断的日期
     * @param startTime 开始的日期
     * @param endTime 结束的日期
     * @return true 在区间 false 不在区间
     */
    public static boolean isEffectiveDate(Date nowTime ,Date startTime,Date endTime){
        if (nowTime.getTime() == startTime.getTime()) {
            return true;
        }else{
            if(nowTime.getTime() == endTime.getTime()){
                return false; // startTime <= nowTime <= endTime
            }
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


}
