package com.sora;

import com.sora.factory.GamePlatform;
import com.sora.my_interface.Platform;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/09/10 13:58
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        String param = "steam";
        GamePlatform gamePlatform = new GamePlatform();

        Platform steam = gamePlatform.getPlatform(param);
        steam.print();
        param = "epic";
        Platform epic = gamePlatform.getPlatform(param);
        epic.print();
    }
}