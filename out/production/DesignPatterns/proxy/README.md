### 代理模式

为其他对象提供一种代理以控制对这个对象的访问。

代理模式是为对象提供一个代理，代理可以控制对它所代理的对象的访问。 

代理模式最常见的两种情况：远程代理和虚拟代理。 


### 结构

- 抽象主题（Subject） 该接口是对象和它的代理共同的接口。
- 实际主题（RealSubject） 实际主题是实现抽象主题接口的类，是代理角色实例所要代理的对象。
- 代理（Proxy） 是实现抽象主题接口的类，可以控制对他所包含的角色的实例的访问。

如图所示：

![](../../image/proxy.png)

### 代码

抽象主题的角色是Geometry接口, 用来计算面积

```java
public interface Geometry {
    double getArea();
}
```

具体模板, 计算面积

```java
public class Triangle implements Geometry {
    double sideA, sideB, sideC, area;

    public Triangle(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 2.0;
        area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        return area;
    }
}

```

代理,让代理对象掉用getArea()方法

```java
public class TriangleProxy implements Geometry {
    double sideA, sideB, sideC;
    Triangle triangle;

    public void setABC(double a, double b, double c) {
        sideA = a;
        sideB = b;
        sideC = c;
    }

    @Override
    public double getArea() {
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            triangle = new Triangle(sideA, sideB, sideC);
            //让所代理的对象调用getArea()方法
            double area = triangle.getArea();
            return area;
        } else {
            return -1;
        }
    }
}
```

应用
```java
public class Application {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入三个数，每输入一个数回车确认");
        double a = -1, b = -1, c = -1;
        a = reader.nextDouble();
        b = reader.nextDouble();
        c = reader.nextDouble();
        TriangleProxy proxy = new TriangleProxy();
        proxy.setABC(a, b, c);
        double area = proxy.getArea();
        System.out.println("面积是：" + area);
    }
}
```

### Java在RMI中如何使用代理模式



### 优缺点

- 代理模式可以屏蔽用户真正请求的对象，使用户程序和真正的对象之间解耦。
- 使用代理来担当那些创建耗时的对象的替身。


### 适用场景

- 程序可能不希望用户直接访问该对象，而是提供一个特殊的对象控制对当前对象的访问
- 如果一个对象需要很长时间才能加载完成
- 对象位于远程主机，需要为用户提供访问远程对象的能力


### 案例

使用远程代理让用户使用远程机器阅读文件内容


