package com.sora.templateImpl;

import com.sora.template.BaseBoard;

/**
 * @Classname Thief
 * @Description 小偷
 * @Date 2024/10/28 14:56
 * @Author by Sora33
 */
public class Thief extends BaseBoard {
    @Override
    protected void initProfession() {
        System.out.println("职业：小偷");
    }

    @Override
    protected void initAttr() {
        System.out.println("属性：");
        System.out.println("    生命： 5");
        System.out.println("    力量： 3");
        System.out.println("    魔力： 5");
        System.out.println("    耐力： 7");
    }

    @Override
    protected void initAddress() {
        System.out.println("出生地：初始之地");
    }
}
