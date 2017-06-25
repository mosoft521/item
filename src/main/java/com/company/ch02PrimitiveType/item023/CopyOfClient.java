package com.company.ch02PrimitiveType.item023;

public class CopyOfClient {
    //光速是30万公里/秒
    public static final int LIGHT_SPEED = 30 * 10000 * 1000;

    public static void main(String[] args) {
        System.out.println("题目1：月亮光想照射到地球需要1秒，计算月亮和地球的距离");
        long dis1 = LIGHT_SPEED * 1;
        System.out.println("月亮与地球的距离是：" + dis1 + " 米");
        System.out.println("--------------------------------------------");
        System.out.println("题目2：太阳光照射到地球上需要8分钟，计算太阳到地球的距离。");
        //可能要超出整数范围，使用long型
        long dis2 = 1L * LIGHT_SPEED * 60 * 8;
        System.out.println("太阳与地球的距离是：" + dis2 + " 米");
    }
}