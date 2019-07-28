package strategy;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Application {
    public static void main(String[] args) {
        GymnasticsContext context = new GymnasticsContext();
        context.setStrategy(new StrategyOne());
        double[] a = {1,2,3,4,5,6,7,8};
        context.getPersonScore(a);
    }
}
