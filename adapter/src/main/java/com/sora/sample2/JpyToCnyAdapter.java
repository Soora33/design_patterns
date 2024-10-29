package com.sora.sample2;

/**
 * @Classname JpyToCnyAdapter
 * @Description
 * @Date 2024/09/23 11:10
 * @Author by Sora33
 */
public class JpyToCnyAdapter extends Cny{

    private Jpy jpy;

    public JpyToCnyAdapter(Jpy jpy) {
        this.jpy = jpy;
    }

    @Override
    public Double getRmb() {
        Double result = jpy.getJpy() * 7.05;
        return result;
    }
}
