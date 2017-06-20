package com.fzy.example;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by fuzhongyu on 2017/2/7.
 */
public class Test{

    private double d1=1.0;
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

        String okt="okt";
        String t="t";
        String ok=new String("ok");
        System.out.println(okt.hashCode()+"   "+(ok+t).hashCode());
        if(okt==(ok+t)){
            System.out.println("====");
        }else {
            System.out.println("___");
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

        System.out.println(Thread.currentThread().getName());


        HashSet hashSet=new HashSet();
       boolean i= hashSet.add("3");


       Vector vector=new Vector();
       vector.add("4");

       TreeSet treeSet=new TreeSet();
       treeSet.add("1");

       LinkedHashSet linkedHashSet=new LinkedHashSet();
       linkedHashSet.add("3");

        File file=new File("/Users/fuzhongyu/Desktop/temporary_save_file/data/a");
        try {
            file.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String,Integer> sMap=new HashMap<>();
        sMap.put("a",9);
        sMap.put("b",5);
        sMap.put("c",7);
        sMap.put("d",5);
        sMap.put("e",1);
        List<Map.Entry<String,Integer>> arList=new ArrayList<>(sMap.entrySet());
        Collections.sort(arList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
//        for (Map.Entry<String,Integer> entry:arList){
//            System.out.println(entry.getKey()+"   "+entry.getValue());
//        }
        System.out.println(Arrays.toString(arList.subList(0,3).toArray()));

        Set<String> set=new HashSet<>();



        String stri="{\"conservative\":[{\"scoreList\":[{\"courseType\":0}]},{\"scoreList\":[\"courseType\":1},{\"courseType\":0}]}";
        stri=stri.replaceAll("\"courseType\":0","\"courseType\":#");
        stri=stri.replaceAll("\"courseType\":1","\"courseType\":0");
        stri=stri.replaceAll("\"courseType\":#","\"courseType\":1");
        System.out.println(stri);
    }

    public static void t(int a,Object... strings){}

    abstract class t{
          public abstract double a();
    }



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


