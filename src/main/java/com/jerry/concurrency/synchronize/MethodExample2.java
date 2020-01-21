package com.jerry.concurrency.synchronize;

import com.jerry.concurrency.annoations.UnThreadSafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@UnThreadSafe
public class MethodExample2 {

    // 修饰一个方法
    public synchronized void methodTest(int j) {
        for (int i = 0; i < 10; i++) {
            System.out.println("methodTest === "+ j +" - " + i);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        MethodExample2 example1 = new MethodExample2();
        MethodExample2 example2 = new MethodExample2();

        executorService.execute(() -> {
            example1.methodTest(1);
        });
        executorService.execute(() -> {
            example2.methodTest(2);
        });
    }
}
