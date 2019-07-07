package decorator;

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
public class Sparrow extends Bird{
    public final int DISTANCE = 50;

    @Override
    public int fly(){
        return DISTANCE;
    }
}
