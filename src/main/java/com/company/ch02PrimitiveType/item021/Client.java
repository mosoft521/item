package com.company.ch02PrimitiveType.item021;

import java.util.Scanner;

/**
 * 全面考虑奇偶数判断
 */
public class Client {
    public static void main(String[] args) {
        //接收键盘输入参数
        Scanner input = new Scanner(System.in);
        System.out.print("请输入多个数字判断奇偶：");
        while (input.hasNextInt()) {
            int i = input.nextInt();
//            String str = i + "->" + (i % 2 == 1 ? "奇数" : "偶数");
            String str = i + "->" + (i % 2 == 0 ? "偶数" : "奇数");
            System.out.println(str);
        }
    }
}

class MockUtils {
    //模拟取余计算,dividend被除数，divisor除数
    public static int remainder(int dividend, int divisor) {
        return dividend - dividend / divisor * divisor;
    }
}