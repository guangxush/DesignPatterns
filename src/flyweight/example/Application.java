package flyweight.example;

/**
 * @author: guangxush
 * @create: 2020/01/09
 */
public class Application {
    public static void main(String args[]) {
        ElementFactory factory = ElementFactory.getFactory();
        String key = "CO", name;
        int number1, number2;
        Element element = factory.getElement(key);
        number1 = 1;
        number2 = 2;
        name = "二氧化碳";
        Compound compound = new Compound(element, name, number1, number2);
        element.printMess(name, number1, number2);
        number1 = 1;
        number2 = 1;
        name = "一氧化碳";
        compound = new Compound(element, name, number1, number2);
        element.printMess(name, number1, number2);
        key = "HO";
        element = factory.getElement(key);
        number1 = 2;
        number2 = 1;
        name = "水";
        compound = new Compound(element, name, number1, number2);
        element.printMess(name, number1, number2);
        number1 = 2;
        number2 = 2;
        name = "过氧化氢";
        compound = new Compound(element, name, number1, number2);
        element.printMess(name, number1, number2);
    }
}
