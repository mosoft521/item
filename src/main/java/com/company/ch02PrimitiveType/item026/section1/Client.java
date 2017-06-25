package com.company.ch02PrimitiveType.item026.section1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(null);
        System.out.println(f(list));
    }

    //计算list中所有元素之和
    public static int f(List<Integer> list) {
        int count = 0;
        for (int i : list) {
            count += i;
        }
        return count;
    }
}