package com.company.ch05ArrayAndCollection.item064.section1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int[] data = new int[10000];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1000000);
        }
        int max2 = max2(data);
        int max = max(data);
        System.out.println(max3(data));
    }

    // 快速排序算法求最大值
    public static int max(int[] data) {
        int max = data[0];
        for (int i : data) {
            max = max > i ? max : i;
        }
        return max;
    }

    // 数组先排序再取最大值
    public static int max2(int[] data) {
        // 先排序
        Arrays.sort(data.clone());
        // 然后取值
        return data[data.length - 1];
    }

    //转化成List，然后去最大值
    public static int max3(int[] data) {
        List list = Arrays.asList(data);
        System.out.println(list.size());
        return 0;
    }
}
