package com.company.ch05ArrayAndCollection.item064.section2;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Client {
    public static void main(String[] args) {
        Integer[] data = {15, 10, 14, 9, 15};
        System.out.println(getSecond(data));
    }

    public static int getSecond(Integer[] data) {
        //转换为列表
        List<Integer> dataList = Arrays.asList(data);
        //转换为TreeSet，删除重复元素
        TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
        //取得比最大值小的最大值，也就是老二了
        return ts.lower(ts.last());
    }
}
