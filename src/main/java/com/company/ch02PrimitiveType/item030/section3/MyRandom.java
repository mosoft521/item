package com.company.ch02PrimitiveType.item030.section3;

import java.util.Random;

/**
 * 继承Random类，重写伪随机生成
 * 2011-3-8
 */
public class MyRandom extends Random {
    @Override
    protected int next(int bits) {
        //伪随机数是固定值
        return 11111111;
    }
}
