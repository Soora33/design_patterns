package com.sora.my_interface_impl;

import com.sora.my_interface.Pay;

/**
 * @Classname WechatPay
 * @Description 微信的支付实现类
 * @Date 2024/09/10 15:34
 * @Author by Sora33
 */
public class WechatPay implements Pay {
    @Override
    public void pay() {
        System.out.println("用户使用微信支付，开始执行具体逻辑……");
    }
}
