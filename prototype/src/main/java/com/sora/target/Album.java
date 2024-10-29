package com.sora.target;

import com.sora.prototype.Prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Album
 * @Description 专辑
 * @Date 2024/10/25 14:37
 * @Author by Sora33
 */
public class Album implements Prototype,Serializable{
    public String name;
    public String sings;
    public ArrayList<String> list = new ArrayList<>();

    public Album() {
    }

    public List getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", sings='" + sings + '\'' +
                ", list=" + list +
                '}';
    }

    public Album(String name, String sings, ArrayList<String> list) {
        this.name = name;
        this.sings = sings;
        this.list = list;
    }

    @Override
    public Prototype clone() {
        // 深拷贝
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Prototype) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("原型克隆出错！" + e);
            return null;
        }
        // 浅拷贝
//        return new Album(this.name, this.sings, this.list);
    }
}
