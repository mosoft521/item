package com.company.ch04String.item052;

public class Client {
    public static void main(String[] args) {
        String str1 = "中国";
        String str2 = "中国";
        String str3 = new String("中国");
        String str4 = str3.intern();
        String str5 = str3 + " ";
        boolean b1 = (str1 == str2);
        boolean b2 = (str1 == str3);
        boolean b3 = (str1 == str4);
        System.out.println(str1.hashCode());
        System.out.println(str5.trim().hashCode());
    }
}
