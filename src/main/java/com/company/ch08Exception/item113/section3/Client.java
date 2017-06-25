package com.company.ch08Exception.item113.section3;

public class Client {
    public static void doSomething() {
        try {
            //正常抛出异常
            throw new RuntimeException();
        } finally {
            return;
        }
    }

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (RuntimeException e) {
            System.out.println("这里永远都不会到达！");
        }
    }
}
