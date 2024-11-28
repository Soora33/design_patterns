package com.sora;


import com.sora.composite.Folder;
import com.sora.leaf.File;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/11/25 14:52
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        // 创建文件
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        File file3 = new File("File3.txt");

        // 创建文件夹
        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");
        Folder rootFolder = new Folder("Root");

        // 组合文件和文件夹
        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder2.addComponent(file3);
        rootFolder.addComponent(folder1);
        rootFolder.addComponent(folder2);

        // 打印结构
        rootFolder.show();
    }
}