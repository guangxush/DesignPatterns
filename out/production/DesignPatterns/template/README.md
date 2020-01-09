### 模板方法模式

定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

模板方法是关于怎样将若干个方法集成到一个方法中，以便形成一个解决问题的算法骨架。模板方法模式的关键是在一个抽象类中定义一个算法的骨架，即将若干个方法集成到一个方法中，并称该方法为一个模板方法，或简称为模板。 

### 结构

- 抽象模板（Abstract Template）抽象模板是一个抽象类，定义了若干个抽象的方法，以表示一个算法的各个步骤，抽象方法成为原语操作。 
- 具体模板（Concrete Template）具体模板是抽象模板的子类，实现抽象模板中的原语操作

具体类图如下：

![](../../image/template.png)

### 代码

抽象模板

```java
public abstract class AbstractTemplate {
    File[] allFiles;
    File dir;

    AbstractTemplate(File dir) {
        this.dir = dir;
    }

    public final void showFileName() {
        allFiles = dir.listFiles();
        sort();
        printFiles();
    }

    public abstract void sort();

    public abstract void printFiles();
}
```

具体模板1
```java
public class ConcreteTemplate1 extends AbstractTemplate {
    ConcreteTemplate1(File dir) {
        super(dir);
    }

    @Override
    public void sort() {
        for (int i = 0; i < allFiles.length; i++)
            for (int j = i + 1; j < allFiles.length; j++)
                if (allFiles[j].lastModified() < allFiles[i].lastModified()) {
                    File file = allFiles[j];
                    allFiles[j] = allFiles[i];
                    allFiles[i] = file;
                }
    }

    @Override
    public void printFiles() {
        for (int i = 0; i < allFiles.length; i++) {
            long time = allFiles[i].lastModified();
            Date date = new Date(time);
            SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = matter.format(date);
            String name = allFiles[i].getName();
            int k = i + 1;
            System.out.println(k + " " + name + "(" + str + ")");
        }
    }
}
```

具体模板2
```java
public class ConcreteTemplate2 extends AbstractTemplate {
    ConcreteTemplate2(File dir) {
        super(dir);
    }

    @Override
    public void sort() {
        for (int i = 0; i < allFiles.length; i++)
            for (int j = i + 1; j < allFiles.length; j++)
                if (allFiles[j].length() < allFiles[i].length()) {
                    File file = allFiles[j];
                    allFiles[j] = allFiles[i];
                    allFiles[i] = file;
                }
    }

    @Override
    public void printFiles() {
        for (int i = 0; i < allFiles.length; i++) {
            long fileSize = allFiles[i].length();
            String name = allFiles[i].getName();
            int k = i + 1;
            System.out.println(k + " " + name + "(" + fileSize + " 字节)");
        }
    }
}
```

使用
```java
public class Application {
    public static void main(String args[]) {
        File dir = new File("../");
        AbstractTemplate template = new ConcreteTemplate1(dir);
        System.out.println(dir.getPath() + "目录下的文件：");
        template.showFileName();
        template = new ConcreteTemplate2(dir);
        System.out.println(dir.getPath() + "目录下的文件：");
        template.showFileName();
    }
}
```

### 钩子方法

在模板方法中，抽象模板负责定义模版的方法，以此表示算法的步骤，具体模板必须重写抽象方法中的原语，但是对于抽象方法中的具体方法，具体模板可以选择直接继承或者重写这个方法

钩子方法是抽象模板中定义的具体方法，给出了空的实现或者默认的实现，并允许子类重写这个方法。

抽象模板

```java
public abstract class AbstractTemplate {
    File[] allFiles;
    File dir;

    AbstractTemplate(File dir) {
        this.dir = dir;
    }

    public final void showFileName() {
        allFiles = dir.listFiles();
        sort();
        printFiles();
    }

    public abstract void sort();

    public abstract void printFiles();
}
```

具体模板1
```java
public class ConcreteTemplate1 extends AbstractTemplate {
    ConcreteTemplate1(File dir) {
        super(dir);
    }

    @Override
    public void sort() {
        for (int i = 0; i < allFiles.length; i++)
            for (int j = i + 1; j < allFiles.length; j++)
                if (allFiles[j].lastModified() < allFiles[i].lastModified()) {
                    File file = allFiles[j];
                    allFiles[j] = allFiles[i];
                    allFiles[i] = file;
                }
    }

    @Override
    public void printFiles() {
        for (int i = 0; i < allFiles.length; i++) {
            long time = allFiles[i].lastModified();
            Date date = new Date(time);
            SimpleDateFormat matter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = matter.format(date);
            String name = allFiles[i].getName();
            int k = i + 1;
            System.out.println(k + " " + name + "(" + str + ")");
        }
    }
}
```

具体模板2
```java
public class ConcreteTemplate2 extends AbstractTemplate {
    ConcreteTemplate2(File dir) {
        super(dir);
    }

    @Override
    public void sort() {
        for (int i = 0; i < allFiles.length; i++)
            for (int j = i + 1; j < allFiles.length; j++)
                if (allFiles[j].length() < allFiles[i].length()) {
                    File file = allFiles[j];
                    allFiles[j] = allFiles[i];
                    allFiles[i] = file;
                }
    }

    @Override
    public void printFiles() {
        for (int i = 0; i < allFiles.length; i++) {
            long fileSize = allFiles[i].length();
            String name = allFiles[i].getName();
            int k = i + 1;
            System.out.println(k + " " + name + "(" + fileSize + " 字节)");
        }
    }
}
```

使用
```java
public class Application {
    public static void main(String args[]) {
        File dir = new File("../");
        AbstractTemplate template = new ConcreteTemplate1(dir);
        System.out.println(dir.getPath() + "目录下的文件：");
        template.showFileName();
        template = new ConcreteTemplate2(dir);
        System.out.println(dir.getPath() + "目录下的文件：");
        template.showFileName();
    }
}
```


### 优点
- 可以通过在抽象模板定义模板方法给出成熟的算法步骤，同时又不限制步骤的细节，具体模板实现算法细节不会改变整个算法的骨架。
- 在抽象模板模式中，可以通过钩子方法对某些步骤进行挂钩，具体模板通过钩子可以选择算法骨架中的某些步骤。


### 适用场景
- 设计者需要给出一个固定的算法步骤，将这些步骤的具体实现留给子类实现
- 需要对代码进行重构，将子类的公共行为进行提取，避免代码重复

### 案例分析


