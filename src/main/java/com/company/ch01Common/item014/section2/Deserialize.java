package com.company.ch01Common.item014.section2;

public class Deserialize {
    public static void main(String[] args) {
        //技术系统反序列化，并打印信息
        Person p = (Person) SerializationUtils.readObject();
        StringBuffer sb = new StringBuffer();
        sb.append("姓名:" + p.getName());
        sb.append("\t基本工资：" + p.getSalary().getBasePay());
        sb.append("\t绩效工资：" + p.getSalary().getBonus());
        System.out.println(sb);
    }
}
