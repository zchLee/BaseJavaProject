package com.lea.day14.jdk11;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 * jdk11
 *  1.String升级方法
 *
 *  2.局部变量类型推断升级
 *
 *  3，更简化的运行程序
 *  java test.java  // 编译+运行
 *  注意：
 *      必须要有main方法，只会执行第一个main方法
 *
 *  4. java script 加载引擎
 *
 *  5.ZGC 垃圾回收器
 *
 * @author lzc
 * @create 2020/09/17 下午 5:49
 */
public class Java11 {

    /*
    4、httpclient 网络连接
     */
    @Test
    public void test1() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.baidu.com")).build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        HttpResponse<String> response = client.send(request, handler);
        String body = response.body();
        System.out.println(body);
    }
}
