package com.fzy.thread.thread_normal_method;

/**
 * 实体类
 * Created by fuzhongyu on 2017/3/6.
 */
public class ThreadEntity implements Runnable{

    private static int i=1;

    private String name;

    public ThreadEntity(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取name,加同步为保证i值不出错
     */
    public synchronized void  getName(){
        System.out.println(name+i);
        i++;
    }

    @Override
    public void run() {
        try {
            getName();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("------>阻塞线程中断异常");
        }
    }
}
