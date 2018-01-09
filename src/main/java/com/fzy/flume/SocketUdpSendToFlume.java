package com.fzy.flume;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogIF;
import org.productivity.java.syslog4j.impl.net.udp.UDPNetSyslogConfig;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.*;

/**
 * @author fuzhongyu
 * @date 2017/12/12
 */

public class SocketUdpSendToFlume {

    public static void main(String[] args) {

        int i=0;
        while (true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i++);
            try {
                Socket socket=new Socket("localhost",4444);
                PrintWriter writer=new PrintWriter(socket.getOutputStream());
                writer.print("jiwej aass\n");
//            writer.print("sjdis\n".getBytes());
                InputStream inputStream=new FileInputStream("/Users/fuzhongyu/Desktop/temporary_save_file/log-config.txt");
                byte[] bytes=new byte[1024*16];
                inputStream.read(bytes);
                writer.print(bytes);

                writer.flush();
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try {
//            InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",4444);
//            DatagramSocket datagramSocket=new DatagramSocket();
//            InputStream inputStream=new FileInputStream("/Users/fuzhongyu/Desktop/temporary_save_file/log-config.txt");
//            byte[] buf=new byte[1024*16];
////            byte[] buf="udp test\n".getBytes();
//            inputStream.read(buf);
//            DatagramPacket packet=new DatagramPacket(buf,buf.length);
//            packet.setSocketAddress(inetSocketAddress);
//            datagramSocket.send(packet);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }


}
