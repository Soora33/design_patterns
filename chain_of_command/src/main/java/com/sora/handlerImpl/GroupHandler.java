package com.sora.handlerImpl;

import com.sora.handler.Handler;

/**
 * @Classname GroupHandler
 * @Description 组
 * @Date 2024/08/29 10:00
 * @Author by Sora33
 */
public class GroupHandler extends Handler {

    @Override
    public boolean request(int price) {
        if (price >= 10 && price <= 100) {
            System.out.println("组审核成功！");
            return true;
        }
        System.out.println("组审核失败，发送至下一级");
        return handler.request(price);
    }
}
