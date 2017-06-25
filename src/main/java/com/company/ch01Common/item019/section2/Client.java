package com.company.ch01Common.item019.section2;

import java.util.List;

public class Client {
    public static void main(String[] args) {
    }

    public void doSomething(List list, Object element) {
        assert list.remove(element) : "删除元素 " + element + " 失败";
        /*业务处理*/
    }
}