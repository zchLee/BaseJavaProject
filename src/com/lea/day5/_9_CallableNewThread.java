package com.lea.day5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三： 实现Callable接口  --- jdk5.0新增
 *  好处：
 *    1.call() 可以有返回结果
 *    2.call() 可以抛出异常，被外面的操作捕获，获取异常的信息
 *    3.Callable是支持泛型
 * @author aCheng
 * @create 2020/08/17 下午 3:16
 *
 */
// 1.实现Callable接口
class NumThread implements Callable {

    // 2. 实现call方法，将此线程的需要执行的方法写好
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class _9_CallableNewThread {

    public static void main(String[] args) {
        // 3.创建Callable接口实现类的接口
        NumThread numThread = new NumThread();
        // 4. 将此Callable接口的实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask task = new FutureTask(numThread);
        try {
            // 5.调用run方法 启动线程 或者 传入线程类启动
            new Thread(task).start();
//            task.run();
            Object o = task.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
