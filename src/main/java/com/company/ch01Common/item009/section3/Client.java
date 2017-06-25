package com.company.ch01Common.item009.section3;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.PI;
import static java.text.NumberFormat.getInstance;

public class Client {
    //输入半径和精度要求，计算面积
    public static void main(String[] args) {
        double s = PI * parseDouble(args[0]);
        NumberFormat nf = getInstance();
        nf.setMaximumFractionDigits(parseInt(args[1]));
        formatMessage(nf.format(s));
    }

    //格式化消息输出
    public static void formatMessage(String s) {
        System.out.println("圆面积是：" + s);
    }
}