package refactor.one.three;

import refactor.one.old.Movie;

/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRental) {
        return 1;
    }
}
