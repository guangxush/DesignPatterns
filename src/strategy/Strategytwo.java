package strategy;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class Strategytwo implements ComputableStrategy{
    @Override
    public double computer(double[] a) {
        double score, n = a.length, multi = 1;
        for(int i=0;i<a.length;i++){
            multi*=a[i];
        }
        score = Math.pow(multi, 1.0/n);
        return score;
    }
}
