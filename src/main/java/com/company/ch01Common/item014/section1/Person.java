package com.company.ch01Common.item014.section1;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 60407L;
    //姓名
    private String name;
    //薪水
    private Salary salary;

    public Person(String _name, Salary _salary) {
        name = _name;
        salary = _salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}