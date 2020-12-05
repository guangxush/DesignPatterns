### 模板方法

定义一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

### 回调方法

首先使用下面的案例理解下回调操作和正常操作的区别：
```java
public class CallbackExample1 {
    /**
     * 回调接口
     */
    private interface Response {
        void onSuccess(String data);
        void onFailed(String prompt);
    }

    /**
     * 正常模式完成操作
     * @return
     */
    private static String doSomething() {
        try {
            System.out.println("开始操作...");
            //模拟耗时操作（如网络请求），操作正常返回"Success"，"Success"表示有效的数据
            Thread.sleep(3000);
            return "Success";
        } catch (InterruptedException ex) {
            Logger.getLogger(CallbackExample1.class.getName()).log(Level.SEVERE, null, ex);
            //操作出现问题返回"Failed"，"Failed"包含错误提示，如错误码等
            return "Failed";
        }
    }

    /**
     * 使用回调函数完成操作
     * @param response
     */
    private static void callbackDoSomething(Response response) {
        try {
            System.out.println("开始操作...");
            Thread.sleep(3000);
            response.onSuccess("Success");
        } catch (InterruptedException ex) {
            Logger.getLogger(CallbackExample1.class.getName()).log(Level.SEVERE, null, ex);
            response.onFailed("Failed");
        }
    }

    public static void main(String[] args) {
        System.out.println("正常模式 ------ " + doSomething());

        callbackDoSomething(new Response() {
            @Override
            public void onSuccess(String data) {
                System.out.println("回调模式 ------ " + data);
            }

            @Override
            public void onFailed(String prompt) {
                System.err.println("错误提示：" + prompt);
            }

        });
    }
}
```

#### 案例代码

1. 定义抽象模板类

```java
public abstract class AbstractClass {
    // 共同的且繁琐的操作
    private void baseOperation() {
        // do something
    }

    // 由子类定制的操作
    protected abstract void customOperation();

    // 模板方法定义的框架
    public final void templateMethod() {
        baseOperation();
        customOperation();
    }
}
```

2. 定义子类实现类

```java
public class ConcreteClassOne extends AbstractClass{
    @Override
    protected void customOperation() {
        // do custom things
    }
}
```

3. 使用模板

```java
public class Client {
    public static void main(String[] args) {
        AbstractClass c1  = new ConcreteClassOne();
        AbstractClass c2  = new ConcreteClassTwo();
        applyTemplate(c1);
    }

    public static void applyTemplate(AbstractClass abstractClass) {
        abstractClass.templateMethod();
    }
}
```

#### 优缺点分析

1. 优点

a. 封装不变部分，扩展可变部分，把认为是不变部分的算法封装到父类实现，而可变部分的则可以通过继承来继续扩展。

b. 提取公共部分代码，便于维护

c. 符合开闭原则，行为由父类控制，而基本方法是由子类实现的，因此子类可以通过扩展的方式增加相应的功能。

2. 缺点

a. 由子类实现，子类执行的结果影响了父类的结果，也就是子类对父类产生了影响。

b. 可能引起子类泛滥和为了继承而继承的问题。

#### 模板方法结合回调函数

1. 创建final模板类
```java
public final class Template {
    private void baseOperation() {
        // do  something
    }

    public void templateMethod(Callback callback) {
        baseOperation();
        callback.customOperation();
    }
}
```

2. 编写回调接口
```java
public interface Callback {
    void customOperation();
}
```

3. 实现回调接口
```java
public class SubCallback implements Callback{
    @Override
    public void customOperation() {
        // do custom things
    }
}
```

4. 使用模板
```java
public class Client {
    public static void main(String[] args) {
        Template template = new Template();
        applyTemplate(template);
    }

    public static void applyTemplate(Template template) {
        Callback c1  = new SubCallback();
        template.templateMethod(c1);
    }
}
```


这里我们可以看到，结合回调函数以后，Template是一个final类，无法被继承（没有继承的必要），也就不存在子类行为影响父类结果的问题，而Callback是一个接口，为了继承而继承的问题消失了。


     
