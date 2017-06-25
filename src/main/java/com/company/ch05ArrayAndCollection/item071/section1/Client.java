package com.company.ch05ArrayAndCollection.item071.section1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //初始化一个固定长度，不可变列表
        List<Integer> initData = Collections.nCopies(100, 0);
        //转换为可变列表
        ArrayList<Integer> list = new ArrayList<Integer>(initData);
        //删除指定范围的元素
        list.subList(20, 30).clear();
    }
}
