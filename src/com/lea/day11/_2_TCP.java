package com.lea.day11;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将信息显示在控制台上
 *
 * @author aCheng
 * @create 2020/09/09 下午 8:32
 */
public class _2_TCP {

    // 客服端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress localhost = InetAddress.getByName("localhost");
            socket = new Socket(localhost, 8899);
            os = socket.getOutputStream();
            os.write("客服端请求连接... 芝麻开门".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        ByteArrayOutputStream bos= null;
        try {
            ss = new ServerSocket(8899);
            s = ss.accept();
            is = s.getInputStream();
            // 可能会乱码，不建议使用
//            int len;
//            byte[] data = new byte[30];
//            while ((len = is.read(data)) != 1) {
//                String str = new String(data, 0, len);
//                System.out.print(str);
//            }
            // 暂存客户端发送的字节数组
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[30];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println(bos.toString());
            System.out.println("收到来自" + s.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
