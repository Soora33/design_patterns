package com.sora.subject;

/**
 * @Classname ManagerSubject
 * @Description 管理员
 * @Date 2024/08/29 11:04
 * @Author by Sora33
 */
public class ManagerSubject implements Subject {
    @Override
    public void update(String message) {
        System.out.println("ManagerSubject : " + message);
    }
}
