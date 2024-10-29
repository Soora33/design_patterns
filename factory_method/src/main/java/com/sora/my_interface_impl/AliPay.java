package com.sora.my_interface_impl;

import com.sora.my_interface.Pay;

/**
 * @Classname AliPay
 * @Description Ali的支付实现类
 * @Date 2024/09/10 15:33
 * @Author by Sora33
 */
public class AliPay implements Pay {
    @Override
    public void pay() {
        System.out.println("用户使用AliPay支付，开始执行具体逻辑……");
    }
}
