package com.sora.context;

import com.sora.Anime;
import com.sora.strategy.Subtitle;

/**
 * @Classname SubContext
 * @Description 上下文类
 * @Date 2024/10/11 15:07
 * @Author by Sora33
 */
public class SubContext {

    private Subtitle subtitle;
    private Anime anime;

    public SubContext(Subtitle subtitle,Anime anime) {
        this.subtitle = subtitle;
        this.anime = anime;
    }

    public Anime getSubtitle() {
        return subtitle.getAnime(anime);
    }

}
