package com.sora.sample2;

/**
 * @Classname Jpy
 * @Description 日元
 * @Date 2024/09/23 11:08
 * @Author by Sora33
 */
public class Jpy {

    private Double jpy;

    public Jpy() {
    }

    public Jpy(Double jpy) {
        this.jpy = jpy;
    }

    public Double getJpy() {
        return jpy / 144.33;
    }
}
