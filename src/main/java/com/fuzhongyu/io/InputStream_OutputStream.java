package com.fuzhongyu.io;

import org.junit.Test;

import java.io.*;

/**
 * 字节流  FileOutputStream和FileInputStream
 * Created by fuzhongyu on 2017/2/10.
 */
public class InputStream_OutputStream {

    @Test
    public void test() {
        String filepath="src/io/test_file/myfile.txt";
        String info="write info to myfile! 写入信息到myfile文件";
        //写入信息"write info to myfile"到myfile.txt
//        outputString2FileWithEncoding(info,filepath,"gbk");
        outputString2FileWithEncoding2(info,filepath,"gbk");

        //使用同一种编码格式
        inputFileWithEncoding(filepath,"gbk");
        inputFileWithEncoding2(filepath,"gbk");
        inputFileWithEncoding3(filepath,"gbk");
        System.out.println("=====================");
        //使用不同编码格式（这时中文会乱码）
        inputFileWithEncoding(filepath,"utf-8");

    }

    /**
     * 根据指定的编码格式写入
     * @param info   信息
     * @param filepath  文件路径
     * @param charset  编码
     */
    private void outputString2FileWithEncoding(String info,String filepath,String charset){

        try {
            FileOutputStream out=new FileOutputStream(filepath);
            byte[] bytes=info.getBytes(charset);
            out.write(bytes);

            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件
     * --------这种方式读取会有问题，如本例中将bytes的长度改成9，就会导致中文字（2字节）只读取了一个字节导致乱码-----
     * @param filepath  文件路径
     * @param charset 编码格式
     */
    private void inputFileWithEncoding(String filepath,String charset){
        try {
            FileInputStream in=new FileInputStream(filepath);
            StringBuilder sb=new StringBuilder();
            byte[] bytes=new byte[100];
//            byte[] bytes=new byte[9];
            int len=0;
            while ((len=in.read(bytes))!=-1){
                sb.append(new String(bytes,charset));
            }
            in.close();
            System.out.println(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * 读取文件
     * --------不会产生上述（inputFileWithEncoding方法）这种问题
     * @param filepath  文件路径
     * @param charset 编码格式
     */
    private void inputFileWithEncoding2(String filepath,String charset){
        try {
            FileInputStream in=new FileInputStream(filepath);
            //字节数组流ByteArrayOutputStream，这个流可以存储动态长度的字节数组，因此非常适合在这里作为信息暂存的对象
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] bytes=new byte[100];
            int len=0;
            while ((len=in.read(bytes))!=-1){
                baos.write(bytes,0,len);
            }
            String str=baos.toString(charset);
            System.out.println(str);
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 写入文件  BufferedOutputStream
     * @param info
     * @param filepath
     * @param charset
     */
    private void outputString2FileWithEncoding2(String info,String filepath,String charset){
        try {
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(filepath));
            byte[] bytes=info.getBytes(charset);
            bufferedOutputStream.write(bytes);

            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 读文件信息
     * @param filepath
     * @param charset
     */
    private static void inputFileWithEncoding3(String filepath,String charset){
        try {
            BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(filepath));
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] bytes=new byte[100];
            int len=0;
            while ((len=bufferedInputStream.read(bytes))!=-1){
                baos.write(bytes,0,len);
            }
            String str=baos.toString(charset);
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
