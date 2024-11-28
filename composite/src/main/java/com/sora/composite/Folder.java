package com.sora.composite;


import com.sora.component.FileComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Folder
 * @Description 文件夹-组合节点
 * @Date 2024/11/28 11:12
 * @Author by Sora33
 */
public class Folder implements FileComponent {

    private String name;
    private List<FileComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileComponent component) {
        components.add(component);
    }

    public void removeComponent(FileComponent component) {
        components.remove(component);
    }

    @Override
    public void show() {
        System.out.println("【组合节点】文件名:" + name);
        // 调用子节点的show方法
        components.forEach(data -> data.show());
    }
}
