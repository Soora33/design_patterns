# 原型模式（Prototype）

原型模式的核心是使用现有对象作为模板，通过克隆的方式创建新的对象。一般当创建对象的开销比较大或者对象结构比较复杂时，会使用原型模式，通过clone方法来实现对象的复制，同样我们也可以自己选择实现方式是浅拷贝还是深拷贝，下面是原型模式的角色：

1. **原型接口**：定义克隆方法，所有具体原型类都要实现这个接口
2. **具体原型类**：实现原型接口，具体定义了如何复制自身

这里再提一嘴深拷贝和浅拷贝：

- 深拷贝：复制对象以及引用类型的数据，克隆出的对象与原对象完全独立，互不影响

- 浅拷贝：只复制对象的基本数据类型，引用数据类型的**引用**，克隆出的对象和原对象共享同一个引用地址

如果我们使用浅拷贝，修改任一对象里的对象或集合，另一个也会发生改变，因为这个对象都指向同一个地址。

PS：String数据类型也是引用类型的数据，但因为底层是不可变的数组，所以我们修改其中一个对象另一个并不会发生改变。所以对于String类型，我们可以放心使用，因为任何**修改**本质上都是创建了新的对象

下面我们来看原型模式的示例代码：

```java
// 原型接口
public interface Prototype {
    Prototype clone();
}

// 原型类
public class Album implements Prototype {
    public String name;
    public String sings;
    public ArrayList<String> list = new ArrayList<>();

    public Album() {
    }

    public List getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", sings='" + sings + '\'' +
                ", list=" + list +
                '}';
    }

    public Album(String name, String sings, ArrayList<String> list) {
        this.name = name;
        this.sings = sings;
        this.list = list;
    }

  	// 克隆实现（浅拷贝）
    @Override
    public Prototype clone() {
        return new Album(this.name, this.sings, this.list);
    }
}

```

原型模式的使用很简单，只需要一个原型接口即可，内部包含一个`clone`方法，具体实现深拷贝还是浅拷贝则由原型类决定。这里我克隆Album类，实现原型接口后，在`clone`方法内创建一个新对象并填充数据返回，这样的方式是浅拷贝。我们来看一下浅拷贝的结果：

```java
// 客户端示例
public class Main {
    public static void main(String[] args) {
        Album album = new Album("透明な君を掬う", "nayuta", new ArrayList(){{
            add("透明な君");
            add("誰そ彼");
            add("追慕");
            add("僕が見つけた綻び");
            add("灰燼");
            add("彼は誰");
            add("君を掬う");
        }});
        System.out.println("原对象：：" + album);
        Album clone = (Album) album.clone();
        System.out.println("克隆对象：" + clone);
        System.out.println("修改克隆对象，删掉最后一首歌曲……");
        clone.getList().removeLast();
        System.out.println("原对象：" + album);
        System.out.println("克隆对象：" + clone);
    }
}

// 控制台输出
 原对象：：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰, 君を掬う]}
 克隆对象：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰, 君を掬う]}
 修改克隆对象，删掉最后一首歌曲……
 原对象：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰]}
 克隆对象：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰]}
```

我们删除克隆对象集合的一个数据后，原对象也发生了相应的变更，因为他们的使用的**list**实际上是一个。如果要实现深拷贝，需要将原型类中的`clone`方法需要改成这样：

```java
// 这里我通过序列化和反序列化的方式实现了深拷贝，但注意对象必须实现 Serializable 接口
// 克隆实现（深拷贝）
public Prototype clone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Prototype) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
```

改为深拷贝后，只有克隆对象的集合数据发生了改变，原对象的集合并没有收到影响，这就是深拷贝和浅拷贝的区别

```tex
 原对象：：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰, 君を掬う]}
 克隆对象：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰, 君を掬う]}
 修改克隆对象，删掉最后一首歌曲……
 原对象：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰, 君を掬う]}
 克隆对象：Album{name='透明な君を掬う', sings='nayuta', list=[透明な君, 誰そ彼, 追慕, 僕が見つけた綻び, 灰燼, 彼は誰]}
```

适用场景：需要大量创建的对象、缓存对象的创建、复杂商品/报表模板的生成等等