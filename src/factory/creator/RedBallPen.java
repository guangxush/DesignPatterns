package factory.creator;

import factory.product.PenCore;
import factory.product.RedPenCore;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class RedBallPen extends BallPen{

    @Override
    public PenCore getPenCore(){
        return new RedPenCore();
    }
}
