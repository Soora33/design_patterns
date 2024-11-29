# 模板方法（Template Method）

模板方法通常用来定义**算法的框架**，将算法中的一些步骤延迟到子类，使子类可以在不改变算法结构的情况下重新定义算法中的某些步骤。模板方法的结构非常简单，只有父类和子类：

1. 抽象类：模板方法的核心，定义了算法的框架，包含一个模板方法、一个或多个抽象方法、可选的初始化方法以及钩子方法（钩子方法可以在子类中选择是否重写，通常用来修改模板方法内的一些逻辑）

2. 具体类：继承抽象类并实现抽象方法，完成该算法的具体实现。

我们以游戏创建角色时选择角色属性为例，具体代码如下：

```java
// 模板方法
public abstract class BaseBoard {

    public final void createPerson() {
        // 初始化玩家职业
        initProfession();
        // 初始化玩家基础属性
        initAttr();
        // 初始化玩家出生地
        initAddress();
        // 初始化玩家等级
        initLevel();
        // 玩家是否选择了初始道具
        if (chooseItem()) {
            initItem();
        }
    }

    protected abstract void initProfession();
    protected abstract void initAttr();
    protected abstract void initAddress();
    protected boolean chooseItem() {
        return false;
    };

    private void initLevel() {
        System.out.println("等级：1");
    }

    private void initItem() {
        System.out.println("初始道具：火焰壶");
    }
}

// 子类 魔法师
public class Mage extends BaseBoard {
    @Override
    protected void initProfession() {
        System.out.println("职业：魔法师");
    }

    @Override
    protected void initAttr() {
        System.out.println("属性：");
        System.out.println("    生命： 3");
        System.out.println("    力量： 0");
        System.out.println("    魔力： 12");
        System.out.println("    耐力： 5");
    }

    @Override
    protected void initAddress() {
        System.out.println("出生地：雷古拉魔法学院");
    }
}

// 子类 战士
public class Warrior extends BaseBoard {
    @Override
    protected void initProfession() {
        System.out.println("职业：战士");
    }

    @Override
    protected void initAttr() {
        System.out.println("属性：");
        System.out.println("    生命： 7");
        System.out.println("    力量： 10");
        System.out.println("    魔力： 1");
        System.out.println("    耐力： 5");
    }

    @Override
    protected void initAddress() {
        System.out.println("出生地：王城征兵所");
    }

    @Override
    protected boolean chooseItem() {
        return true;
    }
}

// 子类 小偷
public class Thief extends BaseBoard {
    @Override
    protected void initProfession() {
        System.out.println("职业：小偷");
    }

    @Override
    protected void initAttr() {
        System.out.println("属性：");
        System.out.println("    生命： 5");
        System.out.println("    力量： 3");
        System.out.println("    魔力： 5");
        System.out.println("    耐力： 7");
    }

    @Override
    protected void initAddress() {
        System.out.println("出生地：初始之地");
    }
}

// 客户端
public class Main {
    public static void main(String[] args) {
        Thief elf = new Thief();
        elf.createPerson();
        System.out.println("====================================");
        Warrior warrior = new Warrior();
        warrior.createPerson();
        System.out.println("====================================");
        Mage mage = new Mage();
        mage.createPerson();
        System.out.println("====================================");
    }
}

// 控制台输出
 职业：小偷
 属性：
     生命： 5
     力量： 3
     魔力： 5
     耐力： 7
 出生地：初始之地
 等级：1
 ====================================
 职业：战士
 属性：
     生命： 7
     力量： 10
     魔力： 1
     耐力： 5
 出生地：王城征兵所
 等级：1
 初始道具：火焰壶
 ====================================
 职业：魔法师
 属性：
     生命： 3
     力量： 0
     魔力： 12
     耐力： 5
 出生地：雷古拉魔法学院
 等级：1
```

上面的代码中，`BaseBoard`类定义了模板方法`createPerson()`，将所有的步骤封装在内。三个子类重写所有抽象方法，实现了具体的属性初始化逻辑。其中`Warrior`类又单独重写了`chooseItem()`方法，使其返回true，从而允许角色选择初始道具。`BaseBoard`中的共通方法`initLevel()`确保所有角色的等级都为1。

适用场景：多个子类共享相同的操作逻辑、多格式报表生成、多格式数据处理等等