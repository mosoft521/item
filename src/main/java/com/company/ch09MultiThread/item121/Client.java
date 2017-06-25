package com.company.ch09MultiThread.item121;

/**
 * 建议121： 线程优先级只使用三个等级
 */
public class Client {
    public static void main(String[] args) {
        //启动20个不同优先级的线程
        for (int i = 0; i < 20; i++) {
            new TestThread().start(i % 10 + 1);
        }
    }
}

class TestThread implements Runnable {
    //启动线程
    public void start(int _priority) {
        Thread t = new Thread(this);
        //设置线程优先级
        t.setPriority(_priority);
        t.start();
    }

    @Override
    public void run() {
        //消耗CPU的计算，性能差的机器，请修改循环限制
        for (int i = 0; i < 1000000; i++) {
            Math.hypot(Math.pow(924526789, i), Math.cos(i));
        }
        //输出线程优先级
        System.out.println("Priority:" + Thread.currentThread().getPriority());
    }
}