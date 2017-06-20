package com.fzy.thread.thread_normal_method;

import org.junit.Test;

/**
 * 线程中断
 * Created by fuzhongyu on 2017/3/6.
 */
public class InterputMethod {

    @Test
    public void test(){
        MyThread myThread=new MyThread("线程");
        Thread thread1=new Thread(myThread);
        thread1.start();
        //线程阻塞的时候可以判断线程是否在中断状态
        judgeStatus(thread1);
        //线程阻塞的时候不能进行中断
        interruptThread(thread1);
    }


    /**
     * 查看线程是否是中断状态
     * @param thread
     * @return flag (true 中断；false 不中断)
     */
    public static void judgeStatus(Thread thread){
        //判断线程是否中断方法isInterrupted,但是如果线程阻塞(sleep或wait)会产生interrupted Exception异常中断
        if(thread.isInterrupted()){
            System.out.println("线程处于中断状态");
        }else {
            System.out.println("线程未处于中断状态");
        }
    }

    /**
     * 判断线程是否是中断状态
     * @param thread
     * @return flag (true 中断；false 不中断)
     */
    public static void judgeStatus2(Thread thread){
        //线程中断方法interrupted,检测当前线程是否中断，并会清除该线程的中断状态（isInterrupted只能判断，不会清除）
        if(thread.interrupted()){
            System.out.println("线程处于中断状态");
        }else {
            System.out.println("线程未处于中断状态");
        }
    }

    /**
     * 中断线程
     * @param thread
     */
    public static void interruptThread(Thread thread){
        //中断线程方法（中断线程并不一定是指改线程一定会终止，只是可以决定如何响应中断）
        thread.interrupt();
        System.out.println("执行了interupt方法");
        if(thread.isAlive()){
            System.out.println("线程存活");
        }else {
            System.out.println("线程未存活");
        }
    }

    /**
     * 内部类
     */
    private class MyThread implements Runnable {

        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            System.out.println(name);
        }
    }
}
