package com.company.ch09MultiThread.item125.section1;

import java.util.concurrent.TimeUnit;

/**
 * 建议125： 优先选择线程池
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 创建一个线程，新建状态
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("线程在运行……");
            }
        });
        // 运行状态
        t.start();
        // 是否是运行态，若不是则等待10毫秒
        while (!t.getState().equals(Thread.State.TERMINATED)) {
            TimeUnit.MILLISECONDS.sleep(10);
        }
        // 直接由结束态转变为运行态
        t.start();
    }
}
