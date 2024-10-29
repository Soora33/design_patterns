package com.sora.strategyImpl;

import com.sora.Anime;
import com.sora.strategy.Subtitle;

/**
 * @Classname SakuraSub
 * @Description 樱花字幕
 * @Date 2024/10/11 15:05
 * @Author by Sora33
 */
public class SakuraSub implements Subtitle {
    @Override
    public Anime getAnime(Anime anime) {
        anime.setSubTitle("樱花字幕组");
        return anime;
    }
}
