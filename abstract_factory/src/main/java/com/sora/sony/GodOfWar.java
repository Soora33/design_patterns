package com.sora.sony;

import com.sora.product.ACT;

/**
 * @Classname GodOfWar
 * @Description 战神
 * @Date 2024/10/24 16:00
 * @Author by Sora33
 */
public class GodOfWar implements ACT {
    @Override
    public void name() {
        System.out.println("游戏：战神");
    }

    @Override
    public void details() {
        System.out.println("游戏介绍：奎托斯与儿子成功将母亲的遗骨撒落在高山，但门外的男人究竟是……");
    }

    @Override
    public void level() {
        System.out.println("上手难度：★★☆☆☆");
    }
}
