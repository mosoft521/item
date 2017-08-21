package com.gmail.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static ExecutorService exec = Executors.newCachedThreadPool();
//    private static ExecutorService exec = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep((long) (Math.random()));
                        System.out.println("ThreadName:" + Thread.currentThread().getName() + " availablePermits:" + semaphore.availablePermits() + " QueueLength:" + semaphore.getQueueLength());
                        semaphore.release();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
/*
可以尝试不同参数组合
 */