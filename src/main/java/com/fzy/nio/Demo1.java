package com.fzy.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.Test;

/**
 * 使用FileChannel读取数据到Buffer中
 * @author Fucai
 * @date 2018/7/20
 */

public class Demo1 {


  @Test
  public void test() {
    try {
      RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/fuzhongyu/Desktop/wlanscope-back-api.txt","rw");
      FileChannel fileChannel=randomAccessFile.getChannel();

      //设定buffer的容量为1000
      ByteBuffer byteBuffer=ByteBuffer.allocate(1000);
      int bytesRead=-1;
      //数据读取到byteBuffer
      while ((bytesRead=fileChannel.read(byteBuffer))!=-1){
        System.out.println("read:"+bytesRead);
        //将buffer从写模式转换到读模式
        byteBuffer.flip();
        //从buffer中读取数据
        while (byteBuffer.hasRemaining()){
          System.out.print((char)byteBuffer.get());
        }
        System.out.println();
        System.out.println("==========");
        //设置position重新回到0,即又可以开始重新读一遍数据
        byteBuffer.rewind();
        while (byteBuffer.hasRemaining()){
          System.out.print((char)byteBuffer.get());
        }

        //清空buffer中的数据，clear会清空所有数据，﻿compact只会清除已读过的数据
        byteBuffer.clear();
      }
      fileChannel.close();
    } catch (Exception e) {
      System.out.println(">>>>");
      e.printStackTrace();
      throw new RuntimeException("测试一下");
    }
  }

  @Test
  public void test1(){
    try {
      RandomAccessFile randomAccessFile=new RandomAccessFile("/Users/fuzhongyu/Desktop/wlanscope-back-api.txt","rw");
      FileChannel fileChannel=randomAccessFile.getChannel();
      ByteBuffer byteBuffer1=ByteBuffer.allocate(100);
      ByteBuffer byteBuffer2=ByteBuffer.allocate(1000);
      ByteBuffer[] byteBuffers={byteBuffer1,byteBuffer2};

      while (fileChannel.read(byteBuffers)!=-1){
        byteBuffer1.flip();
        while (byteBuffer1.hasRemaining()){
          System.out.print((char) byteBuffer1.get());
        }
        System.out.println();
        System.out.println("----------");

        byteBuffer2.flip();
        while (byteBuffer2.hasRemaining()){
          System.out.print((char)byteBuffer2.get());
        }
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }

}
