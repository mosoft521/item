package com.company.ch03ClassObjectMethod.item034;

/**
 * 建议34： 构造函数尽量简化
 */
public class Client {
    public static void main(String[] args) {
        Server s = new SimpleServer(1000);
    }
}

//定义一个服务
abstract class Server {
    public final static int DEFAULT_PORT = 40000;

    public Server() {
        //获得子类提供的端口号
        int port = getPort();
        System.out.println("端口号：" + port);
        /*进行监听动作*/
    }

    //由子类提供端口号，并做可用性检查
    protected abstract int getPort();
}

class SimpleServer extends Server {
    private int port = 100;

    //初始化传递一个端口号
    public SimpleServer(int _port) {
        port = _port;
    }

    //检查端口号是否有效，无效则使用默认端口，这里使用随机数模拟
    @Override
    protected int getPort() {
        return Math.random() > 0.5 ? port : DEFAULT_PORT;
    }
}
