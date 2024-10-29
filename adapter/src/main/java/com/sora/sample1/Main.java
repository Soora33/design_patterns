package com.sora.sample1;

import java.util.concurrent.Callable;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/08/29 13:42
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        Callable callable = new SimpleCallable();
        // callable不可以作为Thread的参数
//        Thread thread = new Thread(callable);

        // 通过适配器将其转为Runnable
        RunnableAdapter adapter = new RunnableAdapter(callable);
        Thread thread = new Thread(adapter);
        thread.start();
    }
}