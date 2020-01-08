### 外观模式

为系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得子系统更加容易使用

### 结构

- 子系统：子系统是由若干个类组成的集合，这些类的实例协同合作为用户提供所需要的功能，子系统中的任何类都不包含外观类的实例引用
- 外观：外观是一个类，该类包含子系统中全部或者部分类的实例引用，当用户需要和子系统的实例打交道的时候，可以代替得和子系统的外观实例打交道

详细类图如图所示

![外观模式](../../image/facade.png)

### 优缺点

- 外观模式使客户和子系统之间的类无耦合，并使得子系统使用起来更加方便。
- 外观只是提供一个更加简洁的界面，并不影响用户使用子系统
- 子系统的任何类对其方法的内容进行修改，不影响外观类的代码

### 代码

计算广告字数
```java
public class CheckWord {
    public final int basicAmount = 85;
    String advertisement;
    int amount;

    public CheckWord(String advertisement) {
        this.advertisement = advertisement;
    }

    public void setChargeAmount(){
        amount = advertisement.length() + basicAmount;
    }

    public int getAmount(){
        return amount;
    }
}

```


计算广告费用

```java
public class Charge {
    public final int basicCharge = 12;
    CheckWord checkWord;

    public Charge(CheckWord checkWord) {
        this.checkWord = checkWord;
    }

    public void giveCharge(){
        int charge = checkWord.getAmount()*basicCharge;
        System.out.println("广告费用："+charge+"元");
    }
}
```

广告排版
```java
public class TypeSeting {
    String advertisement;

    public TypeSeting(String advertisement) {
        this.advertisement = advertisement;
    }

    public void typeSeting(){
        System.out.println("广告排版格式");
        System.out.println("**********");
        System.out.println(advertisement);
        System.out.println("**********");
    }
}
```

外观
```java
public class ClientServerFacade {
    private CheckWord checkWord;
    private Charge charge;
    private TypeSeting typeSeting;
    private String advertisement;

    public ClientServerFacade(String advertisement) {
        this.advertisement = advertisement;
        checkWord = new CheckWord(advertisement);
        charge = new Charge(checkWord);
        typeSeting = new TypeSeting(advertisement);
    }

    public void doAdversitisement(){
        checkWord.setChargeAmount();
        charge.giveCharge();
        typeSeting.typeSeting();
    }
}
```

使用
```java
public class Application {
    public static void main(String[] args) {
        ClientServerFacade facade;
        String advertisement = "电脑1233元，请联系12334";
        facade = new ClientServerFacade(advertisement);
        facade.doAdversitisement();
    }
}
```
### 适用场景

- 对复杂的子系统，需要为用户提供一个简单的交互操作
- 不希望客户端的代码和子系统之间存在耦合，提高独立性和可移植性
- 当整个系统需要构建一个层次结构的子系统时，不希望与这些子系统相互直接打交道
- 监听子系统的消息

### 案例分析

设计一个子系统，该子系统里面有三个类

ReadFile：读取文本文件
AnalyzeInformation: 从一个文本中删除不必要的内容
SaveFile：保存文件
设计一个外观，简化用户和上述子系统之间的交互


