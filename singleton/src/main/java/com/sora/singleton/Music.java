package com.sora.singleton;

/**
 * @Classname Music
 * @Description 音乐
 * @Date 2024/10/14 16:19
 * @Author by Sora33
 */
public class Music {

    // 私有化构造方法，防止外部实例化
    private Music() {}

    private static class Handler {
        private static final Music INSTANCE = new Music();
    }

    public static Music getInstance() {
        return Handler.INSTANCE;
    }
}
