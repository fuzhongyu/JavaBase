package com.fuzhongyu.thread.thread_synchronized;

/**
 * 银行转账例子，来演示同步
 * Created by fuzhongyu on 2017/3/6.
 */
public class Bank {

    //定义final类型数组，指的是该数组的引用不能赋值，如：accounts={1.0,2.0}这样不行，但accounts[0]=1.0这是可以的
    private final double[] accounts;

    public Bank(int n,double initialBalance) {
        accounts=new double[n];
        for (int i=0;i<accounts.length;i++){
            accounts[i]=initialBalance;
        }
    }

    /**
     * 转账方法（同步方法）
     * @param from
     * @param to
     * @param amount
     */
    public synchronized void tranfer(int from,int to,double amount) throws InterruptedException {
        //当当前账户余额小于转出时，线程进入等待
        while (accounts[from]<amount) wait();
        System.out.println(Thread.currentThread());
        accounts[from]-=amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to]+=amount;
        System.out.printf("total balance : %10.2f%n",getTotalBalance());
        //任何添加操作都释放锁
        notifyAll();
    }

    /**
     * 获取银行总额（转账后总额不会变）,保证其同步
     * @return
     */
    public synchronized double getTotalBalance(){
        double sum=0;
        for (double a:accounts){
            sum=sum+a;
        }
        return sum;
    }

    /**
     * 获取总账户
     * @return
     */
    public int size(){
        return accounts.length;
    }
}
