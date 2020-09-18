package com.lea.day12.proxy;

/**
 * @author aCheng
 * @create 2020/09/11 下午 2:41
 */
public class StaticProxy {

    public static void main(String[] args) {
        ClothFactory proxyCloth = new ProxyCloth(new blanceClothFactory());
        proxyCloth.produceCloth();
    }
}

interface ClothFactory {

    void produceCloth();
}

// 代理类
class ProxyCloth implements ClothFactory {

    private ClothFactory factory;

    public ProxyCloth(ClothFactory factory) {
        this.factory = factory;
    }

    public void method() {
        System.out.println("代理工厂加工。。。。");
    }

    @Override
    public void produceCloth() {
        method();

        factory.produceCloth();

        System.out.println("代理工厂做收尾操作。。。。。");
    }
}

// 被代理类
class blanceClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("生产new blance鞋子....");
    }
}