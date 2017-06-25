package com.company.ch07GenericAndReflect.item096.section4;

import java.util.List;

public class Client {
    public static void main(String[] args) {
    }

    public static void write(List<? super Number> list) {
        list.add(123);
        list.add(3.14);
    }
}
