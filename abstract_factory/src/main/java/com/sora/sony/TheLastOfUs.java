package com.sora.sony;

import com.sora.product.RPG;

/**
 * @Classname TheLastOfUs
 * @Description 最后生还者
 * @Date 2024/10/24 16:00
 * @Author by Sora33
 */
public class TheLastOfUs implements RPG {
    @Override
    public void name() {
        System.out.println("游戏：最后生还者");
    }

    @Override
    public void details() {
        System.out.println("开发商：人类因现代传染病而面临绝种危机，当环境从废墟的都市再度自然化时……");
    }
}
