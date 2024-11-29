# 工厂方法（Factory Method）

**PS: 在学习工厂方法之前，建议先了解简单工厂，会更方便理解～** 

工厂方法在简单工厂的基础上做了一些修改，将原本一个工厂拆开了，每个对象都有属于自己的工厂。工厂方法共有四个角色：

1. 产品接口：定义所有产品的行为
2. 产品实现类：实现产品接口，负责具体的产品实现
3. 抽象工厂：所有工厂实现类的父类，声明返回产品对象的工厂方法，返回值必须是**产品接口**
4. 工厂实现类：继承抽象工厂类，重写返回产品对象工厂的方法，使其返回不同类型的产品

下面我们以创建不同的支付对象举例，代码如下：

```java
// 支付接口
public interface Pay {
    void pay();
}

// 支付宝支付类
public class AliPay implements Pay {
    @Override
    public void pay() {
        System.out.println("用户使用AliPay支付，开始执行具体逻辑……");
    }
}

// 微信支付类
public class WechatPay implements Pay {
    @Override
    public void pay() {
        System.out.println("用户使用微信支付，开始执行具体逻辑……");
    }
}
```

到目前为止都是跟简单工厂一样，工厂部分可以看到阿里云和微信都有对应的工厂且继承了一个抽象类，这个抽象类就是负责声明一个创建工厂的方法。具体工厂代码如下：

```java
// 支付工厂 所以支付对象工厂都要继承 相当于父类
public abstract class PayFactory {
    public abstract Pay getPayType();
}

// 阿里云支付工厂
public class AliPayFactory extends PayFactory {
    @Override
    public Pay getPayType() {
        return new AliPay();
    }
}

// 微信支付工厂
public class WechatPayFactory extends PayFactory {
    @Override
    public Pay getPayType() {
        return new WechatPay();
    }
}
```

之后通过参数来控制工厂的创建并调用支付方法，以后要新增支付方法，只需要实现一个新的支付类，创建一个新的支付工厂即可，解决了简单工厂的弊端（新增内容需要修改工厂类），符合开闭原则。下面是具体的客户端代码：

```java
public class Main {
    public static void main(String[] args) {
        // 支付参数
        String param = "ali";

        PayFactory factory = null;
        if ("wechat".equals(param)) {
            factory = new WechatPayFactory();
        } else if ("ali".equals(param)) {
            factory = new AliPayFactory();
        }

        Pay payType = factory.getPayType();
        payType.pay();
    }
}

// 控制台输出
 用户使用AliPay支付，开始执行具体逻辑……
```

适用场景：开发与线上环境的快速切换，数据库连接类型，多类型文件生成与读取等等