package com.lea.day10;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 一、流的分类
 *  操作数据单位：字节流，字符流
 *  数据的流向：输入流、输出流
 *  流的角色：节点流、处理流（对节点流做包装处理）
 *
 *  二、流的体系结构
 *      抽象基类(接口)         节点流(或文件流)          缓冲流（处理流的一种）
 *      InputStream          FileInputStream        BufferInputStream
 *      OutputStream         FileOutputStream       BufferOutputStream
 *      Reder                FileReder              BufferReder
 *      Writer               FileWriter             BufferWriter
 *
 * @author aCheng
 * @create 2020/09/02 下午 4:42
 */
public class _2_IO {


    /*
    1.read(): 返回读入的一个字符。如果达到文件末尾，返回-1
    2.异常处理：为了保证流资源一定可以执行关闭资源，需要使用try-catch-finally处理
     */
    @Test
    public void test() {
        FileReader fr = null;
        try {
            // 1.实例化File类，指明要操作的文件
            File file = new File("hi.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
            // 3.数据读取
            // fr.read(); 返回读入的一个字符。如果达到文件末尾，返回-1
            // 方式一：
//        int index;
//        while ((index = fr.read()) > -1) {
//            System.out.print((char) index);
//        }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    // read() 升级：使用read()重载方法
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            // 1.实例化File类，指明要操作的文件
            File file = new File("hi.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
//            int sum = 0;
            // 3.数据读取
            char[] data = new char[100];
            int len;
//            char a = '中';
            while ((len = fr.read(data)) > -1) {
                System.out.println(data);
//                System.out.println(len);
//                sum+=len;
            }
//            System.out.println(sum);
//            System.out.println(file.length());
//            System.out.println(file.length()/sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
    从内存中写出数据到硬盘文件

    说明
    1. 输出，对应File可以不存在，如果不存在，会自动创建文件
    2. 如果存在，
           使用构造器 Filewriter(file, false) / FileWriter(file) 对原有文件覆盖
           使用构造器 Filewriter(file, true) 会在原有文件基础上追加内容
     */
    @Test
    public void writer() {
        FileWriter fw = null;
        try {
            // 1.提供File对象，指明写出到的文件
            File file = new File("writer.txt");
            // 2.创建输出流  参数为ture表示在文件后面追加
            fw = new FileWriter(file, true);
            // 3.将数据写入到文件
            fw.write("i have a dream!");
            fw.write("\n");
            fw.write("\"I have a dream that one day this nation will rise up and live out the true meaning of its creed: \"We hold these truths to be self-evident, that all men are created equal.\"");
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭输出流
            if (null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {}
            }
        }
    }

    @Test
    public void rederAndWriter() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            // 1.提供File对象，指明写出到的文件
            File outFile = new File("hi1.txt");
            File inFile = new File("hi.txt");
            // 2.创建输出流  参数为ture表示在文件后面追加
            fw = new FileWriter(outFile, true);
            fr = new FileReader(inFile);
            // 3.将数据写入到文件
            char[] data = new char[1024];
            int len;
            while ((len = fr.read(data)) > -1) {
                fw.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭输出流
            if (null != fr) {
                try {
                    fr.close();
                } catch (IOException e) {}
            }
            if (null != fw) {
                try {
                    fw.close();
                } catch (IOException e) {}
            }
        }
    }

    /*
    图片复制
     */
    @Test
    public void copyPic() {
        InputStream is = null;
        OutputStream os = null;
        try {
            // 1.提供File对象，指明写出到的文件
            File outFile = new File("TIM截图_2020年9月2日.jpg");
            File inFile = new File("TIM截图20191108135808.png");
            // 2.创建输出流  参数为ture表示在文件后面追加
            os = new FileOutputStream(outFile);
            is = new FileInputStream(inFile);
            // 3.将数据写入到文件
            byte[] data = new byte[1024];
            int len;
            while ((len = is.read(data)) > -1) {
                os.write(data, 0 , len);
//                os.write(data);  或造成数据重复
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭输出流
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {}
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {}
            }
        }
    }
}
