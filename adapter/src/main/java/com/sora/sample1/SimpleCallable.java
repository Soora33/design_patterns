package com.sora.sample1;

import java.util.concurrent.Callable;

/**
 * @Classname Callable
 * @Description
 * @Date 2024/08/29 14:18
 * @Author by Sora33
 */
public class SimpleCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("callable执行成功");
        return true;
    }
}
