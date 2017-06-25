package com.company.ch11OpenSource.item141.section7;

public class User {
    private String name;
    private int age;

    public User(String _name, int _age) {
        name = _name;
        age = _age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}