# 外观（Facade）

外观模式也叫门面模式，通过提供一个简单的接口，将复杂的子系统包装起来，简化了客户端与复杂系统之间的交互，隐藏了内部细节。外观模式有2个角色，分别是外观类和子系统类，**外观类**负责提供统一的外部接口调用，调用各个子系统的功能。**子系统类**则是负责实现系统的具体功能，被外观类调用。下面以用户查看订单为例完成一个外观模式：

```java
// 订单接口
public interface Order {
    void logic();
}

// 获取订单编号类
public class OrderNumber implements Order {
    @Override
    public void logic() {
        System.out.println("订单编号：1097361294729");
    }
}

// 获取订单价格类
public class OrderPrice implements Order {
    @Override
    public void logic() {
        System.out.println("订单金额：1020元");
    }
}

// 获取订单名称类
public class OrderShop implements Order {
    @Override
    public void logic() {
        System.out.println("订单商品名：TouHou Remilia card");
    }
}

// 外观类
public class FacadeOrder {

    private OrderNumber orderNumber;
    private OrderPrice orderPrice;
    private OrderShop orderShop;

    public FacadeOrder() {
        orderNumber = new OrderNumber();
        orderPrice = new OrderPrice();
        orderShop = new OrderShop();
    }

    public void getNumber() {
        orderNumber.logic();
    }

    public void getShop() {
        orderShop.logic();
    }

    public void getPrice() {
        orderPrice.logic();
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        FacadeOrder facadeOrder = new FacadeOrder();
        facadeOrder.getShop();
        facadeOrder.getNumber();
        facadeOrder.getPrice();
    }
}

// 控制台输出
 订单商品名：TouHou Remilia card
 订单编号：1097361294729
 订单金额：1020元
```

其实很简单，外观模式就是对多个类的操作进行了封装，将原本需要调用3个或更多接口的操作统一封装到了一个类里，我们只需要对外暴露出外观类即可，这样调用方只需要调用一个接口就可以完成之前需要调用多个不同的接口才能完成的功能。减少了客户端与子系统之间的耦合，不过要注意不要过多的使用外观模式，否则系统反而失去了模块化的优势。

适用场景：用户下单、多支付场景集成、需要对外提供一个统一接口且内部实现比较复杂等等