### 中介者模式/代理模式

用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显示地相互引用，从而使耦合松散，而且可以独立的改变他们之间的交互

### 结构

- 中介者Mediator：中介者是一个接口，用于定义同事对象之间通信的方法
- 具体中介者ConcreteMediator: 需要包含所有具体同事的引用
- 同事Colleague: 一个接口，规定了具体同事需要实现的方法
- 具体同事ConcreteColleague: 实现同事接口的类，只需要将具体的请求通知给包含他的中介者即可

类图如图所示

![mediator](../../image/mediator.png)

### 代码

定义了同事接口，以及交战双方需要实现的方法

```java
public interface Colleague {
    void giveMess(String[] mess);
    void receiverMess(String mess);
    void setName(String name);
    String getName();
}
```

具体中介者

```java
public class ConcreteMediator {
    ColleagueA colleagueA;
    ColleagueB colleagueB;
    ColleagueC colleagueC;

    public void registerColleagueA(ColleagueA colleagueA){
        this.colleagueA = colleagueA;
    }

    public void registerColleagueB(ColleagueB colleagueB){
        this.colleagueB = colleagueB;
    }

    public void registerColleagueC(ColleagueC colleagueC){
        this.colleagueC = colleagueC;
    }

    public void deliverMess(Colleague colleague, String[] mess){
        if(colleague == colleagueA){
            if(mess.length >= 2){
                colleagueB.receiverMess(colleague.getName()+mess[0]);
                colleagueC.receiverMess(colleague.getName()+mess[1]);
            }
        }else if(colleague == colleagueB){
            if(mess.length >= 2){
                colleagueA.receiverMess(colleague.getName()+mess[0]);
                colleagueC.receiverMess(colleague.getName()+mess[1]);
            }
        }else if(colleague == colleagueC){
            if(mess.length >= 2){
                colleagueA.receiverMess(colleague.getName()+mess[0]);
                colleagueB.receiverMess(colleague.getName()+mess[1]);
            }
        }
    }
}
```

具体同事

```java
public class ColleagueA implements Colleague{
    ConcreteMediator mediator;
    String name;

    public ColleagueA(ConcreteMediator mediator) {
        this.mediator = mediator;
        mediator.registerColleagueA(this);
    }

    @Override
    public void giveMess(String[] mess) {
        mediator.deliverMess(this, mess);
    }

    @Override
    public void receiverMess(String mess) {
        System.out.print(name+"收到的信息是：");
        System.out.println("\t"+mess);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
```

模式的使用
```java
public class Application {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ColleagueA colleagueA = new ColleagueA(mediator);
        ColleagueB colleagueB = new ColleagueB(mediator);
        ColleagueC colleagueC = new ColleagueC(mediator);
        colleagueA.setName("A");
        colleagueB.setName("B");
        colleagueC.setName("C");

        String[] messA = {"aaaa","bbbb"};
        colleagueA.giveMess(messA);
    }
}
```

### 优点

- 可以避免多个对象为了互相通信而互相引用，否则系统难以维护和复用
- 可以通过中介者将原本分布于多个对象之间的交互行为集中在一起，调用时只需要一个中介者即可
- 具体的中介者可以使同事完全解耦，修改任何一个具体的同事不会影响到其他同事
- 中介者隐藏了交互的细节，可以比较清楚的知道系统之间的架构
- 当一些对象想通信，又不能直接引用时，可以通过中介者模式

### 适用情景

- 许多对象以复杂的方式进行交互，导致依赖关系使得系统难以维护和理解
- 一个对象引用其他很多对象，导致难以复用该对象

### 案例

使用中介者模式处理组建之间的交互

- 程序中有一个文本区，当文本区有文本被选中是，负责复制和剪切的组建也将处于可用状态，当文本区未有文本被选中时，负责剪切和复制的组建处于非可用状态
- 当剪切板上无内容时，负责粘贴的组建处于非可用状态，当剪切板上有内容时，负责粘贴的组建处于可用状态


