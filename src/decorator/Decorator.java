package decorator;

/**
 * @author: guangxush
 * @create: 2019/07/07
 */
public abstract class Decorator extends Bird {
    protected Bird bird;
    public Decorator(){

    }

    public Decorator(Bird bird){
        this.bird = bird;
    }
}
