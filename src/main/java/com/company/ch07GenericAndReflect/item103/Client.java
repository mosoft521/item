package com.company.ch07GenericAndReflect.item103;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws Exception {
        //反射获取方法
        Method m1 = Foo.class.getMethod("doStuff");
        //打印出是否可访问
        System.out.println("Accessible = " + m1.isAccessible());
        //执行方法
        m1.invoke(new Foo());
    }
}
