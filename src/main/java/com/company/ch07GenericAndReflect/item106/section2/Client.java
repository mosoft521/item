package com.company.ch07GenericAndReflect.item106.section2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 抽象主题角色
interface Subject {
    // 定义一个方法
    public void request();
}

public class Client {
    public static void main(String[] args) {
        //具体主题角色，也就是被代理类
        Subject subject = new RealSubject();
        //代理实例的处理Handler
        InvocationHandler handler = new SubjectHandler(subject);
        //当前加载器
        ClassLoader cl = subject.getClass().getClassLoader();
        //动态代理
        Subject proxy = (Subject) Proxy.newProxyInstance(cl, subject.getClass().getInterfaces(), handler);
        //执行具体主题角色方法
        proxy.request();
    }
}

// 具体主题角色
class RealSubject implements Subject {
    // 实现方法
    public void request() {
        // 业务逻辑处理
    }
}

class SubjectHandler implements InvocationHandler {
    // 被代理的对象
    private Subject subject;

    public SubjectHandler(Subject _subject) {
        subject = _subject;
    }

    //委托处理方法
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //预处理
        System.out.println("预处理");
        //直接调用被代理类的方法
        Object obj = method.invoke(subject, args);
        //后处理
        System.out.println("后处理");
        return obj;
    }
}