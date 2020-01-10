### 访问者模式
表示一个作用于某对象结构中的各个元素的操作。它使你可以在不改变各个元素的类的前提下定义作用于这些元素的新操作。

当一个集合中有若干个对象时，习惯上将这些对象称作集合中的元素，访问者模式可以使得我们在不改变集合中各个元素的类的前提下定义作用于这些元素上的新操作。 

### 结构
- 抽象元素（Element） :抽象类定义了接收访问者的accept操作
- 具体元素（Concrete Element） ：Element的子类
- 对象结构（Object Structure） ：一个集合，用于存放Element对象，提供了遍历它自己的方法
- 抽象访问者（Visitor） ：一个接口，定义了操作对象（Concrete Element） 的方法
- 具体访问者（Concrete Visitor） 实现Visitor接口的类

![](../../image/visitor.png)

### 代码

公司考核若干大学生和研究生，决定是否录用，大学生和研究生都有自己的成绩，但是不能依据他们自己的成绩制定录用标准，录用标准必须由公司制定

抽象角色是Student
```java
public interface Student {
    void accept(Visitor v);
}
```

具体元素是Undergraduate和GraduateStudent

```java
public class Undergraduate implements Student {
    double math, english;    //成绩
    String name;

    Undergraduate(String name, double math, double english) {
        this.name = name;
        this.math = math;
        this.english = english;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
```


```java
public class GraduateStudent implements Student {
    double math, english, physics;    //成绩
    String name;

    GraduateStudent(String name, double math, double english, double physics) {
        this.name = name;
        this.math = math;
        this.english = english;
        this.physics = physics;
    }

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public double getPhysics() {
        return physics;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
```

抽象访问者

```java
public interface Visitor {
    void visit(Undergraduate stu);
    void visit(GraduateStudent stu);
}
```

实际访问者：公司
```java
public class Company implements Visitor {
    @Override
    public void visit(Undergraduate stu) {
        double math = stu.getMath();
        double english = stu.getEnglish();
        if (math > 80 && english > 90)
            System.out.println(stu.getName() + "被录用");
    }

    @Override
    public void visit(GraduateStudent stu) {
        double math = stu.getMath();
        double english = stu.getEnglish();
        double physics = stu.getPhysics();
        if (math > 80 && english > 90 && physics > 70)
            System.out.println(stu.getName() + "被录用");
    }
}
```

最终使用
```java
public class Application {
    public static void main(String args[]) {
        Visitor visitor = new Company();
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Undergraduate("张三", 67, 88));
        studentList.add(new Undergraduate("李四", 90, 98));
        studentList.add(new Undergraduate("王五", 85, 92));
        studentList.add(new GraduateStudent("小明", 88, 70, 87));
        studentList.add(new GraduateStudent("小红", 90, 95, 82));
        Iterator<Student> iter = studentList.iterator();
        while (iter.hasNext()) {
            Student stu = iter.next();
            stu.accept(visitor);
        }
    }
}
```

### 优缺点

- 可以在不改变一个集合中的元素的类的情况下，增加新的施加于该元素上的新操作。
- 可以将集合中各个元素的某些操作集中到访问者中，不仅便于集合的维护，也有利于集合中元素的复用。
- 每增加一个Element都需要Visitor角色给出访问该实例的visit()方法

### 适用场景

- 一个对象结构中，包含很多对象，相对集合中的对象增加一些新的操作
- 需要对集合中的对象给出很多不同且不相关的操作，而又不想修改对象的类

### 案例

有若干人员的体检表，每张体检表上记载着某人的体检数据，但是提交表本身不可以用一个方法来标明不同行业的体检标准，现在有军队和工厂的负责人来审阅体检表
请检测体检表中的数据是否符合军人或者工人的标准

代码见example

