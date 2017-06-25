package com.company.ch08Exception.item116.section1;

public class Client {
    public static void main(String[] args) {
        Contain(Color.class, "不存在的枚举项");
    }

    // 判断一个枚举是否包含String枚举项
    public static <T extends Enum<T>> boolean Contain(Class<T> c, String name) {
        boolean result = false;
        try {
            Enum.valueOf(c, name);
            result = true;
        } catch (RuntimeException e) {
            // 只要是抛出异常，则认为是不包含
        }
        return result;
    }

    enum Color {
        Red, Blue;
    }
}
