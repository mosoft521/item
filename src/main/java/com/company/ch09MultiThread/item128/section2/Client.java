package com.company.ch09MultiThread.item128.section2;

public class Client {
    public static void main(String[] args) throws Exception {
        final Foo foo = new Foo();
        // 定义一个线程
        Thread t = new Thread(new Runnable() {
            public void run() {
                foo.m1();
            }
        });
        t.start();
        // 等待t1线程启动完毕
        Thread.sleep(10);
        // m2方法需要等待m1执行完毕
        foo.m2();
    }

    static class Foo {
        public synchronized void m1() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 异常处理
            }
            System.out.println("m1执行完毕");
        }

        public synchronized void m2() {
            System.out.println("m2执行完毕");
        }
    }
}
