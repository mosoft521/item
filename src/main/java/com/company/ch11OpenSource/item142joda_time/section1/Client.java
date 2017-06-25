package com.company.ch11OpenSource.item142joda_time.section1;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Locale;

public class Client {
    public static void main(String[] args) {
        //当前时间戳
        DateTime dt = new DateTime();
        //输出英文星期
        System.out.println(dt.dayOfWeek().getAsText(Locale.ENGLISH));
        //本地日期格式
        System.out.println(dt.toLocalDate());
        //日期格式化
        System.out.println(dt.toString(DateTimeFormat.forPattern("yyyy年M月d日")));
    }
}
