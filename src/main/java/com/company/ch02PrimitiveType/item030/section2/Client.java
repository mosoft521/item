package com.company.ch02PrimitiveType.item030.section2;

import java.util.Random;

/**
 * 设置了固定种子的随机数
 * 2011-3-8
 */
public class Client {
    public static void main(String[] args) {
        Random random = new Random(10000);
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次：" + random.nextInt());
        }
    }
}
