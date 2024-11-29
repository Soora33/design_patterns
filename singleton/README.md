# 单例模式（Singleton）

单例模式是设计模式中最简单也是最好理解的一个模式，它确保一个类只有一个实例，并且这个实例对外开放，可以被其他类调用使用。单例的核心在于如何`创建单例`，创建单例的方式常用的有4种，这里因为篇幅原因仅使用`静态内部类`的方式来实现单例，因为它保证了懒加载并且避免了同步开销。想知道其他3种创建方式和进一步了解单例的可以查看这篇文章：[手写单例模式以及保证安全性](https://33sora.com/posts/59324e24.html)

首先我们先来看一下使用静态内部类实现单例的代码：

```java
// 单例创建对象 音乐类
public class Music {

    // 私有化构造方法，防止外部实例化
    private Music() {}

    private static class Handler {
        private static final Music INSTANCE = new Music();
    }

    public static Music getInstance() {
        return Handler.INSTANCE;
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        Music music1 = Music.getInstance();
        Music music2 = Music.getInstance();
        System.out.println(music1);
        System.out.println(music2);
    }
}

// 控制台输出
com.sora.Music@72ea2f77
com.sora.Music@72ea2f77
```

我们以音乐类举例，需要私有化构造方法，防止外部创建对象。继续在内部创建一个静态内部类，我们都知道**静态成员**（如静态变量和静态方法）随着类的加载而加载，而静态内部类的加载是**延迟的**，只有在被显式调用时才会加载。因此，静态内部类不仅实现了懒加载，而且避免了同步开销，同时又保证了线程安全。

这里继续说点跟单例相关的几个问题，感兴趣的可以看看：

在Spring框架中，Bean默认是单例的，这是基于**Spring容器级别**的单例，它的生命周期和Spring容器生命周期绑定，而我们通过Java创建的单例对象则是**JVM级别**，会在整个应用程序的JVM生命周期内存在。

Spring中，我们可以通过**@Scope("Prototype")**将默认的单例创建改为原型创建。还有request、session等，这些都用的不多

使用单例对象时，我们的重点肯定是线程安全性。假设我们有一个类负责累加一个数并且返回，如果此时多个线程都调用了这个类，而这个类又是由Spring管理且是单例的，那么Spring如何保证线程安全呢？答案是Spring并不会保证多线程下的线程安全。因此多线程环境下，如果该单例对象存在可变状态，就需要我们手动处理线程安全问题，常见的几种方法如下：

	1. 无状态设计：无状态表示该对象不包含任何可变的实例对象，每次调用方法时，所有操作都依赖参数进行处理
	2. 使用局部变量：如果我们要保存一个临时结果，不要使用全局变量！使用**局部变量**！因为局部变量是线程私有的，线程之间不会共享。
	3. ThreadLocal：ThreadLocal为每一个线程都提供了一个副本，实现了线程间的隔离
	4. 如果这个类必须要使用全局变量保存一些数据，那么必须使用线程安全的类，例如**ConcurrentHashMap**

适用场景：缓存类的实现、线程池管理、全局ID生成器、数据库连接池等等