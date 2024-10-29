package com.sora;

import com.sora.facade.FacadeOrder;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/10/17 10:51
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        FacadeOrder facadeOrder = new FacadeOrder();
        facadeOrder.getShop();
        facadeOrder.getNumber();
        facadeOrder.getPrice();
    }
}