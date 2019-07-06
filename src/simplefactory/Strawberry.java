package simplefactory;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class Strawberry implements Fruit{

    @Override
    public void grow() {
        log("Strawberry is growing.");
    }

    @Override
    public void harvest() {
        log("Strawberry has been harvested.");
    }

    @Override
    public void plant() {
        log("Strawberry has been planted.");
    }

    public static void log(String msg)
    {
        System.out.println(msg);
    }
}
