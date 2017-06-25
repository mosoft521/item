package com.company.ch04String.item058.section1;

public class Client {
    public static void main(String[] args) throws Exception {
        String str = "汉字";
        //读取字节
        byte[] b = str.getBytes("UTF-8");
        //重新生成一个新的字符串
        System.out.println(new String(b, "UTF-8"));
    }
}
