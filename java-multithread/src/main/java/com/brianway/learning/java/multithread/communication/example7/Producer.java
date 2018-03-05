/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 */
package com.brianway.learning.java.multithread.communication.example7;

/**
 *
 *
 * @author xus
 * @since 2018-03-05 13:35
 *
 */
public class Producer {
    private String lock;

    public Producer(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是" + value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
