package strategy;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class GymnasticsContext {
    ComputableStrategy strategy;
    public void setStrategy(ComputableStrategy strategy){
        this.strategy = strategy;
    }
    public double getPersonScore(double[] a){
        if(strategy !=null){
            return strategy.computer(a);
        }else{
            return 0;
        }
    }
}
