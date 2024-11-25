package com.sora.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @Classname Main
 * @Description
 * @Date 2024/11/21 15:13
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 创建目标对象
        Player player = new Player();
        // 创建代理对象
        Media playerProxy = (Media)Proxy.newProxyInstance(
                player.getClass().getClassLoader(), // 类加载器
                player.getClass().getInterfaces(), // 目标接口
                new JDKProxyHandler(player) // 动态代理处理器
        );
        // 调用代理对象的方法
        playerProxy.play();
    }
}
