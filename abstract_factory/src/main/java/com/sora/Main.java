package com.sora;

import com.sora.capcom.CapComFactory;
import com.sora.product.ACT;
import com.sora.product.RPG;
import com.sora.sony.SonyFactory;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/10/24 15:52
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 卡普空
        CapComFactory capComFactory = new CapComFactory();
        System.out.println("创建卡普空下的RPG游戏：");
        RPG capComRPGGame = capComFactory.createRPGGame();
        capComRPGGame.name();
        capComRPGGame.details();

        System.out.println("\n创建卡普空下的ACT游戏：");
        ACT capComACTGame = capComFactory.createACTGame();
        capComACTGame.name();
        capComACTGame.details();
        capComACTGame.level();

        // 索尼
        SonyFactory sonyFactory = new SonyFactory();
        System.out.println("\n创建索尼下的RPG游戏：");
        RPG sonyRPGGame = sonyFactory.createRPGGame();
        sonyRPGGame.name();
        sonyRPGGame.details();

        System.out.println("\n创建索尼下的ACT游戏：");
        ACT sonyACTGame = sonyFactory.createACTGame();
        sonyACTGame.name();
        sonyACTGame.details();
        sonyACTGame.level();
    }
}