package com.sora.modules;

/**
 * @Classname OrderNumber
 * @Description
 * @Date 2024/10/22 15:28
 * @Author by Sora33
 */
public class OrderNumber implements Order {
    @Override
    public void logic() {
        System.out.println("订单编号：1097361294729");
    }
}
