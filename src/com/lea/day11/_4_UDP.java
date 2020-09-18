package com.lea.day11;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author aCheng
 * @create 2020/09/09 下午 9:44
 */
public class _4_UDP {
    // 发送端
    @Test
    public void send() throws IOException {
        // UDP
        DatagramSocket datagramSocket = new DatagramSocket();
        String str = "这是一个我发送的木马文件包";
        byte[] bytes = str.getBytes();
        // UDP发送数据包
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 9090);

        datagramSocket.send(packet);

        datagramSocket.close();

    }

    // 接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] data = new byte[1024];
        // 接受的数据包
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // 接收数据报
        socket.receive(packet);
        // packet.getData() 数据报实际接收的数据
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();
    }

}
