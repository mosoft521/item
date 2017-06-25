package com.company.ch09MultiThread.item129.section2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Client {
    public static void main(String[] args) throws Exception {
        // 定义初始长度为5
        BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);
        // 加入10个元素
        for (int i = 0; i < 10; i++) {
            bq.add("");
        }
    }
}
