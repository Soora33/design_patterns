# 观察者（Observer）

观察者模式可以在一个对象发生改变时，通知所有依赖于它的对象。就跟订阅机制一样，当有更新时，所有订阅了该频道的人都会收到消息通知，这些人可以去看新消息，也可以不看，这都取决于订阅者的操作。

观察者模式由被观察者接口、被观察者实现类、观察者接口和观察者实现类组成：

1. 被观察者接口：主题是被观察者的对象，提供添加、删除、**通知观察者**方法

2. 被观察者实现类：被观察的对象，实现被观察者接口，可以通过**通知观察者**方法告诉所有观察者

3. 观察者接口：通常只会有一个方法。所有观察者类必须实现该接口来接收通知

4. 观察者实现类：实现了观察者接口的类，当观察的对象改变时，被观察者会调用观察者接口内的方法，并执行对应观察者类的逻辑

下面的代码以CEO为被观察的对象，员工和经理为观察者，首先将员工和经理添加到了CEO的观察者集合内，CEO调用接口发起通知，此时二者都会接收到消息。继续将员工踢出观察者集合，CEO再次调用接口，只有经理收到消息。具体代码如下：

```java
// 被观察者接口
public interface Observer {
    void addSubject(Subject subject);

    void removeSubject(Subject subject);

    void notifyObservers(String message);
}

// 被观察者实现类
public class CEOObServer implements Observer{

    private List<Subject> observers = new ArrayList<>();

    @Override
    public void addSubject(Subject subject) {
        observers.add(subject);
    }

    @Override
    public void removeSubject(Subject subject) {
        observers.remove(subject);
    }

    @Override
    public void notifyObservers(String message) {
        observers.forEach(data -> data.update(message));
    }
}

// 观察者接口
public interface Subject {
    void update(String message);
}

// 员工观察者实现类
public class EmployeeSubject implements Subject{
    @Override
    public void update(String message) {
        System.out.println("EmployeeSubject : " + message);
    }
}

// 经理观察者实现类
public class ManagerSubject implements Subject{
    @Override
    public void update(String message) {
        System.out.println("ManagerSubject : " + message);
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        // 创建一个CEO发布者和2个订阅者
        CEOObServer ceoObServer = new CEOObServer();
        EmployeeSubject employeeSubject = new EmployeeSubject();
        ManagerSubject managerSubject = new ManagerSubject();

        ceoObServer.addSubject(employeeSubject);
        ceoObServer.addSubject(managerSubject);

        // 发布者发布消息
        ceoObServer.notifyObservers("消息通知");
        System.out.println("---删除employee订阅者---");
        ceoObServer.removeSubject(employeeSubject);
        ceoObServer.notifyObservers("新消息通知");
    }
}

// 控制台输出
 EmployeeSubject : 消息通知
 ManagerSubject : 消息通知
 ---删除employee订阅者---
 ManagerSubject : 新消息通知
```

适用场景：消息系统、多人协作实时编辑、对特定数据值进行监听等等