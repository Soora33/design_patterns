package com.sora.component.impl;

import com.sora.component.Goods;

/**
 * @Classname Milk
 * @Description 牛奶-具体构件
 * @Date 2024/11/27 15:52
 * @Author by Sora33
 */
public class Milk implements Goods {
    String desc;
    Double price;

    public Milk(String desc, Double price) {
        this.desc = desc;
        this.price = price;
    }

    @Override
    public String desc() {
        return desc;
    }

    @Override
    public Double price() {
        return price;
    }
}
