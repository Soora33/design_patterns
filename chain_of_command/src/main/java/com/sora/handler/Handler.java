package com.sora.handler;

/**
 * @Classname Handler
 * @Description 处理器
 * @Date 2024/08/29 09:59
 * @Author by Sora33
 */
public abstract class Handler {

    protected Handler handler;

    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract boolean request(int price);
}
