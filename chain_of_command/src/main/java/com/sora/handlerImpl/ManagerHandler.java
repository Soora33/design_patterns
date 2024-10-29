package com.sora.handlerImpl;

import com.sora.handler.Handler;

/**
 * @Classname managerHandler
 * @Description 经理
 * @Date 2024/08/29 10:03
 * @Author by Sora33
 */
public class ManagerHandler extends Handler {

    @Override
    public boolean request(int price) {
        if (price > 100 && price <= 1000) {
            System.out.println("管理审核成功");
            return true;
        }
        System.out.println("管理审核失败，发送至下一级");
        return handler.request(price);
    }
}
