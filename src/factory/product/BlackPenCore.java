package factory.product;

/**
 * @author: guangxush
 * @create: 2019/07/06
 */
public class BlackPenCore extends PenCore{

    public BlackPenCore(){
        color = "black";
    }

    @Override
    public void writeWord(String s) {
        System.out.println("write with "+ color+ ": "+s);
    }
}
