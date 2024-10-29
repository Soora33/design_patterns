package com.sora.factory;

import com.sora.my_interface.Pay;
import com.sora.my_interface_impl.AliPay;

/**
 * @Classname AliPayFactory
 * @Description Ali支付工厂
 * @Date 2024/09/10 15:37
 * @Author by Sora33
 */
public class AliPayFactory extends PayFactory {
    @Override
    public Pay getPayType() {
        return new AliPay();
    }
}
