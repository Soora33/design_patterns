package com.sora.template;

/**
 * @Classname BaseBoard
 * @Description 基础面板
 * @Date 2024/10/28 14:50
 * @Author by Sora33
 */
public abstract class BaseBoard {

    public final void createPerson() {
        // 初始化玩家职业
        initProfession();
        // 初始化玩家基础属性
        initAttr();
        // 初始化玩家出生地
        initAddress();
        // 初始化玩家等级
        initLevel();
        // 玩家是否选择了初始道具
        if (chooseItem()) {
            initItem();
        }
    }

    protected abstract void initProfession();
    protected abstract void initAttr();
    protected abstract void initAddress();
    protected boolean chooseItem() {
        return false;
    };

    private void initLevel() {
        System.out.println("等级：1");
    }

    private void initItem() {
        System.out.println("初始道具：火焰壶");
    }
}
