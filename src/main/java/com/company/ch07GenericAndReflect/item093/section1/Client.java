package com.company.ch07GenericAndReflect.item093.section1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("abc");
        String str = list.get(0);
    }

    public void doSomething() {
        List list = new ArrayList();
        list.add("abc");
        String str = (String) list.get(0);
    }
}
