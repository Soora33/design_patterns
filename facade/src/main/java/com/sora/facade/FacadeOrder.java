package com.sora.facade;

import com.sora.modules.OrderNumber;
import com.sora.modules.OrderPrice;
import com.sora.modules.OrderShop;

/**
 * @Classname FacadeOrder
 * @Description
 * @Date 2024/10/22 15:30
 * @Author by Sora33
 */
public class FacadeOrder {

    private OrderNumber orderNumber;
    private OrderPrice orderPrice;
    private OrderShop orderShop;

    public FacadeOrder() {
        orderNumber = new OrderNumber();
        orderPrice = new OrderPrice();
        orderShop = new OrderShop();
    }

    public void getNumber() {
        orderNumber.logic();
    }

    public void getShop() {
        orderShop.logic();
    }

    public void getPrice() {
        orderPrice.logic();
    }
}
