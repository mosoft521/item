package com.company.ch01Common.item011;

/**
 * 消息的生产者，也就是序列化类
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("混世魔王");
        //序列化，保存到磁盘上
        SerializationUtils.writeObject(person);
        System.out.println("write ok");
    }
}
