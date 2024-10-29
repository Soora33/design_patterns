package com.sora.my_interface_impl;

import com.sora.my_interface.Platform;

/**
 * @Classname Steam
 * @Description Steam平台
 * @Date 2024/09/10 14:10
 * @Author by Sora33
 */
public class Steam implements Platform {
    @Override
    public void print() {
        System.out.println("我是Steam平台");
    }
}
