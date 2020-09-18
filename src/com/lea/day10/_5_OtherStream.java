package com.lea.day10;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 *
 * @author aCheng
 * @create 2020/09/07 下午 2:52
 */
public class _5_OtherStream {

    /*
    标准的输入流、输出流
    1.1
    System.in: 标准的输入流，默认从键盘输入
    System.out: 标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream) / setOut(PrintStream)方式重新指定输入和输出的流。

     */
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        System.out.println("请输入字符串：");
        while (true) {
            String s = br.readLine();
            if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                System.out.println("程序结束");
                break;
            }
            System.out.println(s.toUpperCase());
        }
        br.close();
    }

    /*
    标准输出流
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
            ps = new PrintStream(fos, true);
            if (null != ps) {
                System.setOut(ps);
            }

            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }

    /*
    数据流
    1.DadaInputStream 和 DadaOutPutStream
    2.作用：用于读取或写出基本数据类型的变量或字符串
     */
    @Test
    public void test3() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("张三");
        dos.flush();
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        dos.writeUTF("李四");
        dos.flush();

        dos.close();
    }

    @Test
    public void test4() throws IOException {
        DataInputStream dos = new DataInputStream(new FileInputStream("data.txt"));


        String s = dos.readUTF();
        int i = dos.readInt();
        boolean b = dos.readBoolean();
        String s1 = dos.readUTF();
        System.out.println(s + i + b + s1);

        dos.close();
    }

}
