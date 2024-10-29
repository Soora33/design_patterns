package com.sora.templateImpl;

import com.sora.template.BaseBoard;

/**
 * @Classname Mage
 * @Description 魔法师
 * @Date 2024/10/28 14:56
 * @Author by Sora33
 */
public class Mage extends BaseBoard {
    @Override
    protected void initProfession() {
        System.out.println("职业：魔法师");
    }

    @Override
    protected void initAttr() {
        System.out.println("属性：");
        System.out.println("    生命： 3");
        System.out.println("    力量： 0");
        System.out.println("    魔力： 12");
        System.out.println("    耐力： 5");
    }

    @Override
    protected void initAddress() {
        System.out.println("出生地：雷古拉魔法学院");
    }
}
