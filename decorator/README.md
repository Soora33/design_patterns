# 装饰器（Decorator）

装饰器模式可以允许我们在不改变对象结构的情况下，动态地给对象添加功能。

装饰器模式的角色通常有四个，分别是**抽象组件**、**具体组件**、**装饰器类**、**具体装饰器**组成。其实这几个角色很好理解，用商品打折来举例的话，抽象组件就是一个商品接口，定义了商品的各种信息。具体组件则是商品的具体实现，例如牛奶、香蕉、咖啡等。装饰器类则表示需要对商品进行某些装饰（如打折）。具体装饰器是具体的折扣实现，比如是满减，还是打折。下面是角色之间的关系：

1. 抽象组件：一个抽象接口，是原始对象和装饰类的共同接口
2. 具体组件：实现抽象组件接口
3. 装饰器类：是一个抽象类且实现了抽象组件接口。持有一个抽象组件对象的引用。它不实现具体功能，而是提供了一个装饰器类的基础结构，我们可以以这个为基础扩展出多个具体装饰器类。
4. 具体装饰器：继承装饰器类，提供功能扩展，比如在原始对象的基础上新增属性、加工一些数据等

下面以购买一个商品，该商品可以使用折扣优惠、也可以使用优惠卷优惠为场景，具体代码如下：

```java
// 抽象组件
public interface Goods {
    String desc();
    Double price();
}

// 具体组件
public class Milk implements Goods {
    String desc;
    Double price;

    public Milk(String desc, Double price) {
        this.desc = desc;
        this.price = price;
    }

    @Override
    public String desc() {
        return desc;
    }

    @Override
    public Double price() {
        return price;
    }
}

// 装饰器类
public abstract class GoodsDecorator implements Goods {
    protected Goods goods;

    public GoodsDecorator(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String desc() {
        return goods.desc();
    }

    @Override
    public Double price() {
        return goods.price();
    }
}

// 优惠卷装饰器-具体装饰器
public class CouponDecorator extends GoodsDecorator {

    private Double coupon;

    public CouponDecorator(Goods goods, Double coupon) {
        super(goods);
        this.coupon = coupon;
    }

    @Override
    public String desc() {
        return goods.desc() + ", 直减: " + coupon + "元";
    }

    @Override
    public Double price() {
        return goods.price() - coupon;
    }
}

// 折扣装饰器-具体装饰器
public class DiscountDecorator extends GoodsDecorator {

    private Double discount;

    public DiscountDecorator(Goods goods,Double discount) {
        super(goods);
        this.discount = discount;
    }

    @Override
    public String desc() {
        return goods.desc() + ", 折扣力度: " + discount  + "折";
    }

    @Override
    public Double price() {
        return goods.price() * discount;
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        // 创建一个商品并打印基础信息
        Milk milk = new Milk("牛奶", 2.5);
        System.out.println("商品基础信息：");
        System.out.println(milk.desc());
        System.out.println(milk.price());
        System.out.println("====================");
        // 使用折扣装饰
        DiscountDecorator discountDecorator = new DiscountDecorator(milk, 0.75);
        System.out.println("商品（折扣）信息：");
        System.out.println(discountDecorator.desc());
        System.out.println(discountDecorator.price());
        System.out.println("====================");
        // 使用优惠券装饰
        CouponDecorator couponDecorator = new CouponDecorator(milk, 0.5);
        System.out.println("商品（优惠卷）信息：");
        System.out.println(couponDecorator.desc());
        System.out.println(couponDecorator.price());
        System.out.println("====================");
    }
}

// 控制台输出
商品基础信息：
牛奶
2.5
====================
商品（折扣）信息：
牛奶, 折扣力度: 0.75折
1.875
====================
商品（优惠卷）信息：
牛奶, 直减: 0.5元
2.0
====================
```

上面的代码中，我创建了一个商品接口并实现了这个接口，分别是`Goods`和`Milk`，现在我们需要对牛奶进行装饰，例如折扣就是一个装饰，优惠卷也是一个装饰。所以我们需要先创建一个抽象类并实现`Goods`接口，这个抽象类就是装饰器类，它持有一个原对象的引用，随后我们就可以去继承这个抽象类，并在每个具体的装饰器类完成对原始对象的包装，这就是装饰器模式的作用。

**装饰器模式和代理模式有什么区别？**

装饰器和代理确实很相似，都是通过包装一个对象，扩展功能或控制行为，但他们还是有一些关键差异，具体如下：

目的不同：装饰器的重点在于扩展，增强了自身的功能。而代理侧重于控制访问，通常用于对原始对象做预处理、后处理和权限控制等

透明性：客户端是知道装饰器的存在，且可以通过不同的装饰器实现功能叠加。对于代理模式，客户端通常是不知道其存在的

适用场景：需要动态增加功能的场景（购物车各种商品的优惠）、文件的加密处理等