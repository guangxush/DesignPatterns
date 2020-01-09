## 基本定义
定义一系列算法，把他们封装起来，并且他们可以互相替换，可以独立于使用它的客户端而变换。该模式的核心就是将经常需要变化的类抽离出来，将每一种可能的变化对应的交给抽象类或接口的子类去实现。

## 基本概念
策略：封装算法标识的接口是策略
具体策略：实现接口的策略是具体策略
上下文：依赖于策略接口的类
![策略模式](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/strategy1.png)

## 代码设计
设计一个计算成绩的接口
```java
public interface ComputableStrategy {
    double computer(double[] a);
}
```

代码采用了很多种计算成绩的方法，表示不同的策略
这里只列举一个策略一
```java
public class StrategyOne implements ComputableStrategy{
    @Override
    public double computer(double[] a) {
        double score = 0, sum = 0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        score = sum/a.length;
        return score;
    }
}
```

context根据传入的策略选择合适的计算方法
```java
public class GymnasticsContext {
    ComputableStrategy strategy;
    public void setStrategy(ComputableStrategy strategy){
        this.strategy = strategy;
    }
    public double getPersonScore(double[] a){
        if(strategy !=null){
            return strategy.computer(a);
        }else{
            return 0;
        }
    }
}
```
具体使用
```java
public class Application {
    public static void main(String[] args) {
        GymnasticsContext context = new GymnasticsContext();
        context.setStrategy(new StrategyOne());
        double[] a = {1,2,3,4,5,6,7,8};
        context.getPersonScore(a);
    }
}

```
## 优缺点分析
- 策略模式满足开闭原则
- 上下文和具体策略是松耦合的关系
- 一个算法可以有不同的遍体，不需要暴露出复杂的细节
- 少用继承，多用组合

## 完整源码
[策略模式代码](https://github.com/guangxush/DesignPatterns/tree/master/src/strategy)


## 什么情况下使用

1. 一个类定义类多种行为，这些行为在这个类的方法中以多个条件语句的形式出现，那么可以采用策略模式避免大量的if判断
2. 程序不希望暴露复杂的与算法相关的数据结构，可以采用策略模式封装算法
3. 需要使用同一种算法的不同变体


## 与工厂模式的区别

相似：
在结构上相似，都是对象的继承和多态，所以非常难区分。

不同：
1 用途不同：
抽象工厂是对对象的管理，它的作用就是创建不同的对象；
策略模式是对行为的管理，它的作用是让一个对象在不同情况下选择行为。

2 方式不同：
工厂模式是创建型的设计模式，它接受指令，创建出符合要求的实例。它主要解决的是资源的统一分发，将对象的创建完全独立出来，不同的对象对用同一个方法，结果不同。

策略模式是为了解决的是策略的切换与扩展，更简洁的说是定义策略族，分别封装起来，让他们之间可以相互替换，同一个对象调用同一个方法，结果不同。

## 案例分析

采用不同的加密解密方案进行加密处理

1. 策略的接口为EncryptStrategy,里面包含两个方法encryptFile加密文件和decryptFile解密文件
2. 具体有两个策略：StrategyOne和StrategyTwo