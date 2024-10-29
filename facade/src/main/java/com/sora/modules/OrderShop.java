package com.sora.modules;

/**
 * @Classname OrderShop
 * @Description
 * @Date 2024/10/22 15:29
 * @Author by Sora33
 */
public class OrderShop implements Order {
    @Override
    public void logic() {
        System.out.println("订单商品名：TouHou Remilia card");
    }
}
