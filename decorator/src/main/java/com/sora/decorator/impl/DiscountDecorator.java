package com.sora.decorator.impl;

import com.sora.component.Goods;
import com.sora.decorator.GoodsDecorator;

/**
 * @Classname DiscountDecorator
 * @Description 折扣具体装饰器-具体装饰器
 * @Date 2024/11/27 15:56
 * @Author by Sora33
 */
public class DiscountDecorator extends GoodsDecorator {

    private Double discount;

    public DiscountDecorator(Goods goods,Double discount) {
        super(goods);
        this.discount = discount;
    }

    @Override
    public String desc() {
        return goods.desc() + ", 折扣力度: " + discount  + "折";
    }

    @Override
    public Double price() {
        return goods.price() * discount;
    }
}
