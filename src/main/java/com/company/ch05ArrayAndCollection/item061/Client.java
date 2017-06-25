package com.company.ch05ArrayAndCollection.item061;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        //一个班级最多容量60个学生
        Stu[] classes = new Stu[60];
        /*classes初始化 ……*/
        //偶尔一个班级可以容纳80人，数组加长
        classes = expandCapacity(classes, 80);
        /*重新初始化超过限额的20人……*/
    }

    //加长数组
    public static <T> T[] expandCapacity(T[] datas, int newLen) {
        // 不能是是负值
        newLen = newLen < 0 ? 0 : newLen;
        // 生成一个新数组，并拷贝原值
        return Arrays.copyOf(datas, newLen);
    }
}

class Stu {
}