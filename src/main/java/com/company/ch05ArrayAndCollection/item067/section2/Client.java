package com.company.ch05ArrayAndCollection.item067.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        // 学生数量,80万
        int stuNum = 80 * 10000;
        // List集合，记录所有学生的分数
        List<Integer> scores = new ArrayList<Integer>(stuNum);
        // 写入分数
        for (int i = 0; i < stuNum; i++) {
            scores.add(new Random().nextInt(150));
        }
        // 记录开始计算时间
        long start = System.currentTimeMillis();
        System.out.println("平均分是：" + average(scores));
        System.out.println("执行时间：" + (System.currentTimeMillis() - start)
                + "ms");
    }

    // 计算平均数
    public static int average(List<Integer> list) {
        int sum = 0;
        // 遍历求和
        for (int i = 0, size = list.size(); i < size; i++) {
            sum += list.get(i);
        }
        // 除以人数，计算平均值
        return sum / list.size();
    }
}
