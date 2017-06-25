package com.company.ch05ArrayAndCollection.item081.section4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        // ���180CM
        list.add(new Person(180));
        // ���175CM
        list.add(new Person(175));
        // �������˴����
        list.get(1).setHeight(185);

        //����
        Collections.sort(list);
        for (Person p : list) {
            System.out.println("���:" + p.getHeight());
        }
    }

    static class Person implements Comparable<Person> {
        // ���
        private int height;

        public Person(int _age) {
            height = _age;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        // �����������
        public int compareTo(Person o) {
            return height - o.height;
        }
    }
}
