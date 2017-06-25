package com.company.ch01Common.item002;

import java.util.Random;

/*接口常量*/
interface Const {
    //这还是常量吗？
    public static final int RAND_CONST = new Random().nextInt();
}

/**
 * 莫让常量变成变量
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("常量会变哦：" + Const.RAND_CONST);
    }
}
