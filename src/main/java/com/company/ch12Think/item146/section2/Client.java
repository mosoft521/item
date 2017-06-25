package com.company.ch12Think.item146.section2;

public class Client {
}

class Foo {
    //默认值为0
    private int num;

    //取值
    public int getNum() {
        return num;
    }

    //输入int类型变量，无返回值
    public void setNum(int num) {
        this.num = num;
    }

    public void doSomething() {
        //自增
        num++;
    }
}
