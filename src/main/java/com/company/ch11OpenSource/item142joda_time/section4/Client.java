package com.company.ch11OpenSource.item142joda_time.section4;

import org.joda.time.DateTime;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        DateTime dt = new DateTime();
        System.out.println(dt);

        // Joda的DateTime转为jdk的Date
        Date jdkDate = dt.toDate();
        // JDK的Date转为Joda的DateTime
        dt = new DateTime(jdkDate);

        System.out.println(dt);
        System.out.println(jdkDate);
    }
}
