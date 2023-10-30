package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    public static int getDayOfWeek(String time) {
        // 解析出时间字符串中的星期几信息
        String dayOfWeekString = time.substring(1, 2); // "周三" 中的 "三"

        // 将星期几转换为 Calendar 类的常量
        int dayOfWeek;
        switch (dayOfWeekString) {
            case "一":
                dayOfWeek = Calendar.MONDAY;
                break;
            case "二":
                dayOfWeek = Calendar.TUESDAY;
                break;
            case "三":
                dayOfWeek = Calendar.WEDNESDAY;
                break;
            case "四":
                dayOfWeek = Calendar.THURSDAY;
                break;
            case "五":
                dayOfWeek = Calendar.FRIDAY;
                break;
            case "六":
                dayOfWeek = Calendar.SATURDAY;
                break;
            case "天":
                dayOfWeek = Calendar.SUNDAY;
                break;
            default:
                throw new IllegalArgumentException("Invalid day of week: " + dayOfWeekString);
        }

        return dayOfWeek;
    }

    public static int getTimeSlot(String time) {
        String startTimeString = time.substring(3, 8); // "周三18:30-20:50" 中的 "18:30"

        // 将起始时间转换为 Date 对象
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date startTime;
        try {
            startTime = format.parse(startTimeString);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing time: " + startTimeString);
        }

        // 根据具体的起始时间确定对应的节数
        int timeSlot = 1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);

        while (calendar.get(Calendar.HOUR_OF_DAY) > 8) {
            timeSlot++;
            calendar.add(Calendar.MINUTE, -30); // 回退30分钟
        }

        return timeSlot;
    }

}
