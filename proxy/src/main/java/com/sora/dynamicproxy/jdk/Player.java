package com.sora.dynamicproxy.jdk;

/**
 * @Classname Player
 * @Description 播放器
 * @Date 2024/11/21 14:20
 * @Author by Sora33
 */
public class Player implements Media {
    @Override
    public void play() {
        System.out.println("正在播放媒体……");
    }
}
