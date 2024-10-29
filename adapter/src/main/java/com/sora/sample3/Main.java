package com.sora.sample3;

/**
 * @Classname Main
 * @Description
 * @Date 2024/09/23 13:47
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        ThreeImpl three = new ThreeImpl();
        three.play(1, 2, 3);
        TwoAdapter twoAdapter = new TwoAdapter(three);
        twoAdapter.play(1, 2);
    }
}
