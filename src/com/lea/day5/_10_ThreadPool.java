package com.lea.day5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  创建线程的方式四：使用线程池
 *  ExecutorService :线程池接口。常见子类ThreadPoolExcutor
 *      void execute(Runnable runnable):执行命令，没有返回值，一般用来执行Runnable
 *      <T> Future<T> submit： 执行任务 有返回值，一般用来执行Callable
 *      void shutdown: 关闭线程池
 *
 *  好处：
 *     1. 提高响应速度（减少创建新线程的时间）
 *     2.降低资源消耗（重复利用线程池中的线程，不需要每次创建）
 *     3.便于线程管理
 *     corePoolSize,        核心线程数
 *     maximumPoolSize,     最大线程数
 *     keepAliveTime        线程没有任务时最多保持多长时间终止
 *
 *  Executors： 线程池工厂类，用于创建并返回不同类型的线程池
 *      Executors.newCachedThreadPool();        创建一个可以根据需要创建新线程的线程池
 *      Executors.newFixedThreadPool(10);       创建一个可重用固定线程数的线程池
 *      Executors.newSingleThreadExecutor();    创建一个只有一个线程的线程池
 *      Executors.newScheduledThreadPool(10);   创建一个线程池，它可以在给定延迟后运行命令或定期执行任务
 *
 * @author aCheng
 * @create 2020/08/17 下午 5:57
 */
public class _10_ThreadPool {

    static int i =0;

    public static void main(String[] args) {
//        int i = 0;
        // 1 创建一个线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (i >= 2) {
                    scheduledExecutorService.shutdown();
                }
                i++;
                System.out.println(Thread.currentThread().getName() + "第" + i + "次900");
            }
        }, 0, 1, TimeUnit.SECONDS);
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);
        // 2.1 execute 执行实现Runnable接口的类
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----");
            }
        });
        // 2.2 submit 执行实现Callable接口、Runnable接口的类
        service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call 方法已经运行");
                return 0;
            }
        });
        // 3 关闭线程池（等线程执行完毕后关闭线程池）
        service.shutdown();
    }
}
