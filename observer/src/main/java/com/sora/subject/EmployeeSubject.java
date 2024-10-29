package com.sora.subject;

/**
 * @Classname EmployeeSubject
 * @Description 员工
 * @Date 2024/08/29 11:02
 * @Author by Sora33
 */
public class EmployeeSubject implements Subject {
    @Override
    public void update(String message) {
        System.out.println("EmployeeSubject : " + message);
    }
}
