package decorator;

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
public class SparrowDecorator extends Decorator{

    public final int DISTANCE = 50;

    public SparrowDecorator(Bird bird){
        super(bird);
    }

    @Override
    public int fly() {
        int distance = 0;
        // 委托被装饰着bird调用fly(),然后在调用eleFly()
        distance = bird.fly()+eleFly();
        return distance;
    }

    /**
     * 装饰者添加新的方法
     * @return
     */
    private int eleFly(){
        // 飞行50
        return DISTANCE;
    }
}
