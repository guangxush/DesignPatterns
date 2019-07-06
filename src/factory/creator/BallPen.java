package factory.creator;

import factory.product.PenCore;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public abstract class BallPen {
    BallPen(){
        System.out.println("create the pen with the "+ getPenCore().color+".");
    }

    public abstract PenCore getPenCore();
}
