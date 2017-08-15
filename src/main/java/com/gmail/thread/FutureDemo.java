package com.gmail.thread;

import org.joda.time.DateTime;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureDemo {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        //CompletionService接口内部维护一个结果队列:一堆future....
        CompletionService<Integer> cs = new ExecutorCompletionService<>(pool);

        for (int i = 1; i < 11; i++) {
            cs.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    // TODO Auto-generated method stub
                    Thread.sleep(1000);
                    Random random = new Random(new DateTime().getMillis());
                    int flag = random.nextInt(1000);
                    return flag;
                }
            });
        }

        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        pool.shutdown();

    }
}
