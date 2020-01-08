### 生成器模式

将一个复杂的对象的构建与他的表示进行分离，使用同样的构建过程但可以创建不同的表示

### 结构

- 产品Product：具体生成器要构造的复杂对象
- 抽象生成器Builder：抽象生成器是一个接口，该接口除了为创建一个Product对象的各个组件定义若干个方法以外，还要定义返回Product的方法
- 具体生成器ConcreteBuilder：实现Builder接口的类
- 指挥者Director: 负责向用户提供具体生成器

![](../../image/builder.png)

### 代码

给出一个产品
```java
public class PanelProduct extends JPanel {
    JButton button;
    JLabel label;
    JTextField textField;
}
```

抽象生成器

```java
public interface Builder {
    void buildButton();

    void buildLabel();

    void buildTextField();

    JPanel getPanel();
}
```

两个具体的生成器

```java
public class ConcreteBuilderOne implements Builder {

    //需要创建的容器
    private PanelProduct panel;

    ConcreteBuilderOne() {
        panel = new PanelProduct();
    }

    @Override
    public void buildButton() {
        panel.button = new JButton("按钮");
    }

    @Override
    public void buildLabel() {
        panel.label = new JLabel("标签");
    }

    @Override
    public void buildTextField() {
        panel.textField = new JTextField("文本框");
    }

    @Override
    public JPanel getPanel() {
        //与ConcreteBuilderTwo添加组件的顺序的不同
        panel.add(panel.button);
        panel.add(panel.label);
        panel.add(panel.textField);
        return panel;
    }
}
```

指挥者

```java
public class Director {
    private Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }

    public JPanel constructProduct() {
        builder.buildButton();
        builder.buildLabel();
        builder.buildTextField();
        JPanel product = builder.getPanel();
        return product;
    }
}
```

模式的使用

```java
public class Application {
    public static void main(String args[]) {
        Builder builder = new ConcreteBuilderOne();
        Director director = new Director(builder);
        JPanel panel = director.constructProduct();
        JFrame frameOne = new JFrame();
        frameOne.add(panel);
        frameOne.setBounds(12, 12, 200, 120);
        frameOne.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameOne.setVisible(true);
        builder = new ConcreteBuilderTwo();
        director = new Director(builder);
        panel = director.constructProduct();
        JFrame frameTwo = new JFrame();
        frameTwo.add(panel);
        frameTwo.setBounds(212, 12, 200, 120);
        frameTwo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTwo.setVisible(true);
    }
}
```


### 优点

- 生成器模式将构造过程封装在具体的容器里，用户使用不同的生成器就可以得到该对象
- 生成器模式将对象的构造过程从创建该对象的类中分离出来，使用户无需了解具体的组建和细节
- 可以精致的控制对象的构造过程，也可以将构造过程分成多个步骤
- 当增加具体的生成器时，不必修改指挥者的代码，满足开闭原则

### 适用场景

- 为用户提供一个内部结构复杂的对象时，编写构造函数已经无法满足要求，可以通过这种方式创建
- 当系统要求构造过程必须独立与创建对象的类时

### 案例

设计中式日历牌和美式日历牌