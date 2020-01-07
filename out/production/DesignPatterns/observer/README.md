## shop和customer采用拉模式

## student和jobcenter采用推模式

## 二者没有必然联系，请分开独立去看代码

## 基本概念
官方解释：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖的对象能够得到通知并自动更新。

观察者模式是关于一个对象想知道另一个对象中数据变化情况的一种成熟的模式。观察者模式中存在“主题”和若干个“观察者”，把“主题”中变化的东西抽离出来，当发生变化时，所有的“观察者”能够得到通知。

## 应用场景
很多消息中间件是采用这种观察者模式，Java并发编程中异步回调的方式也类似于观察者模式。

## 角色分析
1. 主题：主题是一个接口，该接口规定了具体主题需要实现的方法；
2. 观察者：观察者是一个接口，该接口规定了具体观察者用来更新数据的方法；
3. 具体主题：具体主题是实现主题接口的一个实例；
4. 具体观察者：是实现观察者接口的一个实例；
观察者模式的UML类图：
![观察者模式](https://github.com/guangxush/iTechHeart/blob/master/image/DesignPatterns/observer1.png)

## 代码实现
以下是一个简单的求职者订阅工作中心的观察者模式，观察者通过notify给订阅了信息的求职者发送信息。
Subject
```
public interface Subject {

    void addObserve(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObserver();
}
```

SeekJobCenter
  ```
public class SeekJobCenter implements Subject {

    private String mess;
    private boolean changed;
    private ArrayList<Observer> personList;

    public SeekJobCenter(){
        this.personList = new ArrayList<Observer>();
        this.mess = "";
        this.changed = false;
    }


    @Override
    public void addObserve(Observer observer) {
        if(!personList.contains(observer)){
            personList.add(observer);
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
        if(!personList.contains(observer)){
            personList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        if(changed){
            for(int i=0;i<personList.size();i++){
                Observer observer = personList.get(i);
                observer.hearTelephone(mess);
            }
        }
        changed = false;
    }

    public void giveMessage(String str){
        if(str.equals(mess)){
            changed = false;
        }else{
            mess = str;
            changed = true;
        }
    }
}
```
Observe
```
public interface Observer {
    public void hearTelephone(String heardMess);
}
```
UniversityStudent
```
public class UniversityStudent implements Observer {

    private Subject subject;
    private File myFile;

    public UniversityStudent(Subject subject, String fileName){
        this.subject = subject;
        subject.addObserve(this);
        this.myFile = new File(fileName);
    }

    @Override
    public void hearTelephone(String heardMess) {
        try{
            RandomAccessFile out = new RandomAccessFile(myFile, "rw");
            out.seek(out.length());
            byte[] b = heardMess.getBytes();
            out.write(b);
            System.out.println("张三向文件中"+myFile.getName()+"写入如下内容:");
            System.out.println(heardMess);
        }catch (IOException exp){
            System.out.println(exp.toString());
        }
    }
}
```
## 观察者模式的推拉消息
1. 推消息模式
主题在发生变化的时候将全部数据推送给具体的观察者，观察者根据消息作出相应的选择。上述方法就是典型的推数据方法。

2. 拉消息模式
观察者根据主题提供的获取信息的接口，观察者在得到主题变化的通知之后，自己去拉数据过来,订阅自己需要的内容，参考代码给出了一种拉数据的方法，可以自行查看。

## 模式优缺点分析
- 具体主题和观察者是松耦合的关系，主题仅仅通过接口依赖于观察者的接口，而不用关心里面的具体的实现类，反之亦然
- 观察者模式满足开闭原则，如果增加新的实现观察者的接口，不用修改具体的主题。

## 完整代码
[观察者模式](https://github.com/guangxush/DesignPatterns/tree/master/src/observer)

### 案例1

抗洪指挥部希望按时得到天文站测量到的关于水流的信息，比如流量、流速等

按照观察者模式，抗洪指挥部是一个具体的观察者，天文站是其依赖的一个具体主题

### 案例2

统计文本中的单词和数字

1. 设计一个窗口，窗口有三个文本区
2. 三个文本区中其中一个可以供用户编辑，其他两个不可编辑
3. 当用户在可编辑的文本区进行编辑操作时，一个显示文本中出现的单词，一个显示文本中所包含的数字

提示：

使用Observable作为主题，使用Observer作为接口，具体主题是InputTextSubject是Observable类的子类，负责具体创建主题

