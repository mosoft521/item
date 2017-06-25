package com.company.ch01Common.item001.section5;

/**
 * 注意变量位置
 */
public class Client {
    public static int age;

    //定义一个人的年龄
    //静态代码块
    static {
        age = 100;
    }

    public static void main(String[] args) {
        System.out.println("Your age is：" + age);
    }
}
