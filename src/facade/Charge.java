package facade;

/**
 * @author: guangxush
 * @create: 2020/01/08
 */
public class Charge {
    public final int basicCharge = 12;
    CheckWord checkWord;

    public Charge(CheckWord checkWord) {
        this.checkWord = checkWord;
    }

    public void giveCharge(){
        int charge = checkWord.getAmount()*basicCharge;
        System.out.println("广告费用："+charge+"元");
    }
}
