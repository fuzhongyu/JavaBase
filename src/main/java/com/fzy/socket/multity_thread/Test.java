package com.fzy.socket.multity_thread;

import java.io.IOException;

/**
 * 测试类
 * Created by fuzhongyu on 2017/3/15.
 */
public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        final int port=54321;

        //启动服务端,等待请求
        new Thread(){
            public void run(){
                try {
                    Server server=new Server(port);
                    server.service();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //休眠3秒钟，保证服务端初始化完毕
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //客户端admin-1请求
        new Thread(){
            public void run(){
                try {
                    String ip="127.0.0.1";
                    Client client=new Client(ip,port);
                    client.service("用户名：admin-1;密码:123456");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

        //客户端admin-2请求
        new Thread(){
            public void run(){
                try {
                    String ip="127.0.0.1";
                    Client client=new Client(ip,port);
                    client.service("用户名：admin-2;密码:123456");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
