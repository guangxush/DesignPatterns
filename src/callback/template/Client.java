package callback.template;

/**
 * @author: guangxush
 * @create: 2020/10/11
 */
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
