package com.fzy.example;

import org.junit.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public class SubClass extends SuperClass<SubClass> {

    String a="v";
//
//    {
//        System.out.println("sub code block");
//    }
//
    public SubClass(){
//        super();
//        System.out.println("---sub ConStructor---");
    }
//
    @Override
    public void sys(SubClass subClass){
        System.out.println("------>>");
    }

    public static void main(String[] args) {
//        new SubClass();
        SuperClass superClass=new SubClass();
        superClass.x();



    }

    public void  s(){
        System.out.println(this.a);
    }


    public void x(){
        System.out.println(">>>><<<");
    }

//    @org.junit.Test
//    public void test(){
//        SuperClass superClass=new SubClass();
//        superClass.sys(superClass);
//    }
}
