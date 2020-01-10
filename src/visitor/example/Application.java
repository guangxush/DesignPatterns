package visitor.example;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: guangxush
 * @create: 2020/01/10
 */
public class Application {
    public static void main(String args[]) {
        Visitor armyVisitor = new ArmyVisitor();
        Visitor factoryVisitor = new FactoryVisitor();
        ArrayList<Person> personList = new ArrayList<Person>();
        Person person;
        personList.add(new Man("张三", 1.56, 1.2));
        personList.add(new Man("李强", 1.76, 1.5));
        personList.add(new Man("张军", 1.86, 1.3));
        personList.add(new Woman("江萍萍", 1.62, 1.2, 67));
        personList.add(new Woman("孙利娟", 1.67, 1.5, 70));
        personList.add(new Woman("刘小花", 1.42, 0.9, 70));
        Iterator<Person> iter = personList.iterator();
        while (iter.hasNext()) {
            person = iter.next();
            person.accept(armyVisitor);
            person.accept(factoryVisitor);
        }
    }
}
