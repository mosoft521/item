package com.company.ch05ArrayAndCollection.item075.section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int max = 1200000;
        List<String> cities = new ArrayList<String>();
        for (int i = 0; i < max; i++) {
            cities.add(i + "");
        }
        //indexOf方法取得索引值
        long start = System.nanoTime();
        int index1 = cities.indexOf((max - 5) + "");
        long mid = System.nanoTime();
        System.out.println(mid - start);
        //binarySearch查找到索引值
        int index2 = Collections.binarySearch(cities, (max - 5) + "");
        long end = System.nanoTime();
        System.out.println(end - mid);
        System.out.println("索引值(indexOf)：" + index1);
        System.out.println("索引值（binarySearch)：" + index2);
    }
}