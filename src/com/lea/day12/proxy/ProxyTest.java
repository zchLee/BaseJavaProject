package com.lea.day12.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author lizhicheng
 * @create 2020/09/11 下午 2:52
 */
public class ProxyTest {

    public static void main(String[] args) {

        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new SuperMan());
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("豆皮");
        System.out.println();


        System.out.println("-------------------------------------------------------------");

        ClothFactory proxy = (ClothFactory) ProxyFactory.getProxyInstance(new blanceClothFactory());
        proxy.produceCloth();
    }

}

interface Human {

    String getBelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "信自己得永生";
    }

    @Override
    public void eat(String food) {
        System.out.println("超人吃下" + food);
    }
}


/*
要想实现代理类，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory {
    // 调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj) {  // ob：被代理类
        MyInvocationHandler invocationHandler = new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;  // 被代理的对象 赋值进来

    public MyInvocationHandler(Object ob) {
        this.obj = ob;
    }

    // 被代理类执行的方法 声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("我要看看这是个啥" + proxy);
        // 调用被代理类方法
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}