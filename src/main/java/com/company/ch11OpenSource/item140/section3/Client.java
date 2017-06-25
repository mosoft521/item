package com.company.ch11OpenSource.item140.section3;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Client {
    public static void main(String[] args) {
        Table<Double, Double, String> l = HashBasedTable.create();
        //定义人民广场的经纬度坐标
        l.put(31.23, 121.48, "人民广场");
        System.out.println(l.get(31.23, 121.48));
    }
}
