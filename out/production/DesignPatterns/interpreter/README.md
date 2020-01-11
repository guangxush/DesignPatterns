### 解释器模式
给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。


### 结构
- 抽象表达式（AbstractExpression） 负责定义抽象的解释角色
- 终结符表达式子（TerminalExpression） 实现AbstractExpression接口，该类将接口中的解释操作实现为与文法中的终结符相关联的操作
- 非终结符表达式子（NonterminalExpression） 实现AbstractExpression的类，为文法的非终结符实现解释操作
- 上下文（Context） 包含解释器之外的一些全局信息

![](../../image/interpreter.png)

结构描述
1. 解析出语句的动作标记token
2. 将标记规约为动作action
3. 执行动作

### 代码

简单的英文翻译器

抽象表达式
Node
```java
public interface Node {
    void parse(Context text);
    void execute();
}
```

终结符表达式

SubjectPronounOrNounNode
```java
public class SubjectPronounOrNounNode implements Node {
    String[] word = {"You", "He", "Teacher", "Student"};
    String token;
    boolean boo;

    @Override
    public void parse(Context context) {
        token = context.nextToken();
        int i = 0;
        for (i = 0; i < word.length; i++) {
            if (token.equalsIgnoreCase(word[i])) {
                boo = true;
                break;
            }
        }
        if (i == word.length)
            boo = false;
    }

    @Override
    public void execute() {
        if (boo) {
            if (token.equalsIgnoreCase(word[0]))
                System.out.print("你");
            if (token.equalsIgnoreCase(word[1]))
                System.out.print("他");
            if (token.equalsIgnoreCase(word[2]))
                System.out.print("老师");
            if (token.equalsIgnoreCase(word[3]))
                System.out.print("学生");
        } else {
            System.out.println("不是该语言中的句子");
            //System.exit(0);
        }
    }

}
```

ObjectPronounOrNounNode
```java
public class ObjectPronounOrNounNode implements Node {
    String[] word = {"Me", "Him", "Tiger", "Apple"};
    String token;
    boolean boo;

    @Override
    public void parse(Context context) {
        token = context.nextToken();
        int i = 0;
        for (i = 0; i < word.length; i++) {
            if (token.equalsIgnoreCase(word[i])) {
                boo = true;
                break;
            }
        }
        if (i == word.length)
            boo = false;
    }

    @Override
    public void execute() {
        if (boo) {
            if (token.equalsIgnoreCase(word[0]))
                System.out.print("我");
            if (token.equalsIgnoreCase(word[1]))
                System.out.print("他");
            if (token.equalsIgnoreCase(word[2]))
                System.out.print("老虎");
            if (token.equalsIgnoreCase(word[3]))
                System.out.print("苹果");
        } else {
            System.out.print(token + "(不是该语言中的句子)");
        }
    }
}
```

VerbNode
```java
public class VerbNode implements Node {
    String[] word = {"Drink", "Eat", "Look", "beat"};
    String token;
    boolean boo;

    @Override
    public void parse(Context context) {
        token = context.nextToken();
        int i = 0;
        for (i = 0; i < word.length; i++) {
            if (token.equalsIgnoreCase(word[i])) {
                boo = true;
                break;
            }
        }
        if (i == word.length)
            boo = false;
    }

    @Override
    public void execute() {
        if (boo) {
            if (token.equalsIgnoreCase(word[0]))
                System.out.print("喝");
            if (token.equalsIgnoreCase(word[1]))
                System.out.print("吃");
            if (token.equalsIgnoreCase(word[2]))
                System.out.print("看");
            if (token.equalsIgnoreCase(word[3]))
                System.out.print("打");
        } else {
            System.out.print(token + "(不是该语言中的句子)");
        }
    }
}
```

非终结符表达式

SentenceNode
```java
public class SentenceNode implements Node {
    Node subjectNode, predicateNode;

    @Override
    public void parse(Context context) {
        subjectNode = new SubjectNode();
        predicateNode = new PredicateNode();
        subjectNode.parse(context);
        predicateNode.parse(context);
    }

    @Override
    public void execute() {
        subjectNode.execute();
        predicateNode.execute();
    }
}
```

SubjectNode
```java
public class SubjectNode implements Node {
    Node node;

    @Override
    public void parse(Context context) {
        node = new SubjectPronounOrNounNode();
        node.parse(context);
    }

    @Override
    public void execute() {
        node.execute();
    }
}
```

PredicateNode
```java
public class PredicateNode implements Node {
    Node verbNode, objectNode;

    @Override
    public void parse(Context context) {
        verbNode = new VerbNode();
        objectNode = new ObjectNode();
        verbNode.parse(context);
        objectNode.parse(context);
    }

    @Override
    public void execute() {
        verbNode.execute();
        objectNode.execute();
    }
}
```

上下文
```java
public class Context {
    StringTokenizer tokenizer;
    String token;

    public Context(String text) {
        setContext(text);
    }

    public void setContext(String text) {
        tokenizer = new StringTokenizer(text);
    }

    String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
        } else
            token = "";
        return token;
    }
}
```

应用
```java
public class Application {
    public static void main(String args[]) {
        String text = "Teacher beat tiger";
        Context context = new Context(text);
        Node node = new SentenceNode();
        node.parse(context);
        node.execute();
        text = "You eat  apple";
        context.setContext(text);
        System.out.println();
        node.parse(context);
        node.execute();
        text = "you look  him";
        context.setContext(text);
        System.out.println();
        node.parse(context);
        node.execute();
    }
}
```


### 优缺点
- 将每一个语法规则表示成一个类，方便于实现简单的语言。
- 由于使用类表示语法规则，可以较容易改变或扩展语言的行为。
- 通过在类结构中加入新的方法，可以在解释的同时增加新的行为。

### 适用场景

- 一个简单的语言需要解释执行，可以将语言中的规则表示为一个类时，可以用解释器模式
- 如果文法过于复杂，那么过多的文法规则很难维护出所给的类

### 案例

英文翻译器
