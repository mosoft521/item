package com.company.ch06EnumAndAnnotation.item084.section1;

enum Season {
    Spring("春"), Summer("夏"), Autumn("秋"), Winter("冬");
    private String desc;

    Season(String _desc) {
        desc = _desc;
    }

    //获得枚举值
    public String getDesc() {
        return desc;
    }
}

public class Client {
    public static void main(String[] args) {
        System.out.println(Season.Spring.getDesc());
    }
}
