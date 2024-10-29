package com.sora.handlerImpl;

import com.sora.handler.Handler;

/**
 * @Classname CEOHandler
 * @Description CEO
 * @Date 2024/08/29 10:04
 * @Author by Sora33
 */
public class CEOHandler extends Handler {

    @Override
    public boolean request(int price) {
        if (price > 1000 && price < 10000) {
            System.out.println("CEO审核成功");
            return true;
        }
        System.out.println("金额过大，通过失败！");
        return false;
    }
}
