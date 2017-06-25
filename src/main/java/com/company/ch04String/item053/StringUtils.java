package com.company.ch04String.item053;

public class StringUtils {
    //删除字符串
    public static String remove(String source, String sub) {
        return source.replaceAll(sub, "");
    }
}
