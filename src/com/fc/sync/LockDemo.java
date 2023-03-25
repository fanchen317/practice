package com.fc.sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author fanchen
 * @Date 2022/6/8 09:32
 */
public class LockDemo {
    // ----------------- 悲观锁的调用方式 -----------------
    // synchronized
    public synchronized void testMethod() {
        // 操作同步资源
    }
    // ReentrantLock
    private ReentrantLock lock = new ReentrantLock();// 需要保证多个线程使用同一个锁
    public void modifyPublicResources() {
        lock.lock();
        // 操作同步资源
        lock.unlock();
    }

    //  ----------------- 乐观锁的调用方式 -----------------
    private AtomicInteger atomicInteger = new AtomicInteger();// 需要保证多个线程使用同一个AtomicInteger
}
