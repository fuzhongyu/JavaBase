package com.fzy.thread.thread_normal_method;

/**
 * 线程属性
 * Created by fuzhongyu on 2017/3/6.
 */
public class ThreadProperty {

    public static void main(String[] args) {
        //线程最小优先级
        System.out.println("最小优先级："+Thread.MIN_PRIORITY);
        //线程最大优先级
        System.out.println("最大优先级："+Thread.MAX_PRIORITY);

        ThreadEntity threadEntity1=new ThreadEntity("线程1");
        ThreadEntity threadEntity2=new ThreadEntity("线程2");
        Thread thread1=new Thread(threadEntity1);
        Thread thread2=new Thread(threadEntity2);
        setThreadPriority(thread1,1);
        setThreadPriority(thread2,5);
        thread1.start();
        thread2.start();

        System.out.println("thread1线程状态:"+thread1.getState());
        System.out.println("thread2线程状态:"+thread2.getState());

    }

    /**
     * 设置线程优先级
     * @param thread
     * @param priority
     */
    public static void setThreadPriority(Thread thread,int priority){
        //线程优先级值必须在MIN_PRIORITY和MAX_PRIORITY之间
        thread.setPriority(priority);
    }

    /**
     * 设置为守护线程
     * 注：守护线程的用途是为其他线程提供服务，如计时线程
     * @param thread
     */
    public static void setThreadDeamon(Thread thread){
        thread.setDaemon(true);
    }

}
