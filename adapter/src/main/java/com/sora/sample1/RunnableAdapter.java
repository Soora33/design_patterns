package com.sora.sample1;

import java.util.concurrent.Callable;

/**
 * @Classname RunnableAdapter
 * @Description
 * @Date 2024/08/29 14:20
 * @Author by Sora33
 */
public class RunnableAdapter implements Runnable{

    private Callable callable;

    public RunnableAdapter(Callable myCallable) {
        this.callable = myCallable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
