package com.sora.capcom;

import com.sora.product.ACT;

/**
 * @Classname MonsterHunter
 * @Description 怪物猎人
 * @Date 2024/10/24 15:55
 * @Author by Sora33
 */
public class MonsterHunter implements ACT {
    @Override
    public void name() {
        System.out.println("游戏：怪物猎人");
    }

    @Override
    public void details() {
        System.out.println("游戏介绍：在怪物猎人的世界中，你将扮演一名猎人在新大陆上……");
    }

    @Override
    public void level() {
        System.out.println("上手难度：★★★★☆");
    }
}
