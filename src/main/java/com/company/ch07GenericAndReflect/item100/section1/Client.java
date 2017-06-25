package com.company.ch07GenericAndReflect.item100.section1;

import java.util.Arrays;
import java.util.List;

public class Client<T> {
    public static <T> T[] toArray(List<T> list) {
        T[] t = (T[]) new Object[list.size()];
        for (int i = 0, n = list.size(); i < n; i++) {
            t[i] = list.get(i);
        }
        return t;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B");
        for (String str : toArray(list)) {
            System.out.println(str);
        }
    }
}
