# 组合（Composite）

组合模式通常将对象组合成树形结构，对于需要用树形结构表达的数据非常有用，例如公司组织架构、文件夹结构等，在组合模式中，我们将树的`叶子节点`和`组合节点（非叶子节点）`看作同一种数据类型，因此需要一个接口来将他们统一成一个数据类型。

组合模式包含三个角色，分别是**基础组件**、**组合节点**和**叶子节点**：

1. 基础组件：是一个接口，组合节点和叶子节点要实现这个接口，定义了共同行为
2. 组合节点：实现基础组件接口，是一个**容器**类型的角色，包含叶子节点或其他组合节点，是组合模式的核心
3. 叶子节点：实现基础组件接口，没有子节点，是组合模式内的最小单元

下面以展示文件结构为例，具体代码如下：

```java
// 文件接口（基础组件）
public interface FileComponent {
    void show();
}

// 文件夹（组合节点）
public class Folder implements FileComponent {

    private String name;
    private List<FileComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileComponent component) {
        components.add(component);
    }

    public void removeComponent(FileComponent component) {
        components.remove(component);
    }

    @Override
    public void show() {
        System.out.println("【组合节点】文件名:" + name);
        // 调用子节点的show方法
        components.forEach(data -> data.show());
    }
}

// 文件（叶子节点）
public class File implements FileComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("\t【叶子节点】文件名：" + name);
    }
}

// 客户端代码
public class Main {
    public static void main(String[] args) {
        // 创建文件
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        File file3 = new File("File3.txt");

        // 创建文件夹
        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");
        Folder rootFolder = new Folder("Root");

        // 组合文件和文件夹
        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder2.addComponent(file3);
        rootFolder.addComponent(folder1);
        rootFolder.addComponent(folder2);

        // 打印结构
        rootFolder.show();
    }
}

// 控制台输出
【组合节点】文件名:Root
【组合节点】文件名:Folder1
	【叶子节点】文件名：File1.txt
	【叶子节点】文件名：File2.txt
【组合节点】文件名:Folder2
	【叶子节点】文件名：File3.txt
```

我们主要关注组合节点类和叶子节点类，`组合节点`类内部有个集合，通过这个集合来`保存`其子节点，同时提供`add`和`remove`方法来对集合内的子节点进行新增和删除操作。在组合节点的`show`方法中，除了打印当前节点名称外，还会递归调用每个子节点的 `show` 方法。对于`叶子节点`类来说，因为不包含其他子节点，所以 `show`方法只需要打印出当前节点的名称即可。在客户端代码中，我们创建了3个文件（叶子节点），3个文件夹（组合节点），并将其组合起来，最终放入到Root文件夹内，打印root文件夹的结构。

适用场景：文件系统、公司组织架构、菜单子系统等