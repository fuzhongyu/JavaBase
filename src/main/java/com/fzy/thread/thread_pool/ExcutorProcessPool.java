package com.fzy.thread.thread_pool;

import java.util.concurrent.*;

/**
 * 线程池  单列模式
 * Created by fuzhongyu on 2017/2/9.
 */
public class ExcutorProcessPool {

    private static ExcutorProcessPool excutorProcessPool=new ExcutorProcessPool();

    private ExecutorServiceFactory executorServiceFactory= ExecutorServiceFactory.getInstance();

    private ExecutorService executorService;

    private  ExcutorProcessPool(){

        /**
         * 常用到的队列有一下几种：
         *   1，ArrayBlockingQueue：基于数组结构的有界队列，此队列按FIFO原则对任务进行排序。如果队列满了还有任务进来，则调用拒绝策略。
         *   2，LinkedBlockingQueue（---最常用---）：基于链表结构的无界队列，此队列按FIFO原则对任务进行排序。因为它是无界的，根本不会满，
         *      所以采用此队列后线程池将忽略拒绝策略（handler）参数；同时还将忽略最大线程数（maximumPoolSize）等参数。
         *   3，SynchronousQueue：直接将任务提交给线程而不是将它加入到队列，实际上此队列是空的。每个插入的操作必须等到另一个调用移除的操作；
         *      如果新任务来了线程池没有任何可用线程处理的话，则调用拒绝策略。其实要是把maximumPoolSize设置成无界（Integer.MAX_VALUE）的，
         *      加上SynchronousQueue队列，就等同于Executors.newCachedThreadPool()。
         *   4，PriorityBlockingQueue：具有优先级的队列的有界队列，可以自定义优先级；默认是按自然排序，可能很多场合并不合适。
         */
        executorService=executorServiceFactory.createThreadPool(150,150,20,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());

    }

    public static ExcutorProcessPool getInstance(){return excutorProcessPool;}


    /**
     * 获取当前线程池中运行的线程数
     * @return
     */
    public Integer getThreadCount(){
        return ((ThreadPoolExecutor)executorService).getActiveCount();
    }

    /**
     * 关闭线程池
     */
    public void shutdown(){
        executorService.shutdown();
    }

    /**
     * 提交任务到线程池，无返回值
     * @param runnable
     */
    public void excute(Runnable runnable){
        executorService.execute(runnable);
    }

    /**
     * 提交任务到线程池，可以接受返回值
     * @param callable
     * @return
     */
    public Future<?> submit(Callable<?> callable){
        return executorService.submit(callable);
    }



}
