package com.company.ch08Exception.item115.sectioin2;

public class Client {
    public static void main(String[] args) {
        Invoker.m1();
        Invoker.m2();
    }
}

class Foo {
    public static boolean m() {
        // 取得当前栈信息
        StackTraceElement[] sts = new Throwable().getStackTrace();
        // 检查是否是m1方法调用
        for (StackTraceElement st : sts) {
            if (st.getMethodName().equals("m1")) {
                return true;
            }
        }
        throw new RuntimeException("除m1方法外，该方法不允许其他方法调用");
    }
}

class Invoker {
    // 该方法打印出true
    public static void m1() {
        System.out.println(Foo.m());
    }

    // 该方法打印出false
    public static void m2() {
        System.out.println(Foo.m());
    }
}
