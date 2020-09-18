package com.lea.day10;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 处理流之一：缓冲流的使用
 *  1.缓冲流
 *      BufferedInputStream
 *      BufferedOutputStream
 *      BufferedReader
 *      BufferedWriter
 *
 *  2.作用：提供流的读取，写入速度
 *      提高读写速度的原因：内部提供了一个缓冲区
 *
 *  3.处理流是套接在已有的流的基础上
 *
 *
 *  flush() 方法，将缓冲区写入文件，并清空
 *
 * @author aCheng
 * @create 2020/09/02 下午 8:47
 */
public class _3_BufferIO {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        String src = "E:\\迅雷下载\\沉默的羔羊BD双语双字[电影天堂www.dy2018.com].mkv";
        String dest = "C:\\Users\\hasee\\Desktop\\沉默的羔羊BD双语双字.mkv";
        copyFile(src, dest);
        long l1 = System.currentTimeMillis();
        System.out.println("复制文件所花时间：" + (l1 - l)); // 4131
    }

    @Test
    public void bufferStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1.读取文件
            File inFile = new File("TIM截图20191108135808.png");
            File outFile = new File("TIM截图1.png");
            // 2.创建流
            // 2.1 创建节点流
            FileInputStream is = new FileInputStream(inFile);
            FileOutputStream os = new FileOutputStream(outFile);
            // 2.2 创建处理流
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            // 3. 读数据，写数据
            byte[] data = new byte[1024];
            int len;
            while ((len = bis.read(data)) > -1) {
                bos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流 关闭外层流时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略不写
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void bufferReaderAndWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 1.读取文件
            File inFile = new File("hi.txt");
            File outFile = new File("hi1.txt");
            // 2.创建流
            // 2.1 创建节点流
            // 2.2 创建处理流
            br = new BufferedReader(new FileReader(inFile));
            bw = new BufferedWriter(new FileWriter(outFile));
            // 3. 读数据，写数据
            char[] data = new char[1024];
            int len;
            while ((len = br.read(data)) > -1) {
                bw.write(data, 0, len);
//                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流 关闭外层流时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略不写
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bw) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void read() {
        HashMap<Character, Integer> hashMap = null;
        FileReader fr = null;
        try {
            // 1.读取文件
            File inFile = new File("hi.txt");
            hashMap = new HashMap<>((int)inFile.length());
            // 2.创建流
            fr = new FileReader(inFile);
            // 3. 读数据
            int len;
            while ((len = fr.read()) > -1) {
                if (hashMap.containsKey((char) len)) {
                    Integer count = hashMap.get((char) len);
                    hashMap.put((char) len, ++count);
                }else {
                    hashMap.put((char) len, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流 关闭外层流时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略不写
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("去除重复的数据 一共有" + hashMap.keySet().size() + "个字");
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "出现了" + entry.getValue() + "次");
        }
    }

    public static void copyFile(String src, String dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1.读取文件
            File inFile = new File(src);
            File outFile = new File(dest);
            // 2.创建流
            // 2.1 创建节点流
            FileInputStream is = new FileInputStream(inFile);
            FileOutputStream os = new FileOutputStream(outFile);
            // 2.2 创建处理流
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            // 3. 读数据，写数据
            byte[] data = new byte[1024];
            int len;
            while ((len = bis.read(data)) > -1) {
                bos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流 关闭外层流时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略不写
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
