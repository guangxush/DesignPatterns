package factory;

import factory.creator.BallPen;
import factory.creator.BlackBallPen;
import factory.creator.BlueBallPen;
import factory.creator.RedBallPen;
import factory.product.PenCore;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class Application {
    public static void main(String[] args) {
        PenCore penCore;
        BallPen ballPen = new BlueBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("你好");

        ballPen = new RedBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("Hello");

        ballPen = new BlackBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("ni hao!");
    }
}
