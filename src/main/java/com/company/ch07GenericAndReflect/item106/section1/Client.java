package com.company.ch07GenericAndReflect.item106.section1;

//抽象主题角色
interface Subject {
    //定义一个方法
    public void request();
}

public class Client {
    public static void main(String[] args) throws Exception {
    }
}

//具体主题角色
class RealSubject implements Subject {
    //实现方法
    public void request() {
        //业务逻辑处理
    }
}

//代理主题角色
class Proxy implements Subject {
    //要代理哪个实现类
    private Subject subject = null;

    //默认被代理者
    public Proxy() {
        subject = new RealSubject();
    }

    //通过构造函数传递被代理者
    public Proxy(Subject _subject) {
        subject = _subject;
    }

    //实现接口中定义的方法
    public void request() {
        before();
        subject.request();
        after();
    }

    //预处理
    private void before() {
        //do something
    }

    //善后处理
    private void after() {
        //do something
    }
}
