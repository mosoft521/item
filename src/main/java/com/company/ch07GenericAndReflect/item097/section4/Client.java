package com.company.ch07GenericAndReflect.item097.section4;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //数组支持协变
        Number[] n = new Integer[10];
        //编译不通过，泛型不支持协变
        //List<Number> ln = new ArrayList<Integer>();
        //Number的子类型都可以是泛型参数类型
        List<? extends Number> ln = new ArrayList<Integer>();
        //Integer的父类型(包括Integer)都可以是泛型参数类型
        List<? super Integer> li = new ArrayList<Number>();
        //所有类型都可以是泛型参数类型
        List<?> l = new ArrayList<Integer>();
    }
}

class Base {
    public void doStuff(Integer i) {
    }
}

class Sub extends Base {
    public void doStuff(Number n) {
    }
}