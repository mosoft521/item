package com.company.ch07GenericAndReflect.item097.section3;

public class Client {
    public static void main(String[] args) {
        Base base = new Sub();
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