package com.company.ch01Common.item010;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

/**
 * 建议10：不用在本类中覆盖静态导入的变量和方法
 */
public class Client {
    //常量名与静态导入的PI相同
    // public final static String PI = "祖冲之";
    //方法名与静态导入的相同
//    public static int abs(int abs) {
//        return 0;
//    }
    public static void main(String[] args) {
        System.out.println("PI=" + PI);
        System.out.println("abs(100)=" + abs(-100));
    }
}
