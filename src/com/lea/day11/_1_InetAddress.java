package com.lea.day11;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、网络编程中有两个主要的问题：
 *  1.如何准确定位一台或多台主机（IP）;定位主机特定的应用（端口）
 *  2.找到主机后如何可靠高效地进行数据传输（传输协议）
 *
 * 二、网络编程中的两个要素
 *  1.对应问题一：IP和端口
 *  2.对应问题二：网络通信协议
             *  TCP|IP参考模型
             *  应用层
             *  传输层
             *  网络层
             *  物理+数据链路层
 *
 *  三、通信要素一：IP和端口
 *  1. IP：用来唯一标识Internet上的计算机（通信实体）
 *  2. 在java中使用InetAddress类代替IP
 *  3. IP分类：ipv4和ipv6； 万维网 和 局域网
 *  4. 域名： www.baidu.com 通过DNS解析对应的主机IP来访问主机
 *  5. 本地回路地址：127.0.0.1 对应 localhost
 *
 *  7.端口 ：标识正在计算机上运行的进程（程序）
 *    7.1：不同进程有不同端口号
 *    7.2：一共16位的整数 0~65535
 *    7.3：端口分类
 *          公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口80，FTP占用端口21，Telnet占用端口23）
 *          注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占用端口8080，Mysql占用你端口3306，Oracle占用端口1521）
 *          动态/私有端口：49152~65535
 *
 * @author aCheng
 * @create 2020/09/08 下午 10:37
 */
public class _1_InetAddress {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress name = InetAddress.getByName("192.168.0.1");
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(name.getHostName());
        System.out.println(baidu.getHostAddress());
        System.out.println(localhost);
        System.out.println(InetAddress.getLocalHost());
    }
}
