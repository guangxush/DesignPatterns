## 装饰模式
装饰模式是动态的扩展一个类的功能，而不需要改变原始类的代码。

## 结构
主要包含四个角色：
- 抽象组建：抽象组建是一个抽象类，定义了被装饰者需要装饰的方法
- 具体组建：是抽象组建的一个子类，具体组建的实例成为“被装饰者”
- 装饰Decorator: 装饰者可以是一个抽象类也可以是一个非抽象类，是抽象组建的一个子类，但是还包含抽象组建的一个变量以保存“被装饰者”的引用。
- 具体装饰：是一个非抽象的子类，具体装饰的实例被称为“装饰者”

## 类图
![装饰者模式类图](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/decorator1.png)

## 代码

![代码结构](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/decorator2.png)
Bird
```java
public abstract class Bird {
    public abstract int fly();
}
```
Sparrow
```java
public class Sparrow extends Bird{
    public final int DISTANCE = 50;

    @Override
    public int fly(){
        return DISTANCE;
    }
}
```
Decorator
```java
public abstract class Decorator extends Bird {
    protected Bird bird;
    public Decorator(){

    }

    public Decorator(Bird bird){
        this.bird = bird;
    }
}
```
SparrowDecorator
```java
public class SparrowDecorator extends Decorator{

    public final int DISTANCE = 50;

    public SparrowDecorator(Bird bird){
        super(bird);
    }

    @Override
    public int fly() {
        int distance = 0;
        // 委托被装饰着bird调用fly(),然后在调用eleFly()
        distance = bird.fly()+eleFly();
        return distance;
    }

    /**
     * 装饰者添加新的方法
     * @return
     */
    private int eleFly(){
        // 飞行50
        return DISTANCE;
    }
}
```
装饰模式的调用：
```java
public class Application {
    public void needBird(Bird bird) {
        int flyDistance = bird.fly();
        System.out.println("可以飞行" + flyDistance + "米");
    }

    public static void main(String[] args) {
        Application client = new Application();
        Bird sparrow = new Sparrow();
        // 飞行150
        Bird sparrowDecorator1 = new SparrowDecorator(sparrow);
        // 飞行150
        Bird sparrowDecorator2 = new SparrowDecorator(sparrowDecorator1);
        client.needBird(sparrowDecorator1);
        client.needBird(sparrowDecorator2);
    }
}
```
![运行结果](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/decorator3.png)

## 完整源码
[源码参考](https://github.com/guangxush/DesignPatterns)


## 优点

装饰模式相对于继承来说，满足"少用继承，多用组合"的基本原则，装饰者和被装饰者是松耦合的，满足"开闭原则"


如果程序希望动态的增强某个类的功能而又不影响到其他类，可以用装饰模式，有利于系统的扩展和维护

### 案例

读取单词表

1. 当前系统已经有了一个抽象类ReadWord,该类有一个抽象方法readWord(),另外系统还有一个子类ReadEnglishWord，该类的readWord()方法可以读取由英文单词组成的文本文件word.txt，
2. 现在需要改进系统，能够使用ReadWord调用readWord()方法读取其中的单词，并且也能够得到单词的汉语解释，甚至可以得到英文例句，请满足不同用户的需求。

原来的类图

![原来的图](../../image/decorator01.png)

使用装饰模式扩展之后的类图

![装饰后的图](../../image/decorator02.png)


答案见example目录

