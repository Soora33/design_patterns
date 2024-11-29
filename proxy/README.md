# 代理（Proxy）

代理模式的核心思想是不直接操作原对象，而是通过代理类来完成操作，这样就可以在不改变原对象的前提下，加入额外的功能。举个例子，我们平时买房时，可以选择找中介，中介会在了解我们的要求后给出几个合适的房子供我们选择，其中，中介作为代理，替我们完成了筛选房子的过程。这就是代理模式的作用，不接触真实对象（各式各样的房源）的前提下，通过代理提供额外操作（筛选房子的过程）。带来的好处就是解耦，通过代理对象来去做与核心业务无关的功能。

代理在Java中可以分为两种，`静态代理`和`动态代理`，其中动态代理又包含`JDK代理和CGLIB代理`。

**静态代理和动态代理的区别：**

静态代理在编译时就确定类，由我们手动实现的，所以目标类越多，我们需要写的代码就越多，灵活性就差了，导致维护成本高。动态代理则是在运行时生成代理类，不需要我们手动编写，因为是基于反射和字节码，我们只需要写一个动态代理类即可完成所有类的代理。但因为用到了反射，所以性能没有静态代理高。

**JDK动态代理和CGLIB代理的区别：**

JDK动态代理是基于Java反射机制，仅能代理实现了接口的类；CGLIB动态代理是基于字节码生成，可以代理没有实现接口的类。在效率方面，方法多的情况下，CGLIB的效率会比较高，但一般会选择JDK动态代理，除非没有实现接口。

在代理模式中，有三个角色，**抽象主题**、**真实主题**和**代理类**。

1. 抽象主题：一个公共接口，真实主题和代理类都要实现这个接口
2. 真实主题：实现抽象主题，处理真实的逻辑
3. 代理类：实现抽象主题，引入真实主题，并在执行真实主题前后、进行额外操作

下面我会针对这三个代理模式进行演示：

**静态代理：**

下面我以代理播放器为例，播放器是用来播放媒体的，我们在代理类中加入一些解码编码的额外操作。具体代码：

```java
// 抽象主题
public interface Media {
    void play();
}

// 播放器（真实主题）
public class Player implements Media{
    @Override
    public void play() {
        System.out.println("正在播放媒体……");
    }
}

// 代理播放器（代理类）
public class PlayerProxy implements Media{

    private Player player;

    @Override
    public void play() {
        System.out.println("静态代理：加载解码器……");
        if (player == null) {
            player = new Player();
        }
        player.play();
        System.out.println("静态代理：文件播放完成");
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        PlayerProxy playerProxy = new PlayerProxy();
        playerProxy.play();
    }
}

// 控制台输出
 静态代理：加载解码器……
 正在播放媒体……
 静态代理：文件播放完成
```

其实很简单，就是新建了一个类，引入了真实主题，并且在执行具体逻辑之前，额外加入一些操作。这就是静态代理，但每有一个需要代理的类，我们就要像这样手写一个代理类，很是麻烦，下面我们就来使用动态代理解决这个问题。

**动态代理：**

`JDK代理：`

jdk代理仅支持实现了接口的类，这一点一定要注意！和静态代理相比，代理类是通过生成器生成的，我们需要将额外的操作写在生成器内，下面是具体代码：

```java
// 抽象主题
public interface Media {
    void play();
}

// 真实主题
public class Player implements Media {
    @Override
    public void play() {
        System.out.println("正在播放媒体……");
    }
}

// 代理类（由生成器生成）
public class JDKProxyHandler implements InvocationHandler {

    private Object target;

    public JDKProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK：加载解码器……");
        Object result = method.invoke(target, args);
        System.out.println("JDK：文件播放完成");
        return result;
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        // 创建目标对象
        Player player = new Player();
        // 创建代理对象
        Media playerProxy = (Media)Proxy.newProxyInstance(
                player.getClass().getClassLoader(), // 类加载器
                player.getClass().getInterfaces(), // 目标接口
                new JDKProxyHandler(player) // 动态代理处理器
        );
        // 调用代理对象的方法
        playerProxy.play();
    }
}

// 控制台输出
 JDK：加载解码器……
 正在播放媒体……
 JDK：文件播放完成
```

在JDK代理中，通过`Proxy.newProxyInstance`动态生成的代理类是目标类实现接口的字类，会重写接口中的方法，所以实际上调用的是`invoke`方法，而非原本的目标方法。

`CGLIB代理：`

CGLIB使用字节码增强目标类，所以对于不实现接口的类也可以用。Spring中，如果目标类实现了接口，则使用JDK动态代理，没有实现接口则使用CGLIB代理。

使用CGLIB代理前，我们需要引入依赖。目前CGLIB已经停止维护，最新版本为3.3.0，对于Java17以上的，由于增强了对反射的限制，还需要在启动行加上一段命令

```xml
<dependency>
  <groupId>cglib</groupId>
  <artifactId>cglib</artifactId>
  <version>3.3.0</version>
</dependency>

// Java17以上的需要在启动行加一段命令
add-opens java.base/java.lang=ALL-UNNAMED
```

```java
// 真实主题
public class Player {
    public void play() {
        System.out.println("正在播放媒体……");
    }
}

// CGLIB
public class CGLIBProxyHandler implements MethodInterceptor {

    private Object target;

    public CGLIBProxyHandler(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        // 创建增强器类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB：加载解码器……");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("CGLIB：文件播放完成");
        return result;
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        // 创建目标对象
        Player player = new Player();
        // 创建代理对象
        CGLIBProxyHandler proxyHandler = new CGLIBProxyHandler(player);
        Player proxy = (Player) proxyHandler.createProxy();
        // 调用代理对象方法
        proxy.play();
    }
}

// 控制台输出
 CGLIB：加载解码器……
 正在播放媒体……
 CGLIB：文件播放完成
```

CGLIB代理的代理类是目标类的子类，重写了目标类的非final方法，重写的方法调用了`intercept`方法，所以在调用代理对象方法时，会进入`intercept`方法内。

适用场景：权限控制、缓存代理、Spring的AOP代理等等