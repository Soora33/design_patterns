package com.sora;

/**
 * @Classname Anime
 * @Description 动画类
 * @Date 2024/10/11 15:03
 * @Author by Sora33
 */
public class Anime {
    private String name;
    private String onlineYear;
    private String episodes;
    private String subTitle;

    public Anime() {
    }

    public Anime(String name, String onlineYear, String episodes, String subTitle) {
        this.name = name;
        this.onlineYear = onlineYear;
        this.episodes = episodes;
        this.subTitle = subTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnlineYear() {
        return onlineYear;
    }

    public void setOnlineYear(String onlineYear) {
        this.onlineYear = onlineYear;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", onlineYear='" + onlineYear + '\'' +
                ", episodes='" + episodes + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}
