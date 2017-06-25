package com.company.ch08Exception.item114.section1;

public class Client {
    public static void main(String[] args) {
        while (true) {
            Person p = new Person(17);
            p.seeMovie();
        }
        /*其他的逻辑处理*/
    }
}

class Person {
    public Person(int _age) {
        //不满18岁得用户对象不能建立
        if (_age < 18) {
            //throw new RuntimeException("年龄必须大于18岁。");
        }
    }

    //看限制级的电影
    public void seeMovie() {
        System.out.println("看限制级电影");
    }
}