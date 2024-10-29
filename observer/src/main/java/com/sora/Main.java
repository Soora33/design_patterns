package com.sora;

import com.sora.observer.CEOObServer;
import com.sora.subject.EmployeeSubject;
import com.sora.subject.ManagerSubject;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/08/29 09:58
 * @Author by Sora33
 */
    public class Main {
        public static void main(String[] args) {
            // 创建一个CEO发布者和2个订阅者
            CEOObServer ceoObServer = new CEOObServer();
            EmployeeSubject employeeSubject = new EmployeeSubject();
            ManagerSubject managerSubject = new ManagerSubject();

            ceoObServer.addSubject(employeeSubject);
            ceoObServer.addSubject(managerSubject);

            // 发布者发布消息
            ceoObServer.notifyObservers("消息通知");
            System.out.println("---删除employee订阅者---");
            ceoObServer.removeSubject(employeeSubject);
            ceoObServer.notifyObservers("新消息通知");
        }
    }