package refactor.one.three;


/**
 * @author: guangxush
 * @create: 2019/10/05
 */
public class RentalThree {
    private MovieThree movie;
    private int dayRented;

    public RentalThree(MovieThree movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public MovieThree getMovie() {
        return movie;
    }

    public void setMovie(MovieThree movie) {
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
