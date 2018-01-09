package com.fzy.example;


/**
 * Created by fuzhongyu on 2017/9/11.
 */
public class Te {


    public static void main(String[] args) {
//        internTest();

//        new Thread("a"){
//            @Override
//            public void run(){
//                String str1="dddddddd";
//                while (true){
//
//                }
//
//            }
//        }.start();
//
//        new Thread("b"){
//            @Override
//            public void run(){
//                String str2="dddddddd";
//                while (true){
//
//                }
//
//            }
//        }.start();


//        int a16=0x0001;
//        int b16=0x0008;
//        System.out.println(a16|b16);


//        char c='■';
//        System.out.println(c);

        A a=new B();
        a.sayHello();


        Integer.toBinaryString(19);


    }


    public static String toBinaryString(int i){

        String binaryStr="";
        while(i>1){
            int j=i%2;
            i=i/2;
            binaryStr=j+binaryStr;

        }
        binaryStr=i+binaryStr;
        return binaryStr;

    }



//    public static void internTest(){
//        String str1=new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern()==str1);
//
//
//
//        String str2=new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern()==str2);
//
//        String str3=new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern()==str3.intern());
//
//    }
//
//    public static void meth(){
//
//        retry:
//
//        while (true){
//            continue retry;
//        }
//    }

}

interface TeInterf{

    static void method1(){
        System.out.println("测试方法1");
    }

    default void method2(){
        System.out.println("测试方法2");
    }
}


class A{
    public void sayHello(){
        System.out.println("A say hello");
    }

}

class B extends A{
    public void sayHello(){
        System.out.println("B say hello");
    }
}

