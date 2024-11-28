package com.sora.leaf;


import com.sora.component.FileComponent;

/**
 * @Classname File
 * @Description 文件-叶子节点
 * @Date 2024/11/28 11:11
 * @Author by Sora33
 */

public class File implements FileComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("\t【叶子节点】文件名：" + name);
    }
}
