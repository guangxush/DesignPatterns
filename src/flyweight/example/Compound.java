package flyweight.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Compound {
    Element element;    //存放享元对象的引用
    String name;
    int number1, number2;

    Compound(Element element, String name, int number1, int number2) {
        this.element = element;
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
    }
}
