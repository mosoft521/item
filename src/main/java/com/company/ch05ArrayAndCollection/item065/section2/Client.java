package com.company.ch05ArrayAndCollection.item065.section2;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        List list = Arrays.asList(data);
        System.out.println("元素类型：" + list.get(0).getClass());
        System.out.println("前后是否相等：" + data.equals(list.get(0)));
    }
}
