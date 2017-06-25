package com.company.ch03ClassObjectMethod.item038;

/**
 * 建议38： 使用静态内部类提高封装性
 */
public class Client {
    public static void main(String[] args) {
        //定义张三这个人
        Person p = new Person("张三");
        //设置张三的家庭信息
        p.setHome(new Person.Home("上海", "021"));
    }
}
