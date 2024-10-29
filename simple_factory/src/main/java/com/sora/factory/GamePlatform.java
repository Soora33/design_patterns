package com.sora.factory;

import com.sora.my_interface.Platform;
import com.sora.my_interface_impl.Epic;
import com.sora.my_interface_impl.Origin;
import com.sora.my_interface_impl.Steam;

/**
 * @Classname GamePlatform
 * @Description 游戏平台类
 * @Date 2024/09/10 14:11
 * @Author by Sora33
 */
public class GamePlatform {
    public Platform getPlatform(String platform) {
        if ("Epic".equalsIgnoreCase(platform)) {
            return new Epic();
        } else if ("Steam".equalsIgnoreCase(platform)) {
            return new Steam();
        } else if ("Origin".equalsIgnoreCase(platform)) {
            return new Origin();
        }
        return null;
    }
}
