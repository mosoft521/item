package com.company.ch07GenericAndReflect.item096.section1;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        read(Arrays.asList("A"));
    }

    public static <E> void read(List<? super E> list) {
        for (Object obj : list) {
            //业务逻辑操作
        }
    }
}