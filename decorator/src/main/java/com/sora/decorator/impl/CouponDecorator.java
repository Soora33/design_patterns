package com.sora.decorator.impl;

import com.sora.component.Goods;
import com.sora.decorator.GoodsDecorator;

/**
 * @Classname CouponDecorator
 * @Description 优惠卷具体装饰器-具体装饰器
 * @Date 2024/11/27 16:04
 * @Author by Sora33
 */
public class CouponDecorator extends GoodsDecorator {

    private Double coupon;

    public CouponDecorator(Goods goods, Double coupon) {
        super(goods);
        this.coupon = coupon;
    }

    @Override
    public String desc() {
        return goods.desc() + ", 直减: " + coupon + "元";
    }

    @Override
    public Double price() {
        return goods.price() - coupon;
    }
}
