package com.sora.sample3;

/**
 * @Classname ThreeImpl
 * @Description
 * @Date 2024/09/23 13:43
 * @Author by Sora33
 */
public class ThreeImpl implements Three {
    @Override
    public void play(int id, int id2, int id3) {
        System.out.println("player1:" + id);
        System.out.println("player2:" + id2);
        System.out.println("player3:" + id3);
    }
}
