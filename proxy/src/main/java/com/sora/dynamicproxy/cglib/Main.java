package com.sora.dynamicproxy.cglib;

/**
 * @Classname Main
 * @Description
 * @Date 2024/11/21 16:06
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 创建目标对象
        Player player = new Player();
        // 创建代理对象
        CGLIBProxyHandler proxyHandler = new CGLIBProxyHandler(player);
        Player proxy = (Player) proxyHandler.createProxy();
        // 调用代理对象方法
        proxy.play();
    }
}
