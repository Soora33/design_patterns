package com.sora;

import com.sora.component.impl.Milk;
import com.sora.decorator.impl.CouponDecorator;
import com.sora.decorator.impl.DiscountDecorator;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/11/27 15:22
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个商品并打印基础信息
        Milk milk = new Milk("牛奶", 2.5);
        System.out.println("商品基础信息：");
        System.out.println(milk.desc());
        System.out.println(milk.price());
        System.out.println("====================");
        // 使用折扣装饰
        DiscountDecorator discountDecorator = new DiscountDecorator(milk, 0.75);
        System.out.println("商品（折扣）信息：");
        System.out.println(discountDecorator.desc());
        System.out.println(discountDecorator.price());
        System.out.println("====================");
        // 使用优惠卷装饰
        CouponDecorator couponDecorator = new CouponDecorator(milk, 0.5);
        System.out.println("商品（优惠卷）信息：");
        System.out.println(couponDecorator.desc());
        System.out.println(couponDecorator.price());
        System.out.println("====================");
    }
}