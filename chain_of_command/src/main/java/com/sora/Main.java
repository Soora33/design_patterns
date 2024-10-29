package com.sora;

import com.sora.handlerImpl.CEOHandler;
import com.sora.handlerImpl.GroupHandler;
import com.sora.handlerImpl.ManagerHandler;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/08/29 09:58
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 创建所有责任链
        GroupHandler groupHandler = new GroupHandler();
        ManagerHandler managerHandler = new ManagerHandler();
        CEOHandler CeoHandler = new CEOHandler();
        // 设置每个责任链的上级
        groupHandler.setNextHandler(managerHandler);
        managerHandler.setNextHandler(CeoHandler);
        System.out.println(groupHandler.request(1001));
    }
}