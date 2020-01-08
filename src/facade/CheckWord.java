package facade;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class CheckWord {
    public final int basicAmount = 85;
    String advertisement;
    int amount;

    public CheckWord(String advertisement) {
        this.advertisement = advertisement;
    }

    public void setChargeAmount(){
        amount = advertisement.length() + basicAmount;
    }

    public int getAmount(){
        return amount;
    }
}
