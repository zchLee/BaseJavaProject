package com.lea.day14.jdk9;

import org.junit.Test;

/**
 * @author lzc
 * @create 2020/09/16 下午 6:07
 */
public class StringTest {

    @Test
    public void test() {
        // jdk9 底层存储数据改成了 byte数组,StringBuffer 和 StringBuilder 底层存储也变成了byte数组
        String s = new String();
    }
}
