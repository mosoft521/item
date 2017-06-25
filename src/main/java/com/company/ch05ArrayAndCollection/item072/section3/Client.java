package com.company.ch05ArrayAndCollection.item072.section3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        List<String> subList = list.subList(0, 2);
        List<String> subList2 = list.subList(1, 2);
        //原字符串增加一个元素
        //list.add("D");
        subList2.add("D");
        System.out.println("原列表长度：" + list.size());
        System.out.println("子列表长度：" + subList.size());
    }
}
