package com.company.ch03ClassObjectMethod.item031;

//在接口中存在实现代码
interface B {
    public static final S s = new S() {
        public void doSomething() {
            System.out.println("我在接口中实现了");
        }
    };
}

//被实现的接口
interface S {
    public void doSomething();
}

/**
 * 建议31:在接口中不要存在实现代码
 */
public class Client {
    public static void main(String[] args) {
        //调用接口的实现
        B.s.doSomething();
    }
}
