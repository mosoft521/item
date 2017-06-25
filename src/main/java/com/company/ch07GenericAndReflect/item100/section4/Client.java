package com.company.ch07GenericAndReflect.item100.section4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Client<T> {
    public static <T> T[] toArray(List<T> list, Class<T> tClass) {
        //声明并初始化一个T类型的数组
        T[] t = (T[]) Array.newInstance(tClass, list.size());
        for (int i = 0, n = list.size(); i < n; i++) {
            t[i] = list.get(i);
        }
        return t;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B");
        for (String str : toArray(list, String.class)) {
            System.out.println(str);
        }
    }
}