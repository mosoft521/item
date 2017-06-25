package com.company.ch05ArrayAndCollection.item070;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //定义一个包含两个字符串的列表
        List<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");
        //构造一个包含c的字符串列表
        List<String> c1 = new ArrayList<String>(c);
        //通过subList生成与c相同的列表
        List<String> c2 = c.subList(0, c.size());
        //c2增加一个元素
        c2.add("C");
        System.out.println("c == c1? " + c.equals(c1));
        System.out.println("c == c2? " + c.equals(c2));
    }
}
