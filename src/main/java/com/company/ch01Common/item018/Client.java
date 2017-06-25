package com.company.ch01Common.item018;

import java.util.Date;

/**
 * 避免instanceof非预期结果
 */
@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) {
        //String对象是否是Object的实例
        boolean b1 = "Sting" instanceof Object;//T
        //String对象是否是String的实例
        boolean b2 = new String() instanceof String;//T
        //Object对象是否是String的实例
        boolean b3 = new Object() instanceof String;//F
        //拆箱类型是否是装箱类型的实例
        //	boolean b4 = 'A' instanceof Character;
        //空对象是否是String的实例
        boolean b5 = null instanceof String;//F
        //类型转换后的空对象是否是String的实例
        boolean b6 = (String) null instanceof String;//F
        //Date对象是否是String的实例
        //	boolean b7 = new Date() instanceof String;
        //在泛型类中判断String对象是否是Date的实例
        boolean b8 = new GenericClass<String>().isDateInstance("");//F
//        boolean b9 = new GenericClass<String>().isDateInstance("");//F
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
//        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
//        System.out.println(b7);
        System.out.println(b8);
//        System.out.println(b9);
    }
}

class GenericClass<T> {
    //判断是否是Date类型
    public boolean isDateInstance(T t) {
        return t instanceof Date;
    }
}
