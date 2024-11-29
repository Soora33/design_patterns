# 抽象工厂（Abstract Factory）

在讲抽象工厂前**强烈建议**先把工厂方法搞明白，会好理解很多。下面我们开始学习抽象工厂。

学习抽象工厂前我们要先了解2个概念，**产品族**和**产品等级结构**

**产品族**：是指一组相关联的产品，它们一起协作或具有某种共同属性。以麦当劳举例，麦当劳生产的汉堡、薯条、可乐可以被看作一个产品族，所有这些产品都属于麦当劳的风格。

**产品等级结构**：指产品的不同种类或类型的层次关系。比如，汉堡、薯条、饮料这些都是“快餐产品”的不同类型，它们代表了产品的不同等级结构。

下面继续说说抽象工厂的角色，总体上，抽象工厂的角色与工厂方法类似，但具体的职责会有点不同：

- 工厂方法侧重为**单个产品**提供接口，每个工厂只会生产一个产品
- 抽象工厂则为**产品族**提供接口，每个工厂可以生产同一产品族下的所有产品类型

抽象工厂中主要有以下角色：

1. 产品接口：为每种产品声明接口
2. 产品实现类：实现产品接口，负责具体的产品实现
3. 抽象工厂：所有工厂实现类的父类，声明创建了一系列相关产品的接口
4. 工厂实现类：继承抽象工厂类，负责创建具体的产品

**抽象工厂模式**的核心思想是**为产品族提供一个创建接口**。一个工厂不但负责创建一类产品（比如汉堡），还要为同一个产品族中的其他相关产品提供创建方式（如薯条、饮料）。通过抽象工厂模式，我们可以根据具体的需求生成同一产品族中的相关产品，而不必关心每个产品的具体实现细节，同时也隔离了具体类，客户端只通过接口来与产品交互，不直接依赖具体产品类，做到了解耦的同时增强了扩展性。但缺点同样是因为高扩展性，我们新增一个产品等级结构时，需要修改抽象工厂类以及各个工厂的具体实现。

下面以游戏开发商举例，每个游戏开发商都会开发不同类型的游戏，比如 RPG（角色扮演）、ACT（动作）等，这些不同的游戏类型属于**产品等级结构**。而多个游戏开发商，如卡普空、索尼等，都能够开发这些类型的游戏，这些开发商则可以看作是**产品族**的不同实现。我们以卡普空公司为例，创建这两种类型的游戏：

```java
// 动作类游戏接口 （字段：游戏名、游戏详情、上手难度）
public interface ACT {
    void name();
    void details();
    void level();
}

// 角色扮演类游戏接口 （字段：游戏名、游戏详情）
public interface RPG {
    void name();
    void details();
}

// 卡普空的动作类游戏具体实现
public class MonsterHunter implements ACT {
    @Override
    public void name() {
        System.out.println("游戏：怪物猎人");
    }

    @Override
    public void details() {
        System.out.println("游戏介绍：在怪物猎人的世界中，你将扮演一名猎人在新大陆上……");
    }

    @Override
    public void level() {
        System.out.println("上手难度：★★★★☆");
    }
}

// 卡普空的角色扮演类游戏具体实现
public class ResidentEvil implements RPG {
    @Override
    public void name() {
        System.out.println("游戏：生化危机");
    }

    @Override
    public void details() {
        System.out.println("游戏介绍：里昂接到总统特令，负责去孤岛上寻找阿什莉并将其救出，在岛上……");
    }
}

// 抽象工厂类 声明所有的产品等级结构
public abstract class GameFactory {
    public abstract ACT createACTGame();
    public abstract RPG createRPGGame();
}

// 创建卡普空工厂，返回所有产品等级结构
public class CapComFactory extends GameFactory {
    @Override
    public ACT createACTGame() {
        return new MonsterHunter();
    }

    @Override
    public RPG createRPGGame() {
        return new ResidentEvil();
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        CapComFactory capComFactory = new CapComFactory();
        System.out.println("创建卡普空下的RPG游戏：");
        RPG capComRPGGame = capComFactory.createRPGGame();
        capComRPGGame.name();
        capComRPGGame.details();

        System.out.println("\n创建卡普空下的ACT游戏：");
        ACT capComACTGame = capComFactory.createACTGame();
        capComACTGame.name();
        capComACTGame.details();
        capComACTGame.level();
    }
}

// 控制台输出
 创建卡普空下的RPG游戏：
 游戏：生化危机
 游戏介绍：里昂接到总统特令，负责去孤岛上寻找阿什莉并将其救出，在岛上……

 创建卡普空下的ACT游戏：
 游戏：怪物猎人
 游戏介绍：在怪物猎人的世界中，你将扮演一名猎人在新大陆上……
 上手难度：★★★★☆
```

在这个例子中，卡普空这个产品族为我们提供了两个产品等级结构的游戏：一个动作类（ACT）和一个角色扮演类（RPG）。通过抽象工厂，我们实现了不同类型游戏的创建。同时我们可以很容易地扩展另一个游戏开发商产品族：

```java
// 索尼的动作类游戏具体实现
public class GodOfWar implements ACT {
    @Override
    public void name() {
        System.out.println("游戏：战神");
    }

    @Override
    public void details() {
        System.out.println("游戏介绍：奎托斯与儿子成功将母亲的遗骨撒落在高山，但门外的男人究竟是……");
    }

    @Override
    public void level() {
        System.out.println("上手难度：★★☆☆☆");
    }
}

// 索尼的角色扮演类游戏具体实现
public class TheLastOfUs implements RPG {
    @Override
    public void name() {
        System.out.println("游戏：最后生还者");
    }

    @Override
    public void details() {
        System.out.println("开发商：人类因现代传染病而面临绝种危机，当环境从废墟的都市再度自然化时……");
    }
}

// 创建索尼工厂，返回所有产品等级结构
public class SonyFactory extends GameFactory {
    @Override
    public ACT createACTGame() {
        return new GodOfWar();
    }

    @Override
    public RPG createRPGGame() {
        return new TheLastOfUs();
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        SonyFactory sonyFactory = new SonyFactory();
        System.out.println("\n创建索尼下的RPG游戏：");
        RPG sonyRPGGame = sonyFactory.createRPGGame();
        sonyRPGGame.name();
        sonyRPGGame.details();

        System.out.println("\n创建索尼下的ACT游戏：");
        ACT sonyACTGame = sonyFactory.createACTGame();
        sonyACTGame.name();
        sonyACTGame.details();
        sonyACTGame.level();
    }
}

// 控制台输出
 创建索尼下的RPG游戏：
 游戏：最后生还者
 开发商：人类因现代传染病而面临绝种危机，当环境从废墟的都市再度自然化时……

 创建索尼下的ACT游戏：
 游戏：战神
 游戏介绍：奎托斯与儿子成功将母亲的遗骨撒落在高山，但门外的男人究竟是……
 上手难度：★★☆☆☆
```

可以看到，我们只需要在产品接口的基础上，完成对索尼产品的具体实现，并新增一个索尼工厂，即可获得索尼产品族下的所有产品。也就是对于扩展性而言，新增一个产品族非常简单，没有破坏开闭原则，而当新增产品等级结构时，需要修改现有的抽象工厂类以及工厂类的实现会破坏开闭原则。

适用场景：系统需要与多个产品族进行交互（例如windows与mac、跨平台应用）