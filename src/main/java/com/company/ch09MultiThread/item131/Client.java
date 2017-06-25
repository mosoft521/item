package com.company.ch09MultiThread.item131;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Client {
    public static void main(String[] args) throws Exception {
        // 设置汇集数量，以及汇集完成后的任务
        CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            public void run() {
                System.out.println("隧道已经打通！");
            }
        });
        // 工人1挖隧道
        new Thread(new Worker(cb), "工人1").start();
        // 工人2挖隧道
        new Thread(new Worker(cb), "工人2").start();
    }

    static class Worker implements Runnable {
        // 关卡
        private CyclicBarrier cb;

        public Worker(CyclicBarrier _cb) {
            cb = _cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "-到达汇合点");
                // 到达汇合点
                cb.await();
            } catch (Exception e) {
                // 异常处理
            }
        }
    }
}
