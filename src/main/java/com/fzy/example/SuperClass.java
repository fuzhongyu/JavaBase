package com.fzy.example;

/**
 * Created by fuzhongyu on 2017/9/12.
 */
public abstract class SuperClass<T>{

    {
        System.out.println("super code block");
    }

    public abstract void sys(T entity);


}
