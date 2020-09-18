package com.lea.day10;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 *  1.直接继承与java.lang.Object类， 实现了DataInput, DataOutput接口
 *  2.RandomAccessFile既可以作为一个输入流，也可以做为一个输出流
 *
 *  3.如果RandomAccessFile作为输出流时，写出文件如果不存在，则在执行过程中自动创建
 *  如果写出文件存在，则会对源文件 从头覆盖
 *
 * @author aCheng
 * @create 2020/09/08 下午 5:59
 */
public class _7_RandowAccessFile {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("TIM截图20191108135808.png"), "rw");
            raf2 = new RandomAccessFile(new File("TIM截图Copy.png"), "rw");
            byte[] data = new byte[1024];
            int len;
            while ((len = raf1.read(data)) != -1) {
                raf2.write(data, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != raf1) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != raf2) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
