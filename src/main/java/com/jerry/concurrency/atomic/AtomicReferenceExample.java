package com.jerry.concurrency.atomic;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 实例
 * AtomicReference<Integer> count = new AtomicReference<>(0);
 */
@ThreadSafe
public class AtomicReferenceExample {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        System.out.println("count值为：" + count.get());
    }
}
