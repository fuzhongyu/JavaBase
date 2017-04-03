package com.fzy.socket.single_thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端（非多线程）
 * 　　
 * 1、用指定的端口实例化一个SeverSocket对象。服务器就可以用这个端口监听从客户端发来的连接请求。
 * 2、调用ServerSocket的accept()方法，以在等待连接期间造成阻塞，监听连接从端口上发来的连接请求。
 * 3、利用accept方法返回的客户端的Socket对象，进行读写IO的操作
 * 4、关闭打开的流和Socket对象
 *
 * Created by fuzhongyu on 2017/3/15.
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int serverPort) throws IOException {
        //创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        serverSocket=new ServerSocket(serverPort);
    }

    public void service() throws IOException {
        while (true){
            //调用accept()方法开始监听，等待客户端的连接
            Socket socket = serverSocket.accept();
            System.out.println("===有新的连接请求：ip:"+socket.getInetAddress()+"  port:"+socket.getPort()+"=====");
            //获取输入流，并读取客户端信息
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            System.out.println("--执行标注4---");

            CharArrayWriter charArrayWriter = new CharArrayWriter();
            char[] chars = new char[100];
            int len = 0;
            while ((len = reader.read(chars)) != -1) {
                charArrayWriter.write(chars);
            }
            System.out.println("Hello,我是服务器，客户端说：" + charArrayWriter.toString());

            socket.shutdownInput(); //关闭输入流

            //获取输出流，响应客户端的请求
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            System.out.println("---执行标注5----");
            writer.write("Hello World!");
            writer.flush();

            //关闭资源
            writer.close();
            charArrayWriter.close();
            reader.close();
            socket.close();
        }
    }
}
