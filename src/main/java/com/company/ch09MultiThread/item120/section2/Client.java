package com.company.ch09MultiThread.item120.section2;

/**
 * 建议120： 不使用stop方法停止线程
 */
public class Client {
    public static void main(String[] args) {
        MultiThread t = new MultiThread();
        Thread t1 = new Thread(t);
        // 启动t1线程
        t1.start();
        for (int i = 0; i < 5; i++) {
            new Thread(t).start();
        }
        // 停止t1线程
        t1.stop();
    }
}

class MultiThread implements Runnable {
    int a = 0;

    @Override
    public void run() {
        // 同步代码块，保证原子操作
        synchronized ("") {
            // 自增
            a++;
            try {
                // 线程休眠0.1秒
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 自减
            a--;
            String tn = Thread.currentThread().getName();
            System.out.println(tn + ":a =" + a);
        }
    }
}
//TODO:AMD64_四核机器上:
/*
Thread-5:a =0
        Thread-3:a =0
        Thread-4:a =0
        Thread-1:a =0
        Thread-2:a =0*/
//TODO:32位机上?
