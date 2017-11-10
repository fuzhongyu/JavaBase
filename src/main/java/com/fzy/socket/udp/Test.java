package com.fzy.socket.udp;

/**
 * udp测试类
 * @author fuzhongyu
 * @date 2017/11/10
 */

public class Test {

    public static void main(String[] args) {

        final int port=12345;
        final  String ip="127.0.0.1";

        //服务端udp启动
        new Thread("a"){
             public void run(){
                 SocketUdpServer.start(port,new ServerMethod());
             }
        }.start();

        //睡眠3秒，保证服务端udp完全启动
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread("b"){
            public void run(){
               Object obj= SocketUdpClient.sendData(ip,port,"测试一下1");
                System.out.println("----"+obj);
            }
        }.start();

        new Thread("c"){
            public void run(){
               Object obj= SocketUdpClient.sendData(ip,port,"测试一下2");
                System.out.println(">>>"+obj);
            }
        }.start();
    }




}

/**
 * server 实现业务逻辑
 */
class ServerMethod implements SocketUdpServerMethod {

    @Override
    public Object service(Object obj) {
        System.out.println(obj.toString());
        return "test123";
    }
}
