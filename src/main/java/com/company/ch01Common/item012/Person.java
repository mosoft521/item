package com.company.ch01Common.item012;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 91282334L;
    //不变量初始不赋值
    public final String name;

    //构造函数为不变量赋值
    public Person() {
//        name = "德天使";
        name = "地狱使者";
    }
}
