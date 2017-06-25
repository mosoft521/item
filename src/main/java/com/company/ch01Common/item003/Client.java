package com.company.ch01Common.item003;

/**
 * 三元操作符两个操作数的类型必须一致
 */
public class Client {
    public static void main(String[] args) {
        int i = 80;
        String s = String.valueOf(i < 100 ? 90 : 100);
        String s1 = String.valueOf(i < 100 ? 90 : 100.0);
        System.out.println("两者是否相等:" + s.equals(s1));
    }
}
