package factory.product;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class RedPenCore extends PenCore{

    public RedPenCore(){
        color = "red";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("write with "+ color+ ": "+s);
    }
}
