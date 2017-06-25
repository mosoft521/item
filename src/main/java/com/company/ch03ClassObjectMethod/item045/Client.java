package com.company.ch03ClassObjectMethod.item045;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Person p1 = new Person("张三");
        Person p2 = new Person("张三 ");
        List<Person> l = new ArrayList<Person>();
        l.add(p1);
        l.add(p2);
        System.out.println("列表中是否包含张三：" + l.contains(p1));
        System.out.println("列表中是否包含张三 ：" + l.contains(p2));
    }
}

class Person {
    private String name;

    public Person(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return name.equalsIgnoreCase(p.getName().trim());
        }
        return false;
    }
}