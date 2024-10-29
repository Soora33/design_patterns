package com.sora.capcom;

import com.sora.product.ACT;
import com.sora.product.GameFactory;
import com.sora.product.RPG;

/**
 * @Classname CapComFactory
 * @Description 卡普空工厂
 * @Date 2024/10/24 16:16
 * @Author by Sora33
 */
public class CapComFactory extends GameFactory {
    @Override
    public ACT createACTGame() {
        return new MonsterHunter();
    }

    @Override
    public RPG createRPGGame() {
        return new ResidentEvil();
    }
}
