# 责任链（Chain of Command）

责任链可以使多个对象都有机会处理请求，我们只需要将这些对象串成一条链，那么请求就会在这条链上传递，直到被成功处理为止。责任链的一大优点就是灵活，我们可以为每个请求分配属于自己的工作链，并且可以轻松扩展。例如我们现在有吃饭、睡觉、学习三个行动，对于婴儿来说，我们只需要为其分配吃饭和睡觉，而儿童我们则可以在吃饭后追加一个学习的行为。

责任链主要由**抽象处理者**、**具体处理者**、**客户端**三个角色组成：

1. 抽象处理者：负责定义处理请求的接口，并且持有对下一处理者的引用

2. 具体处理者：抽象处理者的子类，负责实现抽象处理者的方法并完成对应逻辑

3. 客户端：调用的一方，在这里我们需要完成责任链的创建并设置每个责任链的上级

这里我们以公司内申请预算为例，如果金额在100及以下，那么交给小组审核，如果在1000及以下则交给经理，在1000以上则交给CEO处理，那么我们的责任链就可以串为小组-经理-CEO。具体代码如下：

```java
// 抽象处理者
public abstract class Handler {

    protected Handler handler;

    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract boolean request(int price);
}

// 小组具体处理者
public class GroupHandler extends Handler{

    @Override
    public boolean request(int price) {
        if (price >= 10 && price <= 100) {
            System.out.println("组审核成功！");
            return true;
        }
        System.out.println("组审核失败，发送至下一级");
        return handler.request(price);
    }
}

// 经理具体处理者
public class ManagerHandler extends Handler{

    @Override
    public boolean request(int price) {
        if (price > 100 && price <= 1000) {
            System.out.println("管理审核成功");
            return true;
        }
        System.out.println("管理审核失败，发送至下一级");
        return handler.request(price);
    }
}

// CEO具体处理者
public class CEOHandler extends Handler{

    @Override
    public boolean request(int price) {
        if (price > 1000 && price < 10000) {
            System.out.println("CEO审核成功");
            return true;
        }
        System.out.println("金额过大，通过失败！");
        return false;
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        // 创建所有责任链
        GroupHandler groupHandler = new GroupHandler();
        ManagerHandler managerHandler = new ManagerHandler();
        CEOHandler CeoHandler = new CEOHandler();
        // 设置每个责任链的上级
        groupHandler.setNextHandler(managerHandler);
        managerHandler.setNextHandler(CeoHandler);
        System.out.println(groupHandler.request(1001));
    }
}

// 控制台输出
 组审核失败，发送至下一级
 管理审核失败，发送至下一级
 CEO审核成功
 true
```

适用场景：一个请求需要被多个对象按照顺序处理时、规则校验