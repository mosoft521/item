package com.company.ch05ArrayAndCollection.item074.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<String>();
        cities.add("上海");
        cities.add("广州");
        cities.add("广州");
        cities.add("北京");
        cities.add("天津");
        //indexOf方法取得索引值
        int index1 = cities.indexOf("广州");
        //binarySearch查找到索引值
        int index2 = Collections.binarySearch(cities, "广州");
        System.out.println("索引值(indexOf)：" + index1);
        System.out.println("索引值（binarySearch)：" + index2);
    }
}

