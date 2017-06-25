package com.company.ch07GenericAndReflect.item097.section1;

public class Client {
    public static void main(String[] args) {
    }
}

class Base {
    public Number doStuff() {
        return 0;
    }
}

class Sub extends Base {
    @Override
    public Integer doStuff() {
        return 0;
    }
}