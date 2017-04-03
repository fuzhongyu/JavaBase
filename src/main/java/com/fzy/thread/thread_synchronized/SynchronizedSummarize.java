package com.fzy.thread.thread_synchronized;

/**
 * sychronized锁的一些总结（*****这个例子对sychronized理解很有帮助****）
 *
 * 注：（1）每个类有且只有一个监视器 ，静态方法持有的是类的监视器 （2）每个对象有且只有一个监视器，非静态方法持有对象监视器
 *    （3）加锁的方式: 给类加锁,static修饰;   给对象加锁，synchronized(object);   给方法加锁,synchronized  method()
 *
 * Created by fuzhongyu on 2017/3/8.
 */
public class SynchronizedSummarize {

    public static void main(String[] args) {
//        t1();
//        t2();
//        t3();
//        t4();
//        t5();
//        t6();
        t7();
    }

    /**####################
     * #======测试方法=====#
     * ####################
     *
     * 注：在测试内部类中的每个方法都有1秒的休眠时间，如果两个方法不能不能同时执行的，
     *     即线程安全，则控制台输出会有1秒间隔。
     *
     */


    /**
     * 测试1
     *
     * 结果：输出有间隔
     * 解释：创建了一个对象，他只有一个监视器，当test3()获取了该对象的监视器时，test4() 就需要等待，故有控制台输出间隔
     */
    public static void t1(){

        final InsideTest insideTest=new InsideTest();
        new Thread(){
            public void run(){
                insideTest.test3();
            }
        }.start();

        new Thread(){
            public void run(){
                insideTest.test4();
            }
        }.start();
    }

    /**
     * 测试2
     *
     * 结果：输出无间隔
     * 解释：创建了二个对象，他们抢占各自对象的监视器，互不影响，故有控制台输无间隔
     */
    public static void t2(){

        new Thread(){
            public void run(){
                InsideTest insideTest1=new InsideTest();
                insideTest1.test3();
            }
        }.start();

        new Thread(){
            public void run(){
                InsideTest insideTest2=new InsideTest();
                insideTest2.test4();
            }
        }.start();
    }

    /**
     * 测试3
     *
     * 结果：输出无间隔
     * 解释：创建了一个对象，test3()会抢占监视器，但test1()不需要对象持有的监视器（即不需要等待获取监视器），故有控制台输出无间隔
     */
    public static void t3(){

        final InsideTest insideTest=new InsideTest();
        new Thread(){
            public void run(){
                insideTest.test3();
            }
        }.start();

        new Thread(){
            public void run(){
                insideTest.test1();
            }
        }.start();
    }

    /**
     * 测试4
     *
     * 结果：输出有间隔
     * 解释：创建了二个对象，test5()会抢占类的监视器，但test6()也需要类的监视器，故有控制台输出有间隔
     */
    public static void t4(){

        new Thread(){
            public void run(){
                InsideTest insideTest1=new InsideTest();
                insideTest1.test5();
            }
        }.start();

        new Thread(){
            public void run(){
                InsideTest insideTest2=new InsideTest();
                insideTest2.test6();
            }
        }.start();
    }

    /**
     * 测试5
     *
     * 结果：输出无间隔
     * 解释：创建了一个对象，test5()会抢占类的监视器，test6()要抢占的是对象的监视器，两者互不影响，故有控制台输出无间隔
     */
    public static void t5(){

        final InsideTest insideTest=new InsideTest();
        new Thread(){
            public void run(){
                insideTest.test5();
            }
        }.start();

        new Thread(){
            public void run(){
                insideTest.test3();
            }
        }.start();
    }

    /**
     * 测试6
     *
     * 结果：输出有间隔
     * 解释：创建了一个对象，test4()会抢占类的监视器，但test7()也需要类的监视器，故有控制台输出有间隔
     */
    public static void t6(){

        final InsideTest insideTest=new InsideTest();
        new Thread(){
            public void run(){
                insideTest.test4();
            }
        }.start();

        new Thread(){
            public void run(){
                insideTest.test7();
            }
        }.start();
    }


    /**
     * 测试7
     *
     * 结果：输出有间隔
     * 解释：创建了一个对象，并对该对象加了锁，当运行的时候需要抢占该对象的锁，故有控制台输出有间隔
     */
    public static void t7(){

        final InsideTest insideTest=new InsideTest();
        for (int i=0;i<2;i++){
            new Thread(){
                public void run(){
                    //给insideTest这个对象加锁
                    synchronized (insideTest) {
                        insideTest.test1();
                    }
                }
            }.start();
        }
    }


}


/**
 * 测试内部类
 */
class InsideTest{

    public void test1(){
        try {
            Thread.sleep(1000);
            System.out.println("----method1---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test2(){
        try {
            Thread.sleep(1000);
            System.out.println("----method2-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test3(){
        try {
            Thread.sleep(1000);
            System.out.println("----method3-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test4(){
        try {
            Thread.sleep(1000);
            System.out.println("----method4-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void test5(){
        try {
            Thread.sleep(1000);
            System.out.println("----method5-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void test6(){
        try {
            Thread.sleep(1000);
            System.out.println("----method6-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步块加锁，这种方式相当于test4()
     */
    public void test7(){
        synchronized (this){
            try {
                Thread.sleep(1000);
                System.out.println("----method7-----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
