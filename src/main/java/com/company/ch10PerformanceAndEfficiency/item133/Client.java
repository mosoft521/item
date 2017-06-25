package com.company.ch10PerformanceAndEfficiency.item133;

public class Client {
    public static void main(String[] args) {
        // 循环10万次
        final int maxLoops = 10 * 10000;
        int loops = 0;
        // 开始时间
        long start = System.nanoTime();
        // “母”对象
        Apple apple = new Apple();
        while (++loops < maxLoops) {
            apple.clone();
        }
        long mid = System.nanoTime();
        System.out.println("clone方法生成对象耗时：" + (mid - start) + " ns");
        // new生成对象
        while (--loops > 0) {
            new Apple();
        }
        long end = System.nanoTime();
        System.out.println("new生成对象耗时：" + (end - mid) + " ns");
    }

    private static class Apple implements Cloneable {
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new Error();
            }
        }
    }
}
