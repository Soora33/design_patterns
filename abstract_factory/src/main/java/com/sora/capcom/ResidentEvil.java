package com.sora.capcom;

import com.sora.product.RPG;

/**
 * @Classname ResidentEvil
 * @Description 生化危机
 * @Date 2024/10/24 15:59
 * @Author by Sora33
 */
public class ResidentEvil implements RPG {
    @Override
    public void name() {
        System.out.println("游戏：生化危机");
    }

    @Override
    public void details() {
        System.out.println("游戏介绍：里昂接到总统特令，负责去孤岛上寻找阿什莉并将其救出，在岛上……");
    }
}
