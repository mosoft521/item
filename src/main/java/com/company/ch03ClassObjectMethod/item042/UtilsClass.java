package com.company.ch03ClassObjectMethod.item042;

/**
 * 建议42： 让工具类不可实例化
 */
public class UtilsClass {
    private UtilsClass() {
        throw new Error("不要实例化我！");
    }

    public static void doSomethign() {
        System.out.println("aa");
    }

    public static void main(String[] args) {
        UtilsClass.doSomethign();
    }
}
