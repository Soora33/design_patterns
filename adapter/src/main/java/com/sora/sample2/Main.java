package com.sora.sample2;/**
 * @Classname Main
 * @Description 
 * @Date 2024/09/23 11:10
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        Double price = 100.00;
        Cny cny = new Cny(price);
        System.out.println("人民币类输入金额：" + price + " ，返回：" + cny.getRmb());

        Jpy jpy = new Jpy(100.00);
        System.out.println("日元类输入金额：" + price + " ，返回：" + jpy.getJpy());

        JpyToCnyAdapter cnyAdapter = new JpyToCnyAdapter(jpy);
        System.out.println("适配器类输入金额：" + price + " ，返回：" + cnyAdapter.getRmb());
    }
}
