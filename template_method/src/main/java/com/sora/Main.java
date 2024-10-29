package com.sora;

import com.sora.templateImpl.Mage;
import com.sora.templateImpl.Thief;
import com.sora.templateImpl.Warrior;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/10/28 14:44
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        Thief elf = new Thief();
        elf.createPerson();
        System.out.println("====================================");
        Warrior warrior = new Warrior();
        warrior.createPerson();
        System.out.println("====================================");
        Mage mage = new Mage();
        mage.createPerson();
        System.out.println("====================================");
    }
}