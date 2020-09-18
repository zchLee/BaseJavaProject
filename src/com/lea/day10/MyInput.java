package com.lea.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author aCheng
 * @create 2020/09/07 下午 3:13
 */
public class MyInput {

    /**
     *
     *
     * @author: aCheng
     * @date: 2020/09/07 下午 3:16
     * @param  
     * @return: java.lang.String
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = null;
        try {
            data = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static int readInt() {
        return Integer.valueOf(readString());
    }
//    ***-

}
