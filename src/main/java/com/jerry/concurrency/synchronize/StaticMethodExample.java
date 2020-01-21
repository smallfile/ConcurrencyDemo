package com.jerry.concurrency.synchronize;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ThreadSafe
public class StaticMethodExample {

    // 修饰一个静态方法
    public static synchronized void staticMethodTest(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("staticMethodTest === "+ j +" - " + i);
        }
    }

    public static void main(String[] args) {
        StaticMethodExample example1 = new StaticMethodExample();
        StaticMethodExample example2 = new StaticMethodExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.staticMethodTest(1);
        });
        executorService.execute(() -> {
            example2.staticMethodTest(2);
        });
    }
}

