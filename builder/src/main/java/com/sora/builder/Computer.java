package com.sora.builder;

/**
 * @Classname Computer
 * @Description 电脑
 * @Date 2024/08/29 15:34
 * @Author by Sora33
 */
public class Computer {
    private String cpu;
    private String gpu;
    private String board;
    private String arm;
    private String ssd;
    private String power;

    public Computer(ComputerBuilder computerBuilder) {
        this.cpu = computerBuilder.cpu;
        this.gpu = computerBuilder.gpu;
        this.board = computerBuilder.board;
        this.arm = computerBuilder.arm;
        this.ssd = computerBuilder.ssd;
        this.power = computerBuilder.power;
    }

    public static class ComputerBuilder{
        private final String cpu;
        private final String gpu;
        private final String board;
        private final String arm;
        private String ssd;
        private String power;

        public ComputerBuilder(String cpu, String gpu, String board, String arm) {
            this.cpu = cpu;
            this.gpu = gpu;
            this.board = board;
            this.arm = arm;
        }

        public ComputerBuilder setSsd(String ssd) {
            this.ssd = ssd;
            return this;
        }

        public ComputerBuilder setPower(String power) {
            this.power = power;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", board='" + board + '\'' +
                ", arm='" + arm + '\'' +
                ", ssd='" + ssd + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
