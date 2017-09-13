package com.fzy.example;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public class SuperClass {

    static {
        System.out.println("super init");
    }

    public SuperClass(){
        System.out.println("----");
    }

    public static int value=123;
}
