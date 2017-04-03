package com.fzy.thread.thread_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步
 * Created by fuzhongyu on 2017/3/6.
 */
public class ThreadSynchronized implements Runnable{

    private static int i=1;

    //创建锁对象
    private  Lock lock=new ReentrantLock();

    /**
     * 通过synchronized加锁
     */
    public synchronized void  getCountSynchronized(){
        System.out.println("加锁synchronized："+i);
        i++;
    }

    /**
     * 通过锁对象加锁
     */
    public void getContReentrantLock(){
        lock.lock();
        try {
            System.out.println("加锁reentrantLock:"+i);
            i++;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 不加锁
     */
    public void getCount(){
        System.out.println("未加锁："+i);
        i++;
    }

    @Override
    public void run() {
        try {
            getCount();
//            getCountSynchronized();
//            getContReentrantLock();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("------>阻塞线程中断异常");
        }
    }


    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
        ThreadSynchronized synchronizedEntity=new ThreadSynchronized();
        for (int i=0;i<5;i++){
            Thread thread=new Thread(synchronizedEntity);
            thread.start();
        }
    }
}
