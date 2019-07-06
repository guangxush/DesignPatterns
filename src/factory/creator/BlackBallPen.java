package factory.creator;

import factory.product.BlackPenCore;
import factory.product.PenCore;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class BlackBallPen extends BallPen{

    @Override
    public PenCore getPenCore(){
        return new BlackPenCore();
    }
}
