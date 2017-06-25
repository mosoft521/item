package com.company.ch08Exception.item110.section1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Client {
    public static void main(String[] args) {
        try {
            doStuff();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void doStuff() throws Exception {
        InputStream is = new FileInputStream("无效文件.txt");
        /*文件操作*/
    }

    public static void doStuff2() throws MyBussinessException {
        try {
            InputStream is = new FileInputStream("无效文件.txt");
        } catch (FileNotFoundException e) {
            //为方便开发和维护人员而设置的异常信息
            e.printStackTrace();
            //抛出业务异常
            throw new MyBussinessException(e);
        }
        /*文件操作*/
    }
}

class MyBussinessException extends Exception {
    public MyBussinessException(Throwable t) {
        super(t);
    }
}
