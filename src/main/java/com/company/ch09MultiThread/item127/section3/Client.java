package com.company.ch09MultiThread.item127.section3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Client {
    public static void main(String[] args) {
        final Foo foo = new Foo();
        // 启动三个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    if (new Random().nextBoolean()) {
                        foo.write("");
                    } else {
                        foo.read();
                    }
                }
            }).start();
        }
    }
}

class Foo {
    //可重入的读写锁
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //读锁
    private final Lock r = rwl.readLock();
    //写锁
    private final Lock w = rwl.writeLock();

    //多操作，可并发执行
    public void read() {
        try {
            r.lock();
            Thread.sleep(1000);
            System.out.println("read……");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }
    }

    //写操作，同时只允许一个写操作
    public void write(Object _obj) {
        try {
            w.lock();
            Thread.sleep(1000);
            System.out.println("Writing……");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }
    }
}
