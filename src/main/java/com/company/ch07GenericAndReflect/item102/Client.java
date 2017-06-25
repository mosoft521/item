package com.company.ch07GenericAndReflect.item102;

import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws Exception {
        //方法名称
        String methodName = "doStuff";
        Method m1 = Foo.class.getDeclaredMethod(methodName);
        Method m2 = Foo.class.getMethod(methodName);
    }

    static class Foo {
        void doStuff() {
        }
    }
}
