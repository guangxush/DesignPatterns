package strategy;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class StrategyOne implements ComputableStrategy{
    @Override
    public double computer(double[] a) {
        double score = 0, sum = 0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        score = sum/a.length;
        return score;
    }
}
