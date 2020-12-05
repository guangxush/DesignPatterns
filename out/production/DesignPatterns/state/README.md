### 状态模式

允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。

一个对象的状态依赖于它的变量的取值情况，对象在不同的运行环境中，可能具有不同的状态。在许多情况下，对象调用方法所产生的行为效果依赖于它当时的状态。 

状态模式的关键是将对象的状态封装成为独立的类，对象调用方法时，可以委托当前对象所具有的状态调用相应的方法，使得当前对象看起来好像修改了它的类。 


### 结构

- 环境（Context） 环境是一个类，该类含有抽象状态声明的变量，可以引用任何具体状态类的实例，用户对该环境类的实例在某个状态下的行为感兴趣
- 抽象状态（State） 抽象状态是一个接口或者抽象类，抽象状态中定义了与环境的一个特定状态相关的若干个方法
- 具体状态（Concrete State）具体状态是实现抽象状态的类

具体类图如图所示：

![](../../image/state.png)


### 代码

环境

```java
public class Thermometer {
    TemperatureState  state;
    public  void  showMessage(){
        System.out.println("***********");
        state.showTemperature();
        System.out.println("***********");
    }
    public void setState(TemperatureState  state){
        this.state=state;
    }
}
```

抽象状态

```java
public interface TemperatureState {
    void showTemperature();
}
```

具体状态

```java
public class HeightState implements TemperatureState {
    double n = 26;

    HeightState(int n) {
        if (n > 26) {
            this.n = n;
        }
    }

    @Override
    public void showTemperature() {
        System.out.println("现在温度是" + n + "属于高温度");
    }
}
```

模式的使用

```java
public class Application {
    public static void main(String args[]) {
        TemperatureState state = new LowState(-12);
        Thermometer thermometer = new Thermometer();
        thermometer.setState(state);
        thermometer.showMessage();
        state = new MiddleState(20);
        thermometer.setState(state);
        thermometer.showMessage();
        state = new HeightState(39);
        thermometer.setState(state);
        thermometer.showMessage();
    }
}
```

### 状态切换

环境实例在某种状态下执行一个方法之后，可以导致该实例的状态发生变化，程序可以通过使用状态模式将环境的一个实例从一个状态转移到另一个状态。

一个使用弹夹大小为3颗子弹的手枪通过更换弹夹重新获取子弹。使用弹夹大小为3颗子弹的手枪共有四种状态：3颗子弹，2颗子弹，1颗子弹，没有子弹。

手枪只有fire()方法进行射击，在没有子弹的状态调用LoadBullet()方法重新获得子弹，手枪调用fire()方法和LoadBullet()方法都会让手枪的状态发生变化。

代码见example

### 共享状态

环境的多个实例可以共享同一个状态，比如客运列车中存在着"静止状态"和"运动状态"，那么这一列客车这种所有的车厢都会共享这两种状态

在状态模式中，要使环境的多个实例共享一个或者多个状态，需要将这些状态声明为环境中的静态成员，此外，也要保证共享的状态没有自己的实例变量，否则是无法共享的

代码见example1


### 优点

- 使用一个类封装对象的一种状态，很容易增加新的状态。
- 在状态模式中，环境（context）中不必出现大量的条件判断语句。环境（context）实例所呈现的状态变得更加清晰、容易理解。
- 使用状态模式可以让用户程序很方便的切换环境（context）实例的状态。
- 使用状态模式不会让环境（context）的实例中出现内部状态不一致的情况。
- 当状态对象没有实例变量时，环境（context）的各个实例可以共巷一个状态对象。

### 适用场景

一个对象的行为依赖于它的状态，并且必须在运行时根据状态改变他的行为
需要编写大量的条件判断语句来决定一个操作的行为时，这些条件恰好又能表示对象的状态

### 案例分析

设计一个自动售卖咖啡机，分别有三种状态"有咖啡，无人投币"，"有咖啡，有人投币"，"无咖啡"三种状态

现在有两个方法：showMessage()和giveAnCupCaffee() 状态之间可以随意切换

代码见example2


### 案例分析

传统开关状态的判断方法如下：

```java
if (state.euqals("bye")) state="hello";
else if (state.euqals("hello")) state="hi";
else if (state.euqals("hi")) state="bye";
```

这就是 "开关切换状态",是将state的状态从"hello"切换到"hi",再切换到""bye";在切换到"hello",好象一个旋转开关,这种状态改变就可以使用State模式了.

如果单纯有上面一种将"hello"-->"hi"-->"bye"-->"hello"这一个方向切换,也不一定需要使用State模式,因为State模式会建立很多子类,复杂化,但是如果又发生另外一个行为:将上面的切换方向反过来切换,或者需要任意切换,就需要State了.

```java
public class Context{
    private Color state=null;
    
    public void push(){
       //如果当前red状态 就切换到blue
       if (state==Color.red){
           state=Color.blue;
       }
       //如果当前blue状态 就切换到green
       else if (state==Color.blue){
           state=Color.green;
       }
       //如果当前black状态 就切换到red
       else if (state==Color.black){
           state=Color.red;
       }
       //如果当前green状态 就切换到black
       else if (state==Color.green){
           state=Color.black;
       }
       Sample sample=new Sample(state);
       sample.operate();
    }
    public void pull(){
        //与push状态切换正好相反
        if (state==Color.green){
            state=Color.blue;
        }else if (state==Color.black){
            state=Color.green;
        }else if (state==Color.blue){
            state=Color.red;
        }else if (state==Color.red){
            state=Color.black;
        }
        Sample2 sample2=new Sample2(state);
        sample2.operate(); 
    }
}
```
将上述方法改成状态机模式example3





