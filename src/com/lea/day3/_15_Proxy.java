package com.lea.day3;

/**
 * @author aCheng
 * @create 2020/8/14 16:40
 */
public class _15_Proxy {

    public static void main(String[] args) {
        Network network = new ProxyServer(new Server());
        network.browse();
    }

}

interface Network {

    void browse();
}
// 被代理类
class Server implements Network {

    @Override
    public void browse() {
        System.out.println("真实服务器访问网络");
    }
}
// 代理类
class ProxyServer implements Network {

    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public void check() {
        System.out.println("上网前检查");
    }

    @Override
    public void browse() {
        check();
        network.browse();
    }
}
