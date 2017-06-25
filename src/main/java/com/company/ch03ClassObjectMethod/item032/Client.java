package com.company.ch03ClassObjectMethod.item032;

/**
 * 建议32： 静态变量一定要先声明后赋值
 */
public class Client {
    public static int i = 1;

    static {
        i = 100;
    }

    public static void main(String[] args) {
        System.out.println(i);
    }
}
