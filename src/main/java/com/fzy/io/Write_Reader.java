package com.fzy.io;

import org.junit.Test;

import java.io.*;

/**
 * 字符流  FileReader和FileWriter
 * -------------字符流不可指定编码格式，所以当我们可以确认默认编码一致时可用字符流来进行文件读写----------
 * Created by fuzhongyu on 2017/2/10.
 */
public class Write_Reader {

    @Test
    public void test() {
        String filepath="src/io/test_file/myfile.txt";
        String info="write info to myfile! 写入信息到myfile文件";
        //写入信息"write info to myfile"到myfile.txt
        writeString2File(info,filepath);
//        writeString2File2(info,filepath);
        //读出信息，输出到控制台
        readFile(filepath);
//        readFile2(filepath);
    }

    /**
     * 写入文件
     * @param info  内容
     * @param filepath  文件路径
     */
    private void writeString2File(String info,String filepath){
        try {
            FileWriter writer=new FileWriter(filepath);
            writer.write(info);

            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * 读取文件
     * @param filepath  文件路径
     */
    private void readFile(String filepath){
        try {
            FileReader reader=new FileReader(filepath);
            StringBuilder sb=new StringBuilder();
            int i;
            while ((i=reader.read())!=-1){
                sb.append((char)i);
            }
            reader.close();
            System.out.println(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * bufferwriter
     * @param info
     * @param filepath
     */
    private void writeString2File2(String info,String filepath){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filepath));
            bufferedWriter.write(info);

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * bufferReader
     * @param filepath
     */
    private void readFile2(String filepath){
        String str=null;
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filepath));
            StringBuilder sb=new StringBuilder();
            //bufferReader可根据行读取文件
            while ((str=bufferedReader.readLine())!=null){
                sb.append(str+"\n");
            }
            bufferedReader.close();
            System.out.println(sb);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
