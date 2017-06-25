package com.company.ch07GenericAndReflect.item096.section3;

import java.util.List;

public class Client {
    public static void main(String[] args) {
    }

    public static void write(List<? extends Number> list) {
        list.add(null);
    }
}
