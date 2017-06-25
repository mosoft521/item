package com.company.ch06EnumAndAnnotation.item086;

enum LogLevel {
    DEBUG, INFO, WARN, ERROR;
}

public class Client {
    public static void main(String[] args) {
        LogLevel logLevel = LogLevel.INFO;
        switch (logLevel) {
            case DEBUG:
                System.out.println("****Debug Log*****");
                break;
            case INFO:
                System.out.println("****Info Log*****");
                break;
            case WARN:
                System.out.println("****Warn Log*****");
                break;
            case ERROR:
                System.out.println("****Error Log*****");
                break;
        }
    }
}
