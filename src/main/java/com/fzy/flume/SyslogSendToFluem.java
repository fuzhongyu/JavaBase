package com.fzy.flume;

import org.productivity.java.syslog4j.Syslog;
import org.productivity.java.syslog4j.SyslogIF;
import org.productivity.java.syslog4j.impl.net.udp.UDPNetSyslogConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author fuzhongyu
 * @date 2017/12/14
 */

public class SyslogSendToFluem {


    /**
     *
     * FACILITY指定了产生日志消息的子系统，
     * 可选值为 kernel messages(0),user-level messages(1),mail system(2),system daemons(3),security/authorization messages(4)
                messages generated internally by syslogd(5)  ,line printer subsystem(6) , network news subsystem(7),
                UUCP subsystem(8),clock daemon(9),security/authorization messages(10),FTP daemon(11) ,NTP subsystem(12),
                log audit(13) ,log alert(14), clock daemon(15), local use 0~7 (16~23)
     * PRIORITY指定了日志消息的优先级，
     可用的优先级包含 debug (7) , info (6) , notice (5) , warning (4) , err (3) , crit (2) , alert (1) , emerg (0)

     * priority : FACILITY*8 + PRIORITY
     */

    public static void main(String[] args) {

        StringBuffer stringBuffer=new StringBuffer("");
        stringBuffer.append("<190>2016-10-12 03:43:03 TelinAC --AC/SSID/1/syslog(23): telnet; SSID; 412001; Station(ip='192.168.100.120'&mac='3C:32:02:28:4E:A2') 通过SSID(name='test_ssid_1'&vlan=12)");

        StringBuffer stringBuffer1=new StringBuffer("");
        stringBuffer1.append("<190>2016-10-12 03:43:03 TelinAC --AC/SSID/6/syslog(23): telnet; SSID; 412001; Station(ip='192.168.100.120'&mac='3C:32:02:28:4E:A2') 通过SSID(name='test_ssid_1'&vlan=12)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i=0;
        String str=stringBuffer.toString();
        while (true){

            System.out.println(i++);

            sendLog("127.0.0.1",4444,str,6);

        }




//        new Thread("a"){
//            @Override
//            public void run(){
//                int i=0;
//                    sendLog("127.0.0.1",4444,stringBuffer.toString(),1);
//            }
//        }.start();




//        new Thread("a"){
//            @Override
//            public void run(){
//                sendLog("127.0.0.1",4444,stringBuffer1.toString(),6);
//            }
//        }.start();

//        new Thread("d"){
//            @Override
//            public void run(){
//                sendLog("192.168.1.63",4444,stringBuffer1.toString(),6);
//            }
//        }.start();
//
//        new Thread("e"){
//            @Override
//            public void run(){
//                sendLog("192.168.1.63",4444,stringBuffer1.toString(),6);
//            }
//        }.start();

//        sendLog("127.0.0.1",4444,stringBuffer.toString(),25);

 /*       发出去的数据格式 log_alert
        { headers:{host=fuzhongyudeMacBook-Pro.local, Severity=1, Facility=1, priority=9, timestamp=1513589382000}
         body: 73 64 66 73 64 73 2D 2D 2D 64 64 2A 2A 2A 2A 69 sdfsds---dd****i }


         发出去的数据格式：log_debug
         { headers:{host=fuzhongyudeMacBook-Pro.local, Severity=7, Facility=1, priority=15, timestamp=1513589726000}
         body: 73 64 66 73 64 73 2D 2D 2D 64 64 2A 2A 2A 2A 69 sdfsds---dd****i }


 */

        //

    }

    /**
     * syslog发送日志
     * @param host
     * @param port
     * @param log 日志内容
     * @param level  日志等级(severity)： 当超出7的时候level的值为  level%8
    0 LOG_EMERG：紧急情况，需要立即通知技术人员。
    1 LOG_ALERT：应该被立即改正的问题，如系统数据库被破坏，ISP连接丢失。
    2 LOG_CRIT：重要情况，如硬盘错误，备用连接丢失。
    3 LOG_ERR：错误，不是非常紧急，在一定时间内修复即可。
    4 LOG_WARNING：警告信息，不是错误，比如系统磁盘使用了85%等。
    5 LOG_NOTICE：不是错误情况，也不需要立即处理。
    6 LOG_INFO：情报信息，正常的系统消息，比如骚扰报告，带宽数据等，不需要处理。
    7 LOG_DEBUG：包含详细的开发情报的信息，通常只在调试一个程序时使用。
     */
    public static void sendLog(String host,Integer port,String log,Integer level){

//        try {
//            //创建syslog服务器
//            UDPNetSyslogConfig config=new UDPNetSyslogConfig(host,port);
//            SyslogIF syslogIF=Syslog.createInstance("udp",config);
//            long time2=System.currentTimeMillis();
//            syslogIF.log(level, URLDecoder.decode(log,"utf-8"));
////            syslogIF.debug(URLDecoder.decode(log,"utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        try {
            SyslogIF syslogIF=Syslog.getInstance("udp");
            syslogIF.getConfig().setHost(host);
            syslogIF.getConfig().setPort(port);
            syslogIF.log(level,URLDecoder.decode(log,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
