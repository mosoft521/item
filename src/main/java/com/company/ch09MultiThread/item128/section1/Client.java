package com.company.ch09MultiThread.item128.section1;

public class Client {
    public static void main(String[] args) {
        new Thread(new Foo()).start();
    }
}

class Foo implements Runnable {
    @Override
    public void run() {
        //执行递归函数
        fun(10);
    }

    //递归函数
    public synchronized void fun(int i) {
        if (--i > 0) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(i);
            fun(i);
        }
    }
}
