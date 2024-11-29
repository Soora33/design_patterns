# 建造者（Builder）

建造者模式更注重构建对象的这个过程，通过分步创建一个复杂的对象，将产品的创建与产品的本身进行分离，构建的过程就可以获得不同的对象。在代码中使用链式调用，方便的同时增加了可读性。我们一般通过建造者模式来创建那些有非传参数的对象或者参数过多的对象。

相信大家肯定见过类似于下面这样的代码，一个类的构造函数有多个可选参数，为了保证正常调用会写多个方法来进行重载，在这种情况下，我们就可以使用建造者的设计模式来完成。

```java
public class Computer {
    Computer(String cpu) { …… }
    Computer(String cpu, String gpu) { …… }
    Computer(String cpu, String gpu, String board) { …… }
```

这里我们假设cpu、gpu、board和arm是必传参数。使用建造者模式：

```java
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

// 客户端代码
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

// 控制台输出
 Computer{cpu='7800X3D', gpu='7900xtx', board='B650M', arm='32G', ssd='null', power='null'}
 Computer{cpu='7800X3D', gpu='7900xtx', board='B650M', arm='32G', ssd='2T', power='1000w'}
```

电脑类的所有属性都要经过ComputerBuilder来完成，并且在内部配置了必选参数和可选参数，必选参数保证了对象创建的完整性同时避免了构造函数爆炸的情况，可选参数带来了扩展性与灵活性，可以随时新增字段而不影响现有代码，链式调用又直观体现了该对象的整体结构

适用场景：复杂对象的创建，数据库连接参数配置，http连接参数的配置等等