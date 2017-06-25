package com.company.ch03ClassObjectMethod.item037.section1;

/**
 * 建议37： 构造代码块会想你所想
 */
public class Client {
    public static void main(String[] args) {
        new Base();
        new Base("");
        new Base(0);
        System.out.println("实例对象数量：" + Base.getNumOfObjects());
    }
}

class Base {
    private static int numOfObjects = 0;

    {
        //构造代码块，计算产生对象数量
        numOfObjects++;
    }

    public Base() {
    }

    //有参构造调用无参构造
    public Base(String _str) {
        this();
    }

    //有参构造不调用其他构造
    public Base(int _i) {
    }

    //返回在一个JVM中，创建了多少个实例对象
    public static int getNumOfObjects() {
        return numOfObjects;
    }
}
