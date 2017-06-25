package com.company.ch01Common.item011;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 3424643650528555799L;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void test() {
    }
}
