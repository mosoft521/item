package com.company.ch09MultiThread.item120.section4;

/**
 * 建议120： 不使用stop方法停止线程
 */
public class Client {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                //线程一直运行
                while (true) {
                    System.out.println("Running……");
                }
            }
        };
        // 启动t1线程
        t1.start();
        System.out.println(t1.isInterrupted());
        // 中断t1线程
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }
}
