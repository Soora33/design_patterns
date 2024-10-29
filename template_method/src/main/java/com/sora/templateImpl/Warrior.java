package com.sora.templateImpl;

import com.sora.template.BaseBoard;

/**
 * @Classname Warrior
 * @Description 战士
 * @Date 2024/10/28 14:56
 * @Author by Sora33
 */
public class Warrior extends BaseBoard {
    @Override
    protected void initProfession() {
        System.out.println("职业：战士");
    }

    @Override
    protected void initAttr() {
        System.out.println("属性：");
        System.out.println("    生命： 7");
        System.out.println("    力量： 10");
        System.out.println("    魔力： 1");
        System.out.println("    耐力： 5");
    }

    @Override
    protected void initAddress() {
        System.out.println("出生地：王城征兵所");
    }

    @Override
    protected boolean chooseItem() {
        return true;
    }
}
