package com.company.ch08Exception.item110.section3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            doStuff();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void doStuff() throws MyException {
        List<Throwable> list = new ArrayList<Throwable>();
        // 第一个逻辑片段
        try {
            // Do Something
        } catch (Exception e) {
            list.add(e);
        }
        // 第二个逻辑片段
        try {
            // Do Something
        } catch (Exception e) {
            list.add(e);
        }
        if (list.size() > 0) {
            throw new MyException(list);
        }
    }
}

class MyException extends Exception {
    // 容纳所有的异常
    private List<Throwable> causes = new ArrayList<Throwable>();

    // 构造函数，传递一个异常列表
    public MyException(List<? extends Throwable> _causes) {
        causes.addAll(_causes);
    }

    // 读取所有的异常
    public List<Throwable> getExceptions() {
        return causes;
    }
}
