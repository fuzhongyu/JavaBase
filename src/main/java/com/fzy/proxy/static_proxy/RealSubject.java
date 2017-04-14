package com.fzy.proxy.static_proxy;

/**
 * 真正的类
 * Created by fuzhongyu on 2017/4/14.
 */
public class RealSubject implements Subject{

    @Override
    public void getSubject() {
        System.out.println("do real subject method");
    }
}
