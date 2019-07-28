package strategy;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2019/07/28
 */
public class StragegyThree implements ComputableStrategy{
    @Override
    public double computer(double[] a) {
        if(a.length<=2){
            return 0;
        }
        double score =0,sum = 0;
        Arrays.sort(a);
        for(int i=1;i<a.length-1;i++){
            sum+=a[i];
        }
        score = sum/(a.length-2);
        return score;
    }
}
