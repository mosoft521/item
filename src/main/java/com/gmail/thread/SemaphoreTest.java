package com.gmail.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        // 规定一个线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // 允许最大并发数为3
        final Semaphore sp = new Semaphore(3);
        // 开启十个线程。
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        sp.acquire();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                    sp.release();
                    // 下面代码有时候执行不准确，因为其没有和上面的代码合成原子单元
                    System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
                }
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}
/*
线程pool-1-thread-3进入，当前已有1个并发
线程pool-1-thread-4进入，当前已有2个并发
线程pool-1-thread-8进入，当前已有3个并发
线程pool-1-thread-8即将离开
线程pool-1-thread-8已离开，当前已有2个并发
线程pool-1-thread-7进入，当前已有3个并发
线程pool-1-thread-7即将离开
线程pool-1-thread-7已离开，当前已有2个并发
线程pool-1-thread-2进入，当前已有3个并发
线程pool-1-thread-4即将离开
线程pool-1-thread-4已离开，当前已有2个并发
线程pool-1-thread-6进入，当前已有3个并发
线程pool-1-thread-2即将离开
线程pool-1-thread-2已离开，当前已有2个并发
线程pool-1-thread-10进入，当前已有3个并发
线程pool-1-thread-6即将离开
线程pool-1-thread-6已离开，当前已有2个并发
线程pool-1-thread-1进入，当前已有3个并发
线程pool-1-thread-3即将离开
线程pool-1-thread-5进入，当前已有3个并发
线程pool-1-thread-3已离开，当前已有3个并发
线程pool-1-thread-10即将离开
线程pool-1-thread-10已离开，当前已有2个并发
线程pool-1-thread-9进入，当前已有3个并发
线程pool-1-thread-5即将离开
线程pool-1-thread-5已离开，当前已有2个并发
线程pool-1-thread-1即将离开
线程pool-1-thread-1已离开，当前已有1个并发
线程pool-1-thread-9即将离开
线程pool-1-thread-9已离开，当前已有0个并发
 */