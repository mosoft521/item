package com.company.ch05ArrayAndCollection.item071;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 初始化一个固定长度，不可变列表
        List<Integer> initData = Collections.nCopies(100, 0);
        // 转换为可变列表
        List<Integer> list = new ArrayList<Integer>(initData);
        // 遍历，删除符合条件的元素
//		for (int i = 0, size = list.size(); i < size; i++) {
//			System.out.println(list.get(i));
//			if (i >= 20 && i < 30) {
//				list.remove(i);
//			}
//		}
        for (int i = 20; i < 30; i++) {
            if (i < list.size()) {
                list.remove(i);
            }
        }
    }
}
