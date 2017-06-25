package com.company.ch07GenericAndReflect.item095.section1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //正规用法
        List<String> list1 = ArrayUtils.asList("A", "B");
        //参数为空
        List list2 = ArrayUtils.asList();
        //参数为数字和字符串的混合
        List list3 = ArrayUtils.asList(1, 2, 3.1);
    }
}

class ArrayUtils {
    //把一个变长参数转变为列表
    public static <T> List<T> asList(T... t) {
        List<T> list = new ArrayList<T>();
        Collections.addAll(list, t);
        return list;
    }
}
