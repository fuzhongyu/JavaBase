package com.fzy.example;


/**
 * Created by fuzhongyu on 2017/10/9.
 */
public class IconstTest {

    public static void main(String[] args) {

        int x;

        x=100000;

        String str1="abc";

        String str2="abc";


        String str3="str1";

        new IncoAbMeth().method(str1);

    }
}

interface IncoInf{
    void method();
}

abstract class IncoAbstr implements IncoInf{

}


class IncoAbMeth{
    public void method(String string){
        System.out.println("----"+string);
    }
}