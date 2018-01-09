package com.fzy.example;

import org.junit.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public class SubClass extends SuperClass<SubClass> {

    {
        System.out.println("sub code block");
    }

    public SubClass(){
        System.out.println("---sub ConStructor---");
    }

    @Override
    public void sys(SubClass subClass){
        System.out.println("------>>");
    }

    public static void main(String[] args) {
        new SubClass();
    }

    @org.junit.Test
    public void test(){
        SuperClass superClass=new SubClass();
        superClass.sys(superClass);
    }
}
