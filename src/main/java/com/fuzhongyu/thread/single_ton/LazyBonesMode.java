package com.fuzhongyu.thread.single_ton;

/**
 * 懒汉模式
 * 注：懒汉模式存在同步问题，会降低性能
 * Created by fuzhongyu on 2017/3/7.
 */
public class LazyBonesMode {

    //构造器私有，即不能被外部new
    private LazyBonesMode(){}

    private static LazyBonesMode lazyBonesMode;

    /**
     * 静态同步方法，使外界能访问到，保证多线程下安全
     * @return
     */
    public synchronized static LazyBonesMode getInstance(){
        if(lazyBonesMode==null){
            lazyBonesMode=new LazyBonesMode();
        }

        return lazyBonesMode;
    }
}
