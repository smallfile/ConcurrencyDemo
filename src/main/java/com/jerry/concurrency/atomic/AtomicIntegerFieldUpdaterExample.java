package com.jerry.concurrency.atomic;

import com.jerry.concurrency.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class, "count");

    public volatile int count = 100;

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

        AtomicIntegerFieldUpdaterExample example5 = new AtomicIntegerFieldUpdaterExample();

        if (updater.compareAndSet(example5, 100, 120)) {
            System.out.println("update success 1, {}" + example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            System.out.println("update success 2, {}" + example5.getCount());
        } else {
            System.out.println("update failed, {}" + example5.getCount());
        }
    }
}
