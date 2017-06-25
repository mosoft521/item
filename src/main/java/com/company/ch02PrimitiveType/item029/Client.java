package com.company.ch02PrimitiveType.item029;

public class Client {
    public static void main(String[] args) {
        Client cilent = new Client();
        int i = 140;
        //分别传递int类型和Integer类型
        cilent.f(i);
        cilent.f(Integer.valueOf(i));
    }

    public void f(long a) {
        System.out.println("基本类型的方法被调用");
    }

    public void f(Long a) {
        System.out.println("包装类型的方法被调用");
    }
}
