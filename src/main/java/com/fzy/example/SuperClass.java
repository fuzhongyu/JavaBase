package com.fzy.example;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public abstract class SuperClass<T>{

    static {
        System.out.println("--->>><<<--");
    }


    String a="a";


//    {
//        System.out.println("super code block");
//    }

    public SuperClass(){
//        System.out.println(this);
//        System.out.println(this.a);
//        s();
//        this.x();
    }

    public void s(){
        System.out.println(this);
        System.out.println(this.a);
    }


    public abstract void sys(T entity);


    public void x(){
        System.out.println(">>>>222<<<");
    }


}
