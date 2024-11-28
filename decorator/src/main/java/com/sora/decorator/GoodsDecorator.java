package com.sora.decorator;

import com.sora.component.Goods;

/**
 * @Classname GoodsDecorator
 * @Description 装饰器类
 * @Date 2024/11/27 15:54
 * @Author by Sora33
 */
public abstract class GoodsDecorator implements Goods {
    protected Goods goods;

    public GoodsDecorator(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String desc() {
        return goods.desc();
    }

    @Override
    public Double price() {
        return goods.price();
    }
}
