package com.company.ch01Common.item012;

/**
 * 序列化类避免在构造函数中为不变量赋值
 */
public class Deserialize {
    public static void main(String[] args) {
        //反序列化
        Person p = (Person) SerializationUtils.readObject();
        System.out.println(p.name);
    }
}
