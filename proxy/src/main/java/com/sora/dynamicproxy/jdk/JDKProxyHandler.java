package com.sora.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname JDKProxyHandler
 * @Description JDK动态代理
 * @Date 2024/11/21 15:11
 * @Author by Sora33
 */
public class JDKProxyHandler implements InvocationHandler {

    private Object target;

    public JDKProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK：加载解码器……");
        Object result = method.invoke(target, args);
        System.out.println("JDK：文件播放完成");
        return result;
    }
}
