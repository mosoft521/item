package com.company.ch03ClassObjectMethod.item047;

public class Client {
    public static void main(String[] args) {
        Employee e1 = new Employee("张三", 100);
        Employee e2 = new Employee("张三", 1001);
        Person p1 = new Person("张三");
        System.out.println(p1.equals(e1));
        System.out.println(p1.equals(e2));
        System.out.println(e1.equals(e2));
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

    public void setName(String _name) {
        this.name = _name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Person p = (Person) obj;
            if (p.getName() == null || name == null) {
                return false;
            } else {
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }
}

class Employee extends Person {
    private int id;

    public Employee(String _name, int _id) {
        super(_name);
        id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            return super.equals(obj) && e.getId() == id;
        }
        return false;
    }
}
