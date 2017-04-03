package com.fuzhongyu.mixed_block.object_init.child_parent_init;

/**
 * 父类和子类初始化顺序
 * Created by fuzhongyu on 2017/3/29.
 */
public class ParentTest {

    // 静态变量
    public static String p1 = "父类--静态变量";
    // 变量
    public String p2 = "父类--变量";

    // 静态初始化块
    static {
        System.out.println(p1);
        System.out.println("父类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(p2);
        System.out.println("父类--初始化块");
    }

    // 构造器
    public ParentTest() {
        System.out.println("父类--构造器");
    }

}
