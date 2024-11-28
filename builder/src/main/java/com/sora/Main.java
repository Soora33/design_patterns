package com.sora;

import com.sora.builder.Computer;

/**
 * @Classname ${NAME}
 * @Description ${Description}
 * @Date 2024/08/29 15:33
 * @Author by Sora33
 */
public class Main {
    public static void main(String[] args) {
        Computer computerBuilder = new Computer
                .ComputerBuilder("7800X3D", "7900xtx", "B650M", "32G")
                .build();
        Computer computerBuilder2 = new Computer
                .ComputerBuilder("7800X3D", "7900xtx", "B650M", "32G")
                .setSsd("2T")
                .setPower("1000w")
                .build();
        System.out.println(computerBuilder);
        System.out.println(computerBuilder2);

    }
}