package com.lea.day10;

import org.junit.Test;

import java.io.File;

/**
 *
 * File类
 * 1.File类代表一个对象，代表一个文件或一个文件夹
 * 2.创建实例 调用构造器
 *
 * @author aCheng
 * @create 2020/09/02 下午 2:55
 */
public class _1_File {

    /*
        1.创建实例 调用构造器
        2、 路径分隔符 windows： \\ linuxs: /
     */
    @Test
    public void test() {
        // 构造器1
        File file = new File("hello.txt");  // 相对路径  IDEL ：单元测试的相对路径是当前moudel下，main方法的相对路径是当前project西夏
        File file1 = new File("E:\\CodeSpace\\IDEAProject\\BaseJava\\hello.txt"); // 绝对路径

        // 构造器2: 在str1父类下的str2文件
        File file2 = new File("E:\\CodeSpace\\IDEAProject", "BaseJava");

        // 构造器3: 在File文件下的str2文件
        File file3 = new File(file2, "hello.txt");
        // 以下都是同一个文件
        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file3);
    }

    @Test
    public void test1() {
        print(new File("E:\\CodeSpace\\IDEAProject\\BaseJava"));
    }

//    输出指定文件中后缀为 .java的文件
    public void print(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                print(file);
            } else {
                System.out.println(file.getName());
            }
        }

    }
}
