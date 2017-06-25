package com.company.ch09MultiThread.item127.section1;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void runTasks(Class<? extends Runnable> clz) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("*****开始执行" + clz.getSimpleName() + " 任务******");
        // 启动三个线程
        for (int i = 0; i < 3; i++) {
            es.submit(clz.newInstance());
        }
        // 等待足够长时间，然后关闭执行器
        TimeUnit.SECONDS.sleep(10);
        System.out.println("------" + clz.getSimpleName() + " 任务执行完毕-----\n");
        // 关闭执行器
        es.shutdown();
    }

    public static void main(String[] args) throws Exception {
        runTasks(TaskWithLock.class);
        runTasks(TaskWithSync.class);
    }
}

class Task {
    public void doSomething() {
        try {
            // 每个线程等待2秒钟，注意此时线程转为WAITING状态
            Thread.sleep(2000);
        } catch (Exception e) {
            // 异常处理
        }
        StringBuffer sb = new StringBuffer();
        // 线程名称
        sb.append("线程名称：" + Thread.currentThread().getName());
        // 运行的时间戳
        sb.append(",执行时间：" + Calendar.getInstance().get(13) + " s");
        System.out.println(sb);
    }
}

//显式锁任务
class TaskWithLock extends Task implements Runnable {
    // 声明显式锁
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            // 开始锁定
            lock.lock();
            doSomething();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}

//内部锁任务
class TaskWithSync extends Task implements Runnable {
    @Override
    public void run() {
        // 内部锁
        synchronized ("A") {
            doSomething();
        }
    }
}
