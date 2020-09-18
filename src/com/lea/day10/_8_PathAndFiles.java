package com.lea.day10;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1.jdk7时引入了 Path、Paths、Files三个类
 * 2.此三个类声明在：java.nio.file包
 * 3.Paht可以看做java.io.File类的升级版本。也可以表示文件或文件目录，与平台无关
 * 4.实例化 Paths.get(String first, String... more) 将多个字符串拼接成路径
 *          get(URI uri) 返回指定uri对应的Path路径
 *
 *  Files类升级了操作文件的一些方法, 与Path结合有很多奇妙的东西
 *
 * @author aCheng
 * @create 2020/09/08 下午 10:11
 */
public class _8_PathAndFiles {

    @Test
    public void test1() {
        Path path = Paths.get("hi.txt");
        System.out.println(path.getFileName());
    }
}
