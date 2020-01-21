package com.jerry.concurrency.synchronize;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ThreadSafe
public class MethodExample1 {

    // 修饰一个方法
    public synchronized void methodTest(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("methodTest === "+ j +" - " + i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MethodExample1 example1 = new MethodExample1();
        executorService.execute(() -> {
            example1.methodTest(1);
        });
        executorService.execute(() -> {
            example1.methodTest(2);
        });
    }
}
