package com.fuzhongyu.thread.thread_pool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 测试类
 * Created by fuzhongyu on 2017/2/9.
 */
public class Test {

    public static void main(String[] args) {

        ExcutorProcessPool excutorProcessPool= ExcutorProcessPool.getInstance();

        for(int i=0;i<200;i++){
            //如果接受线程返回值，future.get()会阻塞，如果这样写就是一个线程一个线程的执行。
            Future<?> future=excutorProcessPool.submit(new ExcuteTask1(i+"  "));
            try {
                System.out.println(future.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        for(int i=0;i<200;i++){
            excutorProcessPool.excute(new ExcuteTask2(i+""));
        }

        //关闭线程池，如果是需要长期运行的线程池，不用调用该方法
        //监听程序退出的时候最好执行一下
        excutorProcessPool.shutdown();
    }


    /**
     * 执行任务1，实现callable方式
     */
    static class ExcuteTask1 implements Callable<String>{

        private String taskName;

        public ExcuteTask1(String taskName){
            this.taskName=taskName;
        }

        @Override
        public String call() throws Exception {
            try {
                //休眠方法TimeUnit.MILLISECONDS.sleep ,最好不用Thread.sleep
                TimeUnit.MILLISECONDS.sleep((int)Math.random()*1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("----这里执行了callable taskname="+taskName);
            return "====线程返回值，callable taskname"+taskName+"=====";
        }
    }


    /**
     * 执行任务2，实现了runable
     */
    static class ExcuteTask2 implements Runnable{

        private String taskName;

        public ExcuteTask2(String taskName){
            this.taskName=taskName;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep((int)Math.random()*1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("----这里执行了业务逻辑，runable  taskname="+taskName+"======");
        }
    }
}
