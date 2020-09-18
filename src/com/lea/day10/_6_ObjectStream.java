package com.lea.day10;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：
 *      用于存储和读取基本数据类型或对象的处理流，它的强大之处就是可以把java中的对象写入到数据源中，
 *      也能把数据从数据源中还原回来
 *
 * 3.序列化需要满足要求：
 *      1.需要被实例化的类必须实现 Serializable 或者 Externalizable
 *      2.当前类提供一个全局常量，serialVersionUID
 *      3.除了当前类需要实现Serializable接口之外，还必须保证内部所有属性，也必须是可序列化的。（基本数据类型是默认可序列化的）
 *
 * 4.序列化机制：
 *  对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘
 *  或通过网络将这种二进制传输到另一个网络节点。
 *  当其他程序获取了这种二进制流，就可以恢复成原来的Java对象
 *
 * @author aCheng
 * @create 2020/09/08 下午 5:00
 */
public class _6_ObjectStream {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            String s = new String("我爱北京天安门");
            oos.writeObject(s);
            oos.flush();    // 刷新操作
            oos.close();    // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    /*
    反序列化过程：将磁盘中对象还原到内存中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = ois.readObject();
            System.out.println(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
