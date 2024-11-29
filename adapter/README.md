# 适配器（Adapter）

适配器模式用于将一个类的接口转为期望的一个接口，来使原本不兼容的接口可以正常工作，适配器的核心是为现有类提供一个兼容的接口，解决接口不兼容的问题，而不需要修改原有代码。

适配器主要有三个角色，分别是**目标接口、被适配类、适配器类**。

1. 目标接口：客户端所期望的接口，也就是客户想要的数据类型
2. 被适配类：需要被适配的类，且这个类目前无法直接转为目标接口
3. 适配器类：实现目标接口，将被适配类转为目标接口，从而让客户端和被适配类完美工作

下面我以货币间转换来举例，我们现在有2个货币类，日元类和人民币类，日元类将输入的金额转为美元、人民币类则直接返回输入的金额。如果需要将日元转为人民币，那么目标接口就是**人民币类（因为我们的目标是返回人民币）**、被适配类是**日元类（目前日元功能是转为美元，不符合我们需求，所以需要被适配）**，**适配器类（进行具体转换的类）**就是我们新建的类。具体代码如下：

```java
// 人民币类
public class Cny {

    private Double rmb;

    public Cny() {
    }

    public Cny(Double rmb) {
        this.rmb = rmb;
    }

    public Double getRmb() {
        return rmb;
    }
}

// 日元类
public class Jpy {

    private Double jpy;

    public Jpy() {
    }

    public Jpy(Double jpy) {
        this.jpy = jpy;
    }

    public Double getJpy() {
        return jpy / 144.33;
    }
}

// 适配器类
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

// 客户端
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

// 控制台输出
 人民币类输入金额：100.0 ，返回：100.0
 日元类输入金额：100.0 ，返回：0.6928566479595372
 适配器类输入金额：100.0 ，返回：4.884639368114737
```

对于适配器类，我们一般记住，实现/继承的是目标接口、将被适配类引入并获取结果对其转换。

下面再来看一个例子，new Thread()接受的参数是Runnable类型，那如何支持Callable类型的任务呢，同样新建一个适配器接口即可。

```java
// Callable接口的任务 不可以作为new Thread的参数
public class SimpleCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("callable执行成功");
        return true;
    }
}

// 适配器类，实现Runnable接口，并将callable的任务引入，在run方法内执行
public class RunnableAdapter implements Runnable{

    private Callable callable;

    public RunnableAdapter(Callable myCallable) {
        this.callable = myCallable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        Callable callable = new SimpleCallable();
        // callable不可以作为Thread的参数
				// Thread thread = new Thread(callable);

        // 通过适配器将其转为Runnable
        RunnableAdapter adapter = new RunnableAdapter(callable);
        Thread thread = new Thread(adapter);
        thread.start();
    }
}
```

我们的目标是将Callable转为Runnable，所以目标接口是Runnable，将被适配的类引入，进行逻辑重写，这里我们仅仅调用call方法即可。随后Callable类型的接口，经过适配器转换就可以变为Runnable类型的接口。

这就是适配器模式，适配器在我们的代码中有很多表现形式，这里也仅仅是冰山一角，但其核心思想是将不兼容的对象变为兼容的对象。

适用场景：第三方库的兼容、多格式文件转为统一格式、多日志集成等等