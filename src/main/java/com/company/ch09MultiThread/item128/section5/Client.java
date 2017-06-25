package com.company.ch09MultiThread.item128.section5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String args[]) {
        final A a = new A();
        final B b = new B();
        // 线程A
        new Thread(new Runnable() {
            public void run() {
                a.a1(b);
            }
        }, "线程A").start();
        // 线程B
        new Thread(new Runnable() {
            public void run() {
                b.b1(a);
            }
        }, "线程B").start();
    }

    // 资源A
    static class A {
        public synchronized void a1(B b) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " 进入A.a1()");
            try {
                // 休眠1秒，仍然持有锁
                Thread.sleep(1000);
            } catch (Exception e) {
                // 异常处理
            }
            System.out.println(name + " 试图访问B.b2()");
            b.b2();
        }

        public synchronized void a2() {
            System.out.println("进入 a.a2()");
        }
    }

    // 资源B
    static class B {
        final ReentrantLock lock = new ReentrantLock();

        public void b1(A a) {
            try {
                lock.lock();
                String name = Thread.currentThread().getName();
                System.out.println(name + " 进入B.b1()");
                try {
                    // 休眠1秒，仍然持有锁
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // 异常处理
                }
                System.out.println(name + " 试图访问A.a2()");
                a.a2();
            } finally {
                lock.unlock();
            }
        }

        public void b2() {
            try {
                //立刻获得锁，或者2秒等待锁资源
                if (lock.tryLock() || lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println("进入B.b2()");
                }
            } catch (InterruptedException e) {
                //异常处理
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}
