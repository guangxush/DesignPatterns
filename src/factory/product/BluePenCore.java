package factory.product;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class BluePenCore extends PenCore{

    public BluePenCore(){
        color = "blue";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("write with "+ color+ ": "+s);
    }
}