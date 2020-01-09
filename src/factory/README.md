## 1. 工厂模式分类
工厂模式主要负责将大量有共同接口的类实例化，可以动态的决定创建哪一个类，而不事先知道要实例化具体哪一个类。
- 简单工厂模式：静态工厂模式
- 工厂模式：多态工厂模式或者虚拟构造工厂模式
- 抽象工厂模式：又称为工具箱模式
## 2. 简单工厂模式
简单工厂模式是类的创建模式，又称为静态工厂方法，是有一个工厂的对象决定创建哪一类具体的产品。
![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory1.png)

这里有一个水果类，水果类下面有不同的子类实现
Fruit:
```java
public interface Fruit {
    /**
     * 生长
     */
    void grow();

    /**
     * 收获
     */
    void harvest();

    /**
     * 种植
     */
    void plant();
}
```
Apple(其他以此类推，不再一一列出)
```java
public class Apple implements Fruit{
    /**
     * 树龄
     */
    private int treeAge;

    @Override
    public void grow() {
        log("Apple is growing.");
    }

    @Override
    public void harvest() {
        log("Apple has been harvested.");
    }

    @Override
    public void plant() {
        log("Apple has been planted.");
    }

    public static void log(String msg)
    {
        System.out.println(msg);
    }

    public int getTreeAge(){
        return treeAge;
    }

    public void setTreeAge(int treeAge){
        this.treeAge = treeAge;
    }
}
```
最后创建一个园丁类，通过传入不同的水果属性，判断水果的类型进行创建，这是典型的静态工厂模式。
```java
public class FruitGardener {
    /**
     * 静态工厂方法
     *
     * @param args
     */
    public static void main(String[] args) {
        try{
            Fruit fruit = FruitGardener.factory("apple");
            fruit.harvest();
            fruit = FruitGardener.factory("grape");
            fruit.harvest();
            fruit = FruitGardener.factory("strawberry");
            fruit.harvest();
        }catch (BadFruitException e){
            e.printStackTrace();
        }
    }


    public static Fruit factory(String fruit) throws BadFruitException {
        switch (fruit) {
            case "apple":
                return new Apple();
            case "strawberry":
                return new Strawberry();
            case "grape":
                return new Grape();
            default:
                throw new BadFruitException("Bad fruit request");
        }
    }

}
```
总结一下，简单工厂模式的结构为：
![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory2.png)

## 3.  工厂模式
工厂模式又成为动态工厂模式，由于静态工厂模式的缺点是，有新的类加入时需要修改工厂类代码，不符合开闭原则，因此引入类动态工厂模式，使用多态的方式去创建，具体创建类的过程交给子类去做，工厂和产品之间是一种平级的等级结构。
![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory3.png)
工厂模式存在四个角色：抽象产品、具体产品、构造者、具体构造者
这里采用一个简单的例子去说明
抽象产品类：PenCore 钢笔：颜色+书写
```java
public abstract class PenCore {

    public String color;

    public abstract void writeWord(String s);

}
```
具体产品类：黑色钢笔：设置颜色+书写文字
```java
public class BlackPenCore extends PenCore{

    public BlackPenCore(){
        color = "black";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("write with "+ color+ ": "+s);
    }
}
```
构造者：BallPen: 返回一个钢笔对象
```java
public abstract class BallPen {
    BallPen(){
        System.out.println("create the pen with the "+ getPenCore().color+".");
    }

    public abstract PenCore getPenCore();
}

```
具体构造者：BlackBallPen：返回具体的钢笔对象
```java
public class BlackBallPen extends BallPen{

    @Override
    public PenCore getPenCore(){
        return new BlackPenCore();
    }
}
```
模式的具体使用
```java
public class Application {
    public static void main(String[] args) {
        PenCore penCore;
        BallPen ballPen = new BlueBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("你好");

        ballPen = new RedBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("Hello");

        ballPen = new BlackBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("ni hao!");
    }
}
```
运行结果：
```text
create the pen with the blue.
write with blue: 你好
create the pen with the red.
write with red: Hello
create the pen with the black.
write with black: ni hao!
```
其实Java的集合框架也有采用这种设计模式:
![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory4.png)


综上所述，工厂模式的结构为：
![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory5.png)

## 4. 抽象工厂模式

