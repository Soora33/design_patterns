package com.sora.factory;

import com.sora.my_interface.Pay;

/**
 * @Classname PayFactory
 * @Description 支付类型抽象类
 * @Date 2024/09/10 15:36
 * @Author by Sora33
 */
public abstract class PayFactory {
    public abstract Pay getPayType();
}
