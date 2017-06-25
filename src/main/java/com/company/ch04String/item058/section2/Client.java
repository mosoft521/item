package com.company.ch04String.item058.section2;

public class Client {
    public static void main(String[] args) throws Exception {
        String str = "汉字";
        //读取字节
        byte[] b = str.getBytes("GB18030");
        //重新生成一个新的字符串
        System.out.println(new String(b));
    }
}
