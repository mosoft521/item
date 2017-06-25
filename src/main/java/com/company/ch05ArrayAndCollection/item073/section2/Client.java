package com.company.ch05ArrayAndCollection.item073.section2;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum Position {
    Boss, Manager, Staff
}

public class Client {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>(3);
        //一个老板
        list.add(new Employee(1001, "张三", Position.Boss));
        //两个经理
        list.add(new Employee(1006, "赵七", Position.Manager));
        list.add(new Employee(1003, "王五", Position.Manager));
        //两个职员
        list.add(new Employee(1002, "李四", Position.Staff));
        list.add(new Employee(1005, "马六", Position.Staff));
        //按照id排序，也就是按照资历深浅排序
        Collections.sort(list);
        for (Employee e : list) {
            System.out.println(e);
        }
        System.out.println("----");
        Collections.sort(list, new PositionComparator());
        for (Employee e : list) {
            System.out.println(e);
        }
        System.out.println("************");
        Collections.reverse(list);
        for (Employee e : list) {
            System.out.println(e);
        }
        System.out.println("----");
        Collections.sort(list, Collections.reverseOrder(new PositionComparator()));
        for (Employee e : list) {
            System.out.println(e);
        }
    }
}

class Employee implements Comparable<Employee> {
    //id是根据进入公司的先后顺序编码的
    private int id;
    //姓名
    private String name;
    //职位
    private Position position;

    public Employee(int _id, String _name, Position _position) {
        id = _id;
        name = _name;
        position = _position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //按照id号排序，也就是资历的深浅排序
    @Override
    public int compareTo(Employee o) {
        return new CompareToBuilder()
                .append(position, o.position)
                .append(o.id, id).toComparison();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

//职位排序器
class PositionComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        //按照职位降序排列
        return o1.getPosition().compareTo(o2.getPosition());
    }
}
