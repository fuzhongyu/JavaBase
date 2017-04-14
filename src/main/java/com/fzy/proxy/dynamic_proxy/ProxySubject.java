package com.fzy.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler的类
 * Created by fuzhongyu on 2017/4/14.
 */
public class ProxySubject implements InvocationHandler {

    private Object proxied;

    public ProxySubject(Object proxied){
        this.proxied=proxied;
    }

    /**
     *
     * @param proxy  被代理对象
     * @param method 被代理对象方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在转调具体目标对象之前，可以执行一些功能处理
        getPre();

        Object object=method.invoke(proxied);

        //在转调具体目标对象之后，可以执行一些功能处理
        getSuf();

        return object;
    }


    private void getPre(){
        System.out.println("proxy method prefix");
    }

    private void getSuf(){
        System.out.println("proxy method suffix");
    }

}
