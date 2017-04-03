package com.fzy.thread.thread_callable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Callable实现线程（实现线程有3种方式：实现runnable,callable接口，继承thread）
 * Created by fuzhongyu on 2017/3/6.
 */
public class CallableTest{

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter base directory:");
        String directory=in.nextLine();
        System.out.println("Enter keyword:");
        String keyword=in.nextLine();

        MatchCounter counter=new MatchCounter(new File(directory),keyword);
        FutureTask<Integer> task=new FutureTask<Integer>(counter);
        Thread t=new Thread(task);
        t.start();
        try {
            System.out.println(task.get()+"matching files");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

/**
 * 在指定目录下查找含有keyword的文件
 */
class MatchCounter implements Callable<Integer>{

    private File directory;
    private String keyword;
    private int count;

    public MatchCounter(File directory,String keyword){
        this.directory=directory;
        this.keyword=keyword;
    }


    @Override
    public Integer call() throws Exception {
        File[] files=directory.listFiles();
        List<Future<Integer>> results=new ArrayList<>();

        for(File file:files){
            //如果是目录
            if(file.isDirectory()){
                MatchCounter counter=new MatchCounter(file,keyword);
                FutureTask<Integer> task=new FutureTask<Integer>(counter);
                results.add(task);
                Thread t=new Thread(task);
                t.start();
            }else {
                //如果是文件，则判断是否匹配
                if(search(file)){
                    System.out.println(file.getName());
                    count++;
                }
            }

            for (Future<Integer> result:results){
                //将所有线程寻找到的值相加
                count+=result.get();
            }
        }

        return count;
    }


    /**
     * 查看文件中是否含有指定字符
     * @param file
     * @return
     */
    public boolean search(File file){
        try {
            try (Scanner in=new Scanner(file)){
                boolean found=false;
                while (!found&&in.hasNextLine()){
                    String line=in.nextLine();
                    if(line.contains(keyword)){
                        found=true;
                    }
                }
                return found;
            }
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}
