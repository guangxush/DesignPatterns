package refactor.one.three;

/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public class RegularPrice extends Price{
    @Override
    int getPriceCode() {
        return MovieThree.REGULAR;
    }
    @Override
    double getCharge(int daysRented){
        double result = 2;
        if(daysRented>2){
            result = (daysRented-2)*1.5;
        }
        return result;
    }
}
