package com.fzy.example;


import java.util.*;

/**
 * Created by fuzhongyu on 2017/2/7.
 */
public class Test{

    public static void main(String[] args) {
        System.out.println("i can use git");
        System.out.println("test diff");
        System.out.println("test branch");
        System.out.println("test merge 2");
        System.out.println("test --no-ff");
        StringBuilder builder=new StringBuilder("fs");
        StringBuffer buffer=new StringBuffer("sa");
        String str=new String("adf");
        final Test1 test1=new Test1();
        test1.setName("eed");
        test1.setName("df");

        String a="ok";
        String b=new String("ok");
        Object object=new Object();
        if(a==b){
            System.out.println("===");
        }
        Integer c=1;
        System.out.println(c);

        List<Integer> list=new ArrayList();
        Map<String,String> map=new HashMap<String, String>();
        map.put("2","2");
        map.put("1","1");
        System.out.println("--->"+map.containsValue("2"));

        list.add(1);
        list.add(2);
        list.remove(1);
        System.out.println(list.toArray());

        System.out.println(UUID.randomUUID());

        String str1="abc";
        String str2="sie";
        System.out.println(str1.matches(str2));

        List<String> list1=new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        t(1,list1.toArray());

    }

    public static void t(int a,Object... strings){}
}

class Test1{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


