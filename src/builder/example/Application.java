package builder.example;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Application {
    public static void main(String args[]){
        Builder builder=new ChineseCalnederBuilder();
        Director director=new Director(builder,2020,3);
        director.constructProduct();
        builder=new AmericanCalnederBuilder();
        director=new Director(builder,2020,3);
        director.constructProduct();
    }
}
