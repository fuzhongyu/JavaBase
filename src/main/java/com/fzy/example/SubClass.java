package com.fzy.example;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("subclass init");
    }

    public SubClass(){
        System.out.println("====");
    }
}
