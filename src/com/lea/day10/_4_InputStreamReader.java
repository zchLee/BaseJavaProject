package com.lea.day10;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理流之二
 *  1.转换流：
 *    InputStreamReader：将字节的输入流转换成字符的输入流 （字节、字节数组 ---》 字符数组、字符串【解码】）
 *    OutputStreamWriter：将字节的输出流转换成字符的输出流 （字符数组、字符串 ---》 字节数组、字节【编码】）
 *
 * 作用：
 *      提供字节流和字符流之间的转换
 *
 *
 *
 * @author aCheng
 * @create 2020/09/02 下午 10:54
 */
public class _4_InputStreamReader {


    @Test
    public void test() throws IOException {
        FileInputStream fs = new FileInputStream("hi.txt");
        InputStreamReader isr = new InputStreamReader(fs);
        char[] data = new char[1024];
        int len;
        while ((len = isr.read(data)) != -1) {
            System.out.print(new String(data, 0 , len));
        };
        isr.close();
    }
}
