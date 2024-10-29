package com.sora;

import com.sora.singleton.Music;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/10/14 13:22
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        Music music1 = Music.getInstance();
        Music music2 = Music.getInstance();
        System.out.println(music1);
        System.out.println(music2);
    }
}