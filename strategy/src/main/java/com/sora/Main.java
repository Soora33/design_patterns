package com.sora;

import com.sora.context.SubContext;
import com.sora.strategy.Subtitle;
import com.sora.strategyImpl.KitaujiSub;
import com.sora.strategyImpl.SakuraSub;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Main
 * @Description
 * @Date 2024/10/11 15:09
 * @Author by Sora33
 */
public class Main {

    private static final Map<String, Subtitle> SUB_MAP = new HashMap<>(){{
        put("sakura", new SakuraSub());
        put("kitauji", new KitaujiSub());
    }};

    public static void main(String[] args) {
        // 创建2个动漫对象，字幕字段的值通过策略选择完成
        Anime oshinoko = new Anime();
        oshinoko.setName("推しのこ");
        oshinoko.setOnlineYear("2024");
        oshinoko.setEpisodes("12");

        Anime makehiro = new Anime();
        makehiro.setName("負けヒロインは多すぎる");
        makehiro.setOnlineYear("2024");
        makehiro.setEpisodes("12");

        // 通过上下文对象获取加工完成的动画，参数为对应加工策略和动画对象
        SubContext oshinokoSub = new SubContext(SUB_MAP.get("kitauji"), oshinoko);
        SubContext makeiros = new SubContext(SUB_MAP.get("sakura"), makehiro);
        System.out.println(oshinokoSub.getSubtitle());
        System.out.println(makeiros.getSubtitle());
    }
}
