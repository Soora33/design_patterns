package com.sora;

import com.sora.target.Album;

import java.util.ArrayList;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/10/25 13:43
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        Album album = new Album("透明な君を掬う", "nayuta", new ArrayList(){{
            add("透明な君");
            add("誰そ彼");
            add("追慕");
            add("僕が見つけた綻び");
            add("灰燼");
            add("彼は誰");
            add("君を掬う");
        }});
        System.out.println("原对象：：" + album);
        Album clone = (Album) album.clone();
        System.out.println("克隆对象：" + clone);
        System.out.println("修改克隆对象，删掉最后一首歌曲……");
        clone.getList().removeLast();
        System.out.println("原对象：" + album);
        System.out.println("克隆对象：" + clone);
    }
}