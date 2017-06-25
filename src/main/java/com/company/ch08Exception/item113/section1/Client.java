package com.company.ch08Exception.item113.section1;

import java.util.zip.DataFormatException;

public class Client {
    public static void main(String[] args) {
        try {
            doStuff(-1);
            doStuff(100);
        } catch (Exception e) {
            System.out.println("这里是永远都不会到达的");
        }
    }

    public static int doStuff(int _p) throws Exception {
        try {
            if (_p < 0) {
                throw new DataFormatException("数据格式错误");
            } else {
                return _p;
            }
        } catch (Exception e) {
            //异常处理
            throw e;
        } finally {
            return -1;
        }
    }
}
