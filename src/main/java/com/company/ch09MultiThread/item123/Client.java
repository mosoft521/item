package com.company.ch09MultiThread.item123;

/**
 * 建议123： volatile不能保证数据同步
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 理想值，并做为最大循环次数
        int value = 1000;
        // 循环次数，防止出现无限循环造成死机情况
        int loops = 0;
        //主线程组，用于估计活动线程数
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        while (loops++ < value) {
            // 共享资源清零
            UnsafeThread ut = new UnsafeThread();
            for (int i = 0; i < value; i++) {
                new Thread(ut).start();
            }
            // 先等15毫秒，等待活动线程数量成为1
            do {
                Thread.sleep(15);
            } while (tg.activeCount() != 1);
            // 检查实际值与理论值是否一致
            if (ut.getCount() != value) {
                // 出现线程不安全的情况
                System.out.println("循环到第 " + loops + " 遍，出现线程不安全情况");
                System.out.println("此时，count=" + ut.getCount());
                System.exit(0);
            }
        }
    }
}

class UnsafeThread implements Runnable {
    // 共享资源
    private volatile int count = 0;

    @Override
    public void run() {
        // 为了增加CPU的繁忙程度
        for (int i = 0; i < 1000000; i++) {
            Math.hypot(Math.pow(92456789, i), Math.cos(i));
        }
        // 自增运算
        count++;
    }

    public int getCount() {
        return count;
    }
}