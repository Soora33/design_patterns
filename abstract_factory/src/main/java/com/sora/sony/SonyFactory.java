package com.sora.sony;

import com.sora.product.ACT;
import com.sora.product.GameFactory;
import com.sora.product.RPG;

/**
 * @Classname SonyFactory
 * @Description 索尼工厂
 * @Date 2024/10/24 16:16
 * @Author by Sora33
 */
public class SonyFactory extends GameFactory {
    @Override
    public ACT createACTGame() {
        return new GodOfWar();
    }

    @Override
    public RPG createRPGGame() {
        return new TheLastOfUs();
    }
}
