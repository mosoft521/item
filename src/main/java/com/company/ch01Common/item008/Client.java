package com.company.ch01Common.item008;

/**
 * 不用让旧语法困扰你
 */
public class Client {
    public static void main(String[] args) {
        //数据定义及初始化
        int fee = 200;
        //其他业务处理
        saveDefault:
        save(fee);
        //其他业务处理
    }

    static void saveDefault() {
    }

    static void save(int fee) {
    }
}
