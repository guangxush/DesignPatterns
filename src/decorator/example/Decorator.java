package decorator.example;

/**
 * @author: guangxush
 * @create: 2020/01/07
 */
public abstract class Decorator extends ReadWord{

    protected ReadWord reader;

    public Decorator(){

    }

    public Decorator(ReadWord reader){
        this.reader = reader;
    }
}
