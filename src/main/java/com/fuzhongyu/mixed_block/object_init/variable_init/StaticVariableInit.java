package com.fuzhongyu.mixed_block.object_init.variable_init;

/**
 * 静态变量初始化过程
 * Created by fuzhongyu on 2017/3/29.
 */
public class StaticVariableInit {

    public static inSideClass t = new inSideClass();
    public static int a = 0;
    public static int b;
    public static final int c=3;

    /**
     * 程序入口
     * @param arg
     *
     *  注：  执行顺序—— 1，申明变量并默认初始化：t=null;a=0;b=0;
     *                 2，变量初始化：先对t赋值t=new inSideClass();（此时也执行了a++,b++故a=1,b=1）  再对a赋值a=0;  最后b不需要赋值
     *
     *      final,静态常量其实是遵循普通静态变量的初始化的,但是在编译时,编译器会将不可变的常量值在使用的地方替换掉，所以c输出3
     */
    public static void main(String[] arg) {
        System.out.println("-->a:"+StaticVariableInit.a+"   b:"+StaticVariableInit.b);  // 输出: a:0  b:1
    }
}

class inSideClass {
    public inSideClass() {
        System.out.println("==>a:"+StaticVariableInit.a+"  b:"+StaticVariableInit.b+"  c:"+StaticVariableInit.c); //输出：a:0  b:0  c:3
        StaticVariableInit.a++;
        StaticVariableInit.b++;
        System.out.println("==>a:"+StaticVariableInit.a+"  b:"+StaticVariableInit.b+"  c:"+StaticVariableInit.c); //输出：a:1  b:1  c:3

    }

}
