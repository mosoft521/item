package com.company.ch05ArrayAndCollection.item065.section1;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        List list = Arrays.asList(data);
        System.out.println("列表中的元素数量是：" + list.size());
    }
}
