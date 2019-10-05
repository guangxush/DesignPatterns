package refactor.one.two;

import refactor.one.old.Movie;

/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public class RentalTwo {
    private MovieTwo movie;
    private int dayRented;

    public RentalTwo(MovieTwo movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public MovieTwo getMovie() {
        return movie;
    }

    public void setMovie(MovieTwo movie) {
        this.movie = movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public void setDayRented(int dayRented) {
        this.dayRented = dayRented;
    }

    public double getCharge(){
        return movie.getCharge(dayRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(dayRented);
    }
}
