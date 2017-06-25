package com.company.ch11OpenSource.item140.section4;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Client {
    public static void main(String[] args) {
        //Table，完全类似数据库表
        Table<Integer, Integer, String> user = HashBasedTable.create();
        //第一行，第一列的值是张三
        user.put(1, 1, "张三");
        //第一行，第二列的值是李四
        user.put(1, 2, "李四");
        System.out.println(user.get(1, 1));
    }
}
