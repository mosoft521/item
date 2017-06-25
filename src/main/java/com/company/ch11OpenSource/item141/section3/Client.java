package com.company.ch11OpenSource.item141.section3;

import org.apache.commons.lang3.mutable.MutableInt;

public class Client {
    public static void main(String[] args) {
        //声明一个可变的int类型
        MutableInt mi = new MutableInt(10);
        //mi的值为20
        mi.add(10);
        //自加1，结果为21
        mi.increment();
    }
}
