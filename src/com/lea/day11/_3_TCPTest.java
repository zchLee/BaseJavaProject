package com.lea.day11;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
public class _3_TCPTest {

    // 客服端
    @Test
    public void client() throws IOException, InterruptedException {
        InetAddress localhost = InetAddress.getByName("localhost");
        Socket socket = new Socket(localhost, 8899);
        OutputStream os = socket.getOutputStream();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("TIM截图20191108135808.png"));
        byte[] bf = new byte[1024];
        int len;
        while ((len = bis.read(bf)) != -1) {
            os.write(bf, 0, len);
        }
        // socket使用阻塞流，此处不关闭，服务端会一直等待客户端的输出流，因此造成阻塞。
        socket.shutdownOutput();

        // 接受服务端信息，并显示到控制台
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("服务端：" + br.readLine());

        bis.close();
        os.close();
        socket.close();
//        br.close();
    }

    // 服务端
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("TIM截图copy.png"));
        byte[] buffer = new byte[30];
        int len;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        // 给客户端发送数据
        OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
        osw.write("发送成功，我很喜欢");

        osw.close();
        bos.close();
        is.close();
        s.close();
        ss.close();
    }
}
