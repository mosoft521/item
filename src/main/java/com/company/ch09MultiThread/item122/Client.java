package com.company.ch09MultiThread.item122;

/**
 * 建议122： 使用线程异常处理器提升系统可靠性
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        //启动线程
        new TcpServer();
    }
}

class TcpServer implements Runnable {
    //创建后即运行
    public TcpServer() {
        Thread t = new Thread(this);
        t.setUncaughtExceptionHandler(new TcpServerExceptionHanlder());
        t.start();
    }

    @Override
    public void run() {
        // 正常业务运行,运行3秒
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("系统正常运行:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 抛出异常
        throw new RuntimeException();
    }

    // 异常处理器
    private static class TcpServerExceptionHanlder implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            // 记录线程异常信息
            System.out.println("线程 " + t.getName() + "出现异常，自行重启,请分析原因。");
            e.printStackTrace();
            // 重启线程，保证业务不中断
            new TcpServer();
        }
    }
}
