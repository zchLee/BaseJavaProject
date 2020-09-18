package com.lea.day10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author aCheng
 * @create 2020/09/02 下午 8:31
 */
public class CopyFile {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        String srcPath = "E:\\迅雷下载\\沉默的羔羊BD双语双字[电影天堂www.dy2018.com].mkv";
        String destPath = "C:\\Users\\hasee\\Desktop\\沉默的羔羊BD双语双字.mkv";
        copyFile(srcPath, destPath);
        long l1 = System.currentTimeMillis();
        System.out.println("花费时间：" + (l1 - l));  // 17759
    }

    public static void copyFile(String srcPath, String destPath) {
        InputStream is = null;
        OutputStream os = null;
        try {
            // 1.提供File对象，指明写出到的文件
            File inFile = new File(srcPath);
            File outFile = new File(destPath);
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
