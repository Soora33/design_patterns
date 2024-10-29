package com.sora.my_interface_impl;

import com.sora.my_interface.Platform;

/**
 * @Classname Origin
 * @Description 橘子平台
 * @Date 2024/09/10 14:10
 * @Author by Sora33
 */
public class Origin implements Platform {
    @Override
    public void print() {
        System.out.println("我是橘子平台");
    }
}
