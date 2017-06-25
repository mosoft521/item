package com.company.ch03ClassObjectMethod.item037.section2;

/**
 * @author Phenix
 *         2011-3-17
 */
public class Client {
    public static void main(String[] args) {
        new Sub();
    }
}

class Base {
    {
        System.out.println("1、父类构造代码块");
    }

    public Base() {
        System.out.println("2、父类构造函数");
    }
}

class Sub extends Base {
    {
        System.out.println("3、子类构造代码块");
    }

    public Sub() {
        super();
        System.out.println("4、子类构造函数");
    }
}