package com.company.ch11OpenSource.item143.section3;

import ch.lambdaj.Lambda;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 计算平均值
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(10);
        ints.add(100);
        ints.add(100);
        System.out.println(Lambda.avg(ints));
        // 统计每个元素出现的次数
        System.out.println(Lambda.count(ints));
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("A", 30));
        persons.add(new Person("B", 20));
        // 按照年龄排序
        System.out.println(Lambda.sort(persons, Lambda.on(Person.class)
                .getAge()));
        // 串联所有的元素指定属性
        System.out.println(Lambda.joinFrom(persons).getName());
        // 过滤出年龄大于20岁得所用元素
        System.out.println(Lambda.select(persons, new BaseMatcher<Person>() {
            @Override
            public boolean matches(Object _person) {
                Person p = (Person) _person;
                return p.getAge() > 20;
            }

            @Override
            public void describeTo(Description desc) {
                desc.appendText("过滤掉大于200");
            }
        }));
        // 最大年龄
        System.out.println(Lambda.maxFrom(persons).getAge());
        // 抽取出所有姓名成为一个数组
        System.out.println(Lambda.extract(persons, Lambda.on(Person.class)
                .getName()));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String _name, int _age) {
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

    public String toString() {
        return "name:" + name + ",age =" + age;
    }
}
