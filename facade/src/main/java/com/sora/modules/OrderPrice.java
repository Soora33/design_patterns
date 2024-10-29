package com.sora.modules;

/**
 * @Classname OrderPrice
 * @Description
 * @Date 2024/10/22 15:27
 * @Author by Sora33
 */
public class OrderPrice implements Order {
    @Override
    public void logic() {
        System.out.println("订单金额：1020元");
    }
}
