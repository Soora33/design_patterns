# 简单工厂（Simple Factory）

简单工厂是由一个接口、多个接口实现类以及一个工厂类组成，我们以游戏平台举例，平台就是一个接口，而Steam、Epic等就是具体的实现类，工厂类则是负责创建实现类的地方。我们具体来看代码：

```java
// 接口类
public interface Platform {
    void print();
}

// 第一个实现类
public class Epic implements Platform {
    @Override
    public void print() {
        System.out.println("我是Epic平台");
    }
}

// 第二个实现类
public class Origin implements Platform {
    @Override
    public void print() {
        System.out.println("我是橘子平台");
    }
}

// 第三个实现类
public class Steam implements Platform {
    @Override
    public void print() {
        System.out.println("我是Steam平台");
    }
}

// 工厂类
public class GamePlatform {
    public Platform getPlatform(String platform) {
        if ("Epic".equalsIgnoreCase(platform)) {
            return new Epic();
        } else if ("Steam".equalsIgnoreCase(platform)) {
            return new Steam();
        } else if ("Origin".equalsIgnoreCase(platform)) {
            return new Origin();
        }
        return null;
    }
}

// 使用简单工厂
public class Main {
    public static void main(String[] args) {
        String param = "steam";
        // 创建工厂类实例
        GamePlatform gamePlatform = new GamePlatform();

        Platform steam = gamePlatform.getPlatform(param);
        steam.print();
        param = "epic";
        Platform epic = gamePlatform.getPlatform(param);
        epic.print();
    }
}

// 控制台输出
 我是Steam平台
 我是Epic平台
```

如果我们不使用简单工厂来完成这个案例，我们会直接new Steam(), new Epic()来完成对象的创建，那我们为什么要把创建对象的任务交给工厂类呢？因为简单工厂提供了**解耦、维护性和灵活性**。如果我们不使用简单工厂，那么当一个对象的构造逻辑发生改变，例如需要传入一些固定参数，我们需要在每一个用到的地方去修改并测试，但如果是简单工厂，我们直接在工厂类内进行修改即可，这便是解耦和维护。灵活性则表现在扩展，如果后续我们需要新加平台，没有使用简单工厂的情况下，我们需要去每一个地方去手动新增一个平台，而简单工厂只需要新增一个实现类，随后在工厂类内新加一个条件即可，通过参数来控制工厂类获取的具体实现对象。但这样破坏了开闭原则（对扩展开放，对修改关闭），所以工厂方法就这样出来了。

