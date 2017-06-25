package com.company.ch01Common.item005.section1;

/**
 * 带有变长参数的方法重载，在调用时失败。
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.methodA("China", 0);
        client.methodA("China", "People");
//		client.methodA("China");
//		client.methodA("China",null);
    }

    public void methodA(String str, Integer... is) {
        System.out.println("Integer");
    }

    public void methodA(String str, String... strs) {
        System.out.println("String");
    }
}
