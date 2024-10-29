package com.sora.strategyImpl;

import com.sora.Anime;
import com.sora.strategy.Subtitle;

/**
 * @Classname 北宇治字幕
 * @Description
 * @Date 2024/10/11 15:06
 * @Author by Sora33
 */
public class KitaujiSub implements Subtitle {
    @Override
    public Anime getAnime(Anime anime) {
        anime.setSubTitle("北宇治字幕组");
        return anime;
    }
}
