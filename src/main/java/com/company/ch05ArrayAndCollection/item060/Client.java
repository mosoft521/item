package com.company.ch05ArrayAndCollection.item060;

import java.util.ArrayList;
import java.util.List;

public class Client {
    //测试性能执行的循环次数
    private static final int LOOP_NUM = 100000;

    public static void main(String[] args) {
        int[] score = new int[100];
        //初始化数组和列表
        List<Integer> list = new ArrayList<Integer>(100);
        for (int i = 0; i < score.length; i++) {
            score[i] = i;
            list.add(i);
        }
        //测试数组性能
        long begin = System.currentTimeMillis();
        for (int i = 0; i < LOOP_NUM; i++) {
            sum(score);
        }
        long end = System.currentTimeMillis();
        System.out.println("数组(Array)执行时间：" + (end - begin) + " ms");
        //测试列表执行时间
        for (int i = 0; i < LOOP_NUM; i++) {
            sum(list);
        }
        System.out.println("列表(List)执行时间：" + (System.currentTimeMillis() - end) + " ms");
    }

    //对数组求和
    public static int sum(int[] datas) {
        int sum = 0;
        for (int i = 0; i < datas.length; i++) {
            sum += datas[i];
        }
        return sum;
    }

    //对列表求和计算
    public static int sum(List<Integer> datas) {
        int sum = 0;
        for (int i = 0; i < datas.size(); i++) {
            sum += datas.get(i);
        }
        return sum;
    }
}
