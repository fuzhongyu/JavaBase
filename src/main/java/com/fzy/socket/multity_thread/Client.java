package com.fzy.socket.multity_thread;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 客户端

 * 1、用服务器的IP地址和端口号实例化Socket对象。
 * 2、调用connect方法，连接到服务器上。
 * 3、获得Socket上的流，把流封装进OutputStreamWriter/InputStreamReader的实例，以进行读写
 * 4、利用Socket提供的getInputStream和getOutputStream方法，通过IO流对象，向服务器发送数据流
 * 5、关闭打开的流和Socket
 *
 * Created by fuzhongyu on 2017/3/15.
 */
public class Client {

    private Socket clientSocket;

    public Client(String serverIp,int serverPort) throws IOException {
        //创建客户端Socket，指定服务器地址和端口
        clientSocket=new Socket(serverIp,serverPort);
    }

    public void service(String info) throws IOException {
        //获取输出流，向服务器端发送信息
        OutputStreamWriter writer=new OutputStreamWriter(clientSocket.getOutputStream());
        writer.write(info);
        writer.flush();
        clientSocket.shutdownOutput();

        //获取输入流，并读取服务器端的响应信息
        InputStreamReader reader=new InputStreamReader(clientSocket.getInputStream());
        CharArrayWriter charArrayWriter=new CharArrayWriter();
        char[] chars=new char[100];
        int len=0;
        while ((len=reader.read(chars))!=-1){
            charArrayWriter.write(chars);
        }
        System.out.println("Hello,我是客户端，服务器说："+charArrayWriter.toString());

        charArrayWriter.close();
        reader.close();
        writer.close();
        clientSocket.close();

    }
}
