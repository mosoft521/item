package com.company.ch03ClassObjectMethod.item035;

/**
 * 建议35： 避免在构造函数中初始化其他类
 */
public class Client {
    public static void main(String[] args) {
        Son s = new Son();
        s.doSomething();
    }
}

//父类
class Father {
    Father() {
        new Other();
    }
}

//子类
class Son extends Father {
    public void doSomething() {
        System.out.println("Hi,show me something");
    }
}

//相关类
class Other {
    public Other() {
        new Son();
    }
}