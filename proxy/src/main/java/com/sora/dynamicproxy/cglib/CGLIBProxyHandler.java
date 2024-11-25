package com.sora.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname CGLIBProxy
 * @Description CGLIB动态代理
 * @Date 2024/11/21 15:59
 * @Author by Sora33
 */
public class CGLIBProxyHandler implements MethodInterceptor {

    private Object target;

    public CGLIBProxyHandler(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        // 创建增强器类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB：加载解码器……");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("CGLIB：文件播放完成");
        return result;
    }
}