抽象工厂模式是工厂模式中最具一般性的一种形态，提供一个创建一系列或相互依赖对象的接口，而无须制定他们具体的类。
它与工厂模式的最大区别是：工厂模式面对一个产品等级的结构，而抽象工厂模式面对多个产品等级结构。
![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory6.png)
举个例子，两个抽象产品一个裤子一个上衣：
裤子抽象产品：
```java
public interface Trousers {
    int getWaistSize();
    int getHeight();
    String getName();
}
```
上衣抽象产品
```java
public interface UpperClothes {
    int getChestSize();
    int getHeight();
    String getName();
}
```
裤子分为西裤和牛仔裤，这里只显示西裤：
```java
public class WesternTrousers implements Trousers{

    private int waistSize;

    private int height;

    private String name;

    public WesternTrousers(int waistSize, int height, String name) {
        this.waistSize = waistSize;
        this.height = height;
        this.name = name;
    }

    @Override
    public int getWaistSize() {
        return waistSize;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getName() {
        return name;
    }
}

```
上衣分为牛仔上衣和西装，这里只写西装
 ```java
public class WesternUpperClothes implements UpperClothes {

    private int chestSize;

    private int height;

    private String name;

    public WesternUpperClothes(int chestSize, int height, String name) {
        this.chestSize = chestSize;
        this.height = height;
        this.name = name;
    }

    @Override
    public int getChestSize() {
        return chestSize;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getName() {
        return name;
    }
}
```
此时创建抽象工厂，具有创建上衣和裤子的方法
```java
public interface ClothesFactory {
    UpperClothes createUpperClothes(int chestSize, int height);
    Trousers createTrousers(int waitSize, int height);
}
```
具体工厂包括两个，北京的西装工厂和上海的牛仔工厂，这里列举北京的西装工厂
```java
public class BeijingClothesFactory implements ClothesFactory{
    @Override
    public UpperClothes createUpperClothes(int chestSize, int height) {
        return new WesternUpperClothes(chestSize, height, "北京牌西服上衣");
    }

    @Override
    public Trousers createTrousers(int waitSize, int height) {
        return new WesternTrousers(waitSize, height, "北京牌西服裤子");
    }
}
```
最后设置服装店，输入人的信息，可以创建具体的服装
```java
public class Shop {
    UpperClothes clothes;
    Trousers trousers;
    public void giveSuit(ClothesFactory factory, int chestSize, int waistSize, int height){
        clothes = factory.createUpperClothes(chestSize, height);
        trousers = factory.createTrousers(waistSize, height);
        showMess();
    }

    private void showMess(){
        System.out.println("<套装信息>");
        System.out.println(clothes.getName()+" ");
        System.out.println("胸围："+ clothes.getChestSize());
        System.out.println("身高："+ clothes.getHeight());

        System.out.println(trousers.getName()+" ");
        System.out.println("腰围："+ trousers.getWaistSize());
        System.out.println("身高："+ trousers.getHeight());
    }
}

```
最后，服装店可以对衣服进行定制
```java
public class Application {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ClothesFactory factory = new BeijingClothesFactory();
        shop.giveSuit(factory, 110, 82, 170);
        factory = new ShanghaiClothesFactory();
        shop.giveSuit(factory, 120, 88, 180);
    }
}
```
打印结果如下：
```text
<套装信息>
北京牌西服上衣 
胸围：110
身高：170
北京牌西服裤子 
腰围：82
身高：170
```
总结抽象工厂的模式为：

![](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/factory7.png)
因此抽象工厂模式适用于以下情况：
1. 一个系统不应当依赖与产品类实力如何被创建、组合和表达的细节；
2. 这个系统中有多于一个的产品族，而系统只消费其中某一族的产品；
3. 同属于一个产品族的产品是一起使用的；
4. 系统提供一个产品类的库，所有产品以同样的接口出现，从而实现客户端不依赖于实现。

## 5. 源码参考
由于篇幅原因，只显示了一个子类，完整的系统调用请参考[链接](https://github.com/guangxush/DesignPatterns/tree/master/src)。


## 抽象工厂模式案例

用户在银行存款后，用户将得到银行给予的存款凭证，该凭证是加盖了业务公章的明细，但是不同银行的名称不同，形状也不同，使用抽象工厂模式为用户提供存款凭证
