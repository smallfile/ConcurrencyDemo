package com.jerry.concurrency.atomic;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 *  实例
 *  public static LongAdder count = new LongAdder();
 */
@ThreadSafe
public class LongAdderExample {

    public static int clientTotal = 5000;    // 请求总数
    public static int threadTotal = 200;     // 同时并发执行的线程数
    public static LongAdder count = new LongAdder();     // 计数

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();   //线程池
        final Semaphore semaphore = new Semaphore(threadTotal);              //信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);     //计数器
        for (int i = 0; i < clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    System.out.println("exception");
                }
                countDownLatch.countDown();     //计数器减1
            });
        }
        countDownLatch.await();
        executorService.shutdown();     //关闭线程池
        System.out.println("当计数器减为0时，count的值:"+count);
    }

    private static void add() {
        count.increment();
    }
}
