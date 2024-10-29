package com.sora.product;

/**
 * @Classname GameFactory
 * @Description 游戏工厂
 * @Date 2024/10/24 16:02
 * @Author by Sora33
 */
public abstract class GameFactory {
    public abstract ACT createACTGame();
    public abstract RPG createRPGGame();
}
