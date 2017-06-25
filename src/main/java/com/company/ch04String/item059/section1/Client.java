package com.company.ch04String.item059.section1;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        String[] strs = {"张三(Z)", "李四(L)", "王五(W)"};
        //排序，默认是升序
        Arrays.sort(strs);
        int i = 0;
        for (String str : strs) {
            System.out.println((++i) + "、" + str);
        }
        System.out.println(Integer.toHexString('张'));
//		System.out.println((short)"张".charAt(0));
        //CharUtils.toIntValue('李');
    }
}
