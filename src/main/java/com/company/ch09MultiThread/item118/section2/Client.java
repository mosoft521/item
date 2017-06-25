package com.company.ch09MultiThread.item118.section2;

/**
 * 建议118： 不推荐覆写start方法
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
    }
}

class MultiThread extends Thread {
    @Override
    public void start() {
        super.start();
        /*其他业务处理，但是不能调用run方法*/
    }

    @Override
    public void run() {
        //MultiThread do something.
    }
}