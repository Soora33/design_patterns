package com.sora.staticproxy;

/**
 * @Classname PlayerProxy
 * @Description 媒体代理类
 * @Date 2024/11/21 14:21
 * @Author by Sora33
 */
public class PlayerProxy implements Media{

    private Player player;

    @Override
    public void play() {
        System.out.println("静态代理：加载解码器……");
        if (player == null) {
            player = new Player();
        }
        player.play();
        System.out.println("静态代理：文件播放完成");
    }
}
