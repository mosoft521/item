package com.company.ch11OpenSource.item142joda_time.section2;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.MutableDateTime;

public class Client {
    public static void main(String[] args) {
        // 当前时间戳
        DateTime dt = new DateTime();
        // 加100小时是星期几，
        System.out.println(dt.plusHours(100).dayOfWeek().getAsText());
        // 100天后的日期
        System.out.println(dt.plusHours(100).toLocalDate());
        // 10年前的今天是星期几
        System.out.println(dt.minusYears(10).dayOfWeek().getAsText());
        // 离地球毁灭还有多少小时
        System.out.println(Hours.hoursBetween(dt, new DateTime("2012-12-21")).getHours());
        // 当前可变时间
        MutableDateTime mdt = new MutableDateTime();
        // 10年后的日期
        DateTime destDateTime = dt.plusYears(10);
        while (mdt.isBefore(destDateTime)) {
            // 循环一次加1天
            mdt.addDays(1);
            // 是13号，并且是星期五
            if (mdt.getDayOfMonth() == 13 && mdt.getDayOfWeek() == 5) {
                // 打印出10年内所有黑色星期五
                System.out.println("黑色星期五：" + mdt);
            }
        }
        System.out.println(Long.MAX_VALUE);
    }
}
