package com.fzy.thread.thread_normal_method;

import org.junit.Test;

/**
 * isAlice判断线程是否处于活动状态, getId获得线程的唯一标识
 *
 * 注意观察：this.getName 和 Thread.currentThread().getName()的区别
 *
 * Created by fuzhongyu on 2017/5/13.
 */
public class IsAliveMethod {

    @Test
    public void test() throws InterruptedException {

        MyThread myThread1=new MyThread();
        System.out.println("test1 begin isAlive="+myThread1.isAlive()+"     myThread1 id="+myThread1.getId());
        myThread1.setName("A");
        myThread1.start();
        //注：此处如果myThread1先执行完毕则输出为false, 如果myThread1未执行完毕则输出false
        System.out.println("test1 end isAlive="+myThread1.isAlive());

        Thread.sleep(1000);
        System.out.println("========================");



        MyThread myThread2=new MyThread();
        Thread thread2=new Thread(myThread2);
        System.out.println("test2 begin isAlive="+thread2.isAlive()+"     myThread2.id="+myThread2.getId()+"     thread2.id="+thread2.getId());
        thread2.setName("B");
        thread2.start();
        System.out.println("test2 end isAlive="+thread2.isAlive());
    }



    /**
     * 线程内部类
     */
    private class MyThread extends Thread{

        public MyThread(){
            System.out.println("-- constructor begin --");
            System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
            System.out.println("this.getName()="+this.getName());
            System.out.println("this.isAlive()="+this.isAlive());
            System.out.println("-- constructor end --");
        }

        @Override
        public void run() {
            System.out.println("-- run begin --");
            System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
            System.out.println("Thread.currentThread().isAlive()="+Thread.currentThread().isAlive());
            System.out.println("this.getName()="+this.getName());
            System.out.println("this.isAlive()="+this.isAlive());
            System.out.println("-- run end --");
        }
    }

}

