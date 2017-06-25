package com.company.ch02PrimitiveType.item025;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Client {
    public static void main(String[] args) {
//        //存款
//        BigDecimal d = new BigDecimal(888888);
//        //月利率，乘3计算季利率
//        BigDecimal r = new BigDecimal(0.001875 * 3);
//        //计算利息
//        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
//        System.out.println("季利息是：" + i);
//
//        BigDecimal b = new BigDecimal(2.51);
//        System.out.println(b.setScale(1, RoundingMode.UP));
        //银行家算法:
        //四舍六入五考虑:五后非零就进一,五后为0看奇偶,五前为偶应舍去,五前为奇要进一.
        BigDecimal b = new BigDecimal("10.556");
        System.out.println(b + "->" + b.setScale(2, RoundingMode.HALF_EVEN));
        b = new BigDecimal("10.554");
        System.out.println(b + "->" + b.setScale(2, RoundingMode.HALF_EVEN));
        b = new BigDecimal("10.5551");//五后非零就进一
        System.out.println(b + "->" + b.setScale(2, RoundingMode.HALF_EVEN));
        b = new BigDecimal("10.5450");//五后为0看奇偶
        System.out.println(b + "->" + b.setScale(2, RoundingMode.HALF_EVEN));
        b = new BigDecimal("10.555");//五前为奇要进一
        System.out.println(b + "->" + b.setScale(2, RoundingMode.HALF_EVEN));
        b = new BigDecimal("10.545");//五前为偶应舍去
        System.out.println(b + "->" + b.setScale(2, RoundingMode.HALF_EVEN));
    }
}