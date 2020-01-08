package prototype.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Cubic implements Prototype, Cloneable{
    double  length,width,height;
    Cubic(double a,double b,double c){
        length=a;
        width=b;
        height=c;
    }
    @Override
    public Object cloneMe() throws CloneNotSupportedException{
        //调用从Object类继承的clone()方法
        Cubic object=(Cubic)clone();
        return object;
    }
}
