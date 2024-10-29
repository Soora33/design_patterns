package com.sora.factory;

import com.sora.my_interface.Pay;
import com.sora.my_interface_impl.WechatPay;

/**
 * @Classname WechatPayFactory
 * @Description 微信支付工厂
 * @Date 2024/09/10 15:38
 * @Author by Sora33
 */
public class WechatPayFactory extends PayFactory {
    @Override
    public Pay getPayType() {
        return new WechatPay();
    }
}
