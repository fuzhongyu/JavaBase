package com.fzy.proxy.dynamic_proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试类
 *
 * 注：动态代理步骤：1，创建一个实现InvocationHandler的类，并实现了invoke方法
 *                2，创建被代理的类及其接口
 *                3，调用Proxy的newProxyInstance方法创建一个代理类
 *                4，通过代理类调用方法
 * Created by fuzhongyu on 2017/4/14.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {

        RealSubject realSubject=new RealSubject();
        InvocationHandler invocationHandler=new ProxySubject(realSubject);
        Class<?> cls=realSubject.getClass();

        /**
         * @param loader  类加载器
         * @param interfaces 实现接口
         * @param h   InvocationHandler
         *
         *  动态代理实现过程： 通过newProxyInstance返回代理对象步骤:
         *                  1，声明一段源码（动态产生代理）
         *                  2，编译源码（JDK compiler API）,产生新的类（代理类）
         *                  3,将这个类Load到内存中，产生一个新的对象（代理对象）
         *                  4,返回代理对象
         */
        Subject subject= (Subject) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),invocationHandler);

        subject.service();

//        createProxyClassFile();

    }




    /**
     * 创建ProxySubject.class
     */
    public static void createProxyClassFile(){

        String name="ProxySubject";
        String url="target/classes/com/fzy/proxy/dynamic_proxy/"+name+".class";

        byte[] data= ProxyGenerator.generateProxyClass(name,new Class[]{Subject.class});

        try {
            FileOutputStream out=new FileOutputStream(url);
            out.write(data);
            out.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
