### 享元模式

运用共享技术有效地支持大量细粒度的对象。

一个类中的成员变量表明该类所创建的对象所具有的属性，在某些程序设计中我们可能用一个类创建若干个对象，但是我们发现这些对象的一个共同特点是它们有一部分属性的取值必须是完全相同的。


### 结构

- 享元接口（Flyweight）：定义了享元对外公开数据的方法和接收外部数据的方法
- 具体享元（Concrete Flyweight）： 保证使用享元对象的应用程序无法修改享元内部的数据，因为要保证享元对象是共享的，创建和管理享元对象必须由享元工厂负责
- 享元工厂（Flyweight Factory）：负责创建和管理享元对象，可以采用单例模式进行设计

类图如下所示

![](../../image/flyweight.png)

### 代码
创建若干个A6轿车和A4轿车，轿车的长宽高都相同，颜色和功率不同

享元接口
```java
public interface Flyweight {
    double getHeight();

    double getWidth();

    double getLength();

    void printMess(String mess);
}
```

享元工厂
```java
public class FlyweightFactroy {
    private HashMap<String, Flyweight> hashMap;
    static FlyweightFactroy factroy = new FlyweightFactroy();

    private FlyweightFactroy() {
        hashMap = new HashMap<>();
    }

    public static FlyweightFactroy getFactroy() {
        return factroy;
    }

    public synchronized Flyweight getFlyweight(String key) {
        if (hashMap.containsKey(key))
            return hashMap.get(key);
        else {
            double width = 0, height = 0, length = 0;
            String[] str = key.split("#");
            width = Double.parseDouble(str[0]);
            height = Double.parseDouble(str[1]);
            length = Double.parseDouble(str[2]);
            Flyweight ft = new ConcreteFlyweight(width, height, length);
            hashMap.put(key, ft);
            return ft;
        }
    }

    class ConcreteFlyweight implements Flyweight {
        private double width;
        private double height;
        private double length;

        private ConcreteFlyweight(double width, double height, double length) {
            this.width = width;
            this.height = height;
            this.length = length;
        }

        @Override
        public double getHeight() {
            return height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getLength() {
            return length;
        }

        @Override
        public void printMess(String mess) {
            System.out.print(mess);        //输出外部数据mess
            System.out.print(" 宽度：" + width);  //输出内部数据width
            System.out.print(" 高度：" + height);
            System.out.println("长度：" + length);
        }
    }
}
```


具体享元

```java
public class Car {
    //存放享元对象的引用
    Flyweight flyweight;
    String name, color;
    int power;

    Car(Flyweight flyweight, String name, String color, int power) {
        this.flyweight = flyweight;
        this.name = name;
        this.color = color;
        this.power = power;
    }

    public void print() {
        System.out.print(" 名称：" + name);
        System.out.print(" 颜色：" + color);
        System.out.print(" 功率：" + power);
        System.out.print(" 宽度：" + flyweight.getWidth());
        System.out.print(" 高度：" + flyweight.getHeight());
        System.out.println("长度：" + flyweight.getLength());

    }
}
```

实际使用
```java
public class Application {
    public static void main(String args[]) {
        FlyweightFactroy factroy = FlyweightFactroy.getFactroy();
        double width = 1.82, height = 1.47, length = 5.12;
        String key = "" + width + "#" + height + "#" + length;
        Flyweight flyweight = factroy.getFlyweight(key);
        Car audiA6One = new Car(flyweight, "奥迪A6", "黑色", 128);
        Car audiA6Two = new Car(flyweight, "奥迪A6", "灰色", 160);
        audiA6One.print();
        audiA6Two.print();
        width = 1.77;
        height = 1.45;
        length = 4.63;
        key = "" + width + "#" + height + "#" + length;
        flyweight = factroy.getFlyweight(key);
        Car audiA4One = new Car(flyweight, "奥迪A4", "蓝色", 126);
        Car audiA4Two = new Car(flyweight, "奥迪A4", "红色", 138);
        // 向享元传递外部数据
        flyweight.printMess(" 名称：奥迪A4 颜色：蓝色 功率：126");
        flyweight.printMess(" 名称：奥迪A4 颜色：红色 功率：138");
    }
}
```

### 优点

- 使用享元可以节省内存的开销，特别适合处理大量细粒度对象，这些对象的许多属性值是相同的，而且一旦创建则不容许修改。
- 享元模式中的享元可以使用方法的参数接受外部状态中的数据，但外部状态数据不会干扰到享元中的内部数据，这就使得享元可以在不同的环境中被共享。


### 适用场景
- 一个应用需要创建大量的对象，但是大量的对象之间的属性都是相同的
- 对象的多数状态都可以变为外部状态，可以考虑作为享元去使用

### 案例

创建化合物

氢氧化合物都是有氢元素和氧元素组成，但是元素的个数不同，采用享元模式设计实现