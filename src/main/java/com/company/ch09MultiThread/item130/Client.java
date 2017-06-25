package com.company.ch09MultiThread.item130;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws Exception {
        //参加赛跑人数
        int num = 10;
        // 发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);
        // 参与跑步有多个
        CountDownLatch end = new CountDownLatch(num);
        // 每个跑步者一个跑道
        ExecutorService es = Executors.newFixedThreadPool(num);
        // 记录比赛成绩
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        // 跑步者就位，所有线程处于等待状态
        for (int i = 0; i < num; i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }
        // 发令枪响，跑步者开始跑步
        begin.countDown();
        // 等待所有跑步者跑完全程
        end.await();
        int count = 0;
        // 统计总分
        for (Future<Integer> f : futures) {
            count += f.get();
        }
        System.out.println("平均分数为：" + count / num);
    }

    static class Runner implements Callable<Integer> {
        //开始信号
        private CountDownLatch begin;
        //结束信号
        private CountDownLatch end;

        public Runner(CountDownLatch _begin, CountDownLatch _end) {
            begin = _begin;
            end = _end;
        }

        @Override
        public Integer call() throws Exception {
            // 跑步的成绩
            int score = new Random().nextInt(25);
            // 等待发令枪响起
            begin.await();
            // 跑步中……
            TimeUnit.MILLISECONDS.sleep(score);
            // 跑步者已经跑完全程
            end.countDown();
            return score;
        }
    }
}
