## 基本定义
定义一系列算法，把他们封装起来，并且他们可以互相替换，可以独立于使用它的客户端而变换。该模式的核心就是将经常需要变化的类抽离出来，将每一种可能的变化对应的交给抽象类或接口的子类去实现。

## 基本概念
策略：封装算法标识的接口是策略
具体策略：实现接口的策略是具体策略
上下文：依赖于策略接口的类
![策略模式](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/strategy1.png)

## 代码设计
设计一个计算成绩的接口
```
public interface ComputableStrategy {
    double computer(double[] a);
}
```

代码采用了很多种计算成绩的方法，表示不同的策略
这里只列举一个策略一
```
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
```
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
```
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
