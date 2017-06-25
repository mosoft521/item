package com.company.ch02PrimitiveType.item026.section2;

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

    // 计算List之和
    public static int f(List<Integer> list) {
        int count = 0;
        for (Integer i : list) {
            count += (i != null) ? i : 0;
        }
        return count;
    }
}
