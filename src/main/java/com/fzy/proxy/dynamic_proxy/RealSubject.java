package com.fzy.proxy.dynamic_proxy;

/**
 * Created by fuzhongyu on 2017/4/14.
 */
public class RealSubject implements Subject{

    @Override
    public void service() {
        System.out.println("do real subject method");
    }
}
