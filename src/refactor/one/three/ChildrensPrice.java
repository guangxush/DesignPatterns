package refactor.one.three;

import refactor.one.old.Movie;

/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public class ChildrensPrice extends Price{
    @Override
    int getPriceCode() {
        return MovieThree.CHILDRENS;
    }
    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result = (daysRented - 3) * 1.5;
        }
        return result;
    }
}
