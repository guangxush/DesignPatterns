package decorator;

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
public class Application {
    public void needBird(Bird bird) {
        int flyDistance = bird.fly();
        System.out.println("可以飞行" + flyDistance + "米");
    }

    public static void main(String[] args) {
        Application client = new Application();
        Bird sparrow = new Sparrow();
        // 飞行150
        Bird sparrowDecorator1 = new SparrowDecorator(sparrow);
        // 飞行150
        Bird sparrowDecorator2 = new SparrowDecorator(sparrowDecorator1);
        client.needBird(sparrowDecorator1);
        client.needBird(sparrowDecorator2);
    }
}
