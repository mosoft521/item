package com.company.ch08Exception.item113.section2;

public class Client {
    public static void main(String[] args) {
        System.out.println(doStuff());
        System.out.println(doStuff2().getName());
    }

    public static int doStuff() {
        int a = 1;
        try {
            return a;
        } catch (Exception e) {
        } finally {
            //重新修改一下返回值
            a = -1;
        }
        return 0;
    }

    public static Person doStuff2() {
        Person person = new Person();
        person.setName("张三");
        try {
            return person;
        } catch (Exception e) {
        } finally {
            //重新修改一下返回值
            person.setName("李四");
        }
        person.setName("王五");
        return person;
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
