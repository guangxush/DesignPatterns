package factory.creator;

import factory.product.BluePenCore;
import factory.product.PenCore;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class BlueBallPen extends BallPen{

    @Override
    public PenCore getPenCore(){
        return new BluePenCore();
    }
}
