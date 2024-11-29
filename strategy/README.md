# 策略模式（Strategy）

策略模式可以将我们定义的一系列算法，封装到一个个独立的类中，在运行时选择不同的算法。策略模式的角色由策略接口、策略接口实现类和上下文类组成：

策略接口：是所有实现类的共同接口

接口实现类：负责实现具体的策略，封装算法详情

上下文类：提供策略对象的引用并通过接口调用返回具体策略的算法

这里以用户观看动画来做示例，现在我们有一个动画对象，其中名字、上线年份、集数字段有值，字幕组字段没值，因为有的人喜欢A字幕组、有的人喜欢B字幕组，所以我们要让用户自己选择看哪个字幕组，用户选A我们就加载A字幕，选B我们就加载B字幕，我们通过策略模式完成这个需求，具体代码如下：

```java
// 动画类
public class Anime {
    private String name;
    private String onlineYear;
    private String episodes;
    private String subTitle;

    public Anime() {
    }

    public Anime(String name, String onlineYear, String episodes, String subTitle) {
        this.name = name;
        this.onlineYear = onlineYear;
        this.episodes = episodes;
        this.subTitle = subTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnlineYear() {
        return onlineYear;
    }

    public void setOnlineYear(String onlineYear) {
        this.onlineYear = onlineYear;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                ", onlineYear='" + onlineYear + '\'' +
                ", episodes='" + episodes + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}

// 字幕的策略接口
public interface Subtitle {
    Anime getAnime(Anime anime);
}

// 北宇治字幕组实现策略接口
public class KitaujiSub implements Subtitle {
    @Override
    public Anime getAnime(Anime anime) {
        anime.setSubTitle("北宇治字幕组");
        return anime;
    }
}

// 樱花字幕组实现策略接口
public class SakuraSub implements Subtitle {
    @Override
    public Anime getAnime(Anime anime) {
        anime.setSubTitle("樱花字幕组");
        return anime;
    }
}

// 选择字幕的上下文类
public class SubContext {

    private Subtitle subtitle;
    private Anime anime;

    public SubContext(Subtitle subtitle,Anime anime) {
        this.subtitle = subtitle;
        this.anime = anime;
    }

    public Anime getSubtitle() {
        return subtitle.getAnime(anime);
    }

}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        // 创建2个动漫对象，字幕字段的值通过策略选择完成
        Anime oshinoko = new Anime();
        oshinoko.setName("推しのこ");
        oshinoko.setOnlineYear("2024");
        oshinoko.setEpisodes("12");

        Anime makehiro = new Anime();
        makehiro.setName("負けヒロインは多すぎる");
        makehiro.setOnlineYear("2024");
        makehiro.setEpisodes("12");

        // 通过上下文对象获取加工完成的动画，参数为对应加工策略和动画对象
        SubContext oshinokoSub = new SubContext(new KitaujiSub(), oshinoko);
        SubContext makeiros = new SubContext(new SakuraSub(), makehiro);

        System.out.println(oshinokoSub.getSubtitle());
        System.out.println(makeiros.getSubtitle());
    }
}

// 控制台输出
 Anime{name='推しのこ', onlineYear='2024', episodes='12', subTitle='北宇治字幕组'}
 Anime{name='負けヒロインは多すぎる', onlineYear='2024', episodes='12', subTitle='樱花字幕组'}
```

上面的例子中，`算法`就是不同的字幕组策略，通过传入不同的`算法`来使动画对象获取到不同的加工结果。策略模式同样应用在线程池创建时选择的拒绝策略上，下为四个拒绝策略的源码，可以看出策略接口为`RejectedExecutionHandler`，四个拒绝策略分别实现了各自的算法。


```java
public static class CallerRunsPolicy implements RejectedExecutionHandler {
        public CallerRunsPolicy() { }
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                r.run();
            }
        }
    }

public static class AbortPolicy implements RejectedExecutionHandler {
    public AbortPolicy() { }

    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        throw new RejectedExecutionException("Task " + r.toString() +
                                             " rejected from " +
                                             e.toString());
    }
}

public static class DiscardPolicy implements RejectedExecutionHandler {
    public DiscardPolicy() { }
  
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    }
}

public static class DiscardOldestPolicy implements RejectedExecutionHandler {
    public DiscardOldestPolicy() { }
  
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        if (!e.isShutdown()) {
            e.getQueue().poll();
            e.execute(r);
        }
    }
}
```

**都说策略模式消除if-else，在选择策略的时候不还要用if-else判断选择哪个策略吗？**

策略模式消除的是**行为执行中的`if-else`**，也就是说在执行某个动作的时候不再显示地判断使用哪种实现。举个例子就是支付场景下，我们会有很多支付方式，微信、支付宝、银行卡、信用卡等等，不使用策略模式的话，我们需要if判断用户选择的方式，然后执行这个方式所对应的代码。使用策略模式的情况下，上面的这些支付方式会被封装为一个个策略类，我们只需要通过上下文类引入对应策略即可完成，代码中没有了选择支付方式的if-else。消除的就是这部分的if-else。同时策略模式的引入也让代码具有了更好的维护性和扩展性，以后新增支付方式，我们只需要新增一个策略类即可，不需要修改原代码。这个时候可能就有人问：`那么我们在选择策略的时候不还要使用if-else吗？`关于这个问题，我们可以通过一个Map解决。具体如下：

```java
public class Main {
    
    private static final Map<String, Subtitle> SUB_MAP = new HashMap<>(){{
        put("sakura", new SakuraSub());
        put("kitauji", new KitaujiSub());
    }};
    
    public static void main(String[] args) {
        // 创建2个动漫对象，字幕字段的值通过策略选择完成
        Anime oshinoko = new Anime();
        oshinoko.setName("推しのこ");
        oshinoko.setOnlineYear("2024");
        oshinoko.setEpisodes("12");

        Anime makehiro = new Anime();
        makehiro.setName("負けヒロインは多すぎる");
        makehiro.setOnlineYear("2024");
        makehiro.setEpisodes("12");

        // 通过上下文对象获取加工完成的动画，参数为对应加工策略和动画对象
        SubContext oshinokoSub = new SubContext(SUB_MAP.get("kitauji"), oshinoko);
        SubContext makeiros = new SubContext(SUB_MAP.get("sakura"), makehiro);
        System.out.println(oshinokoSub.getSubtitle());
        System.out.println(makeiros.getSubtitle());
    }
}
```

我们可以将所有的策略放入一个Map内，然后通过用户选择的key直接获取对应的策略，即可消除选择策略时的if-else。

**策略模式与工厂方法模式有什么区别？**

相信大部分人看完策略模式，会发现和工厂方法模式很像，确实这两者在结构上很像，但各自的目的又不一样。首先第一点从设计上来看，工厂方法模式属于创建型，关注的是对象的创建，而策略模式则是行为型，关注的是对算法的封装。第二点结构差异上，工厂方法包含1个接口，多个实现类和多个实现类的工厂，通过指定的工厂创建出指定的类。而策略模式包含1个策略接口、多个策略实现类和1个上下文类，通过一个上下文类选择一个策略。

适用场景：多场景支付、文件解压缩、某功能经常迭代且每次都要加入新逻辑等等